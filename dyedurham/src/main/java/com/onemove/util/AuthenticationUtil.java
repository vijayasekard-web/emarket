package com.onemove.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.onemove.authenticate.AuthenticationController;
import com.onemove.constants.ApplicationConstants;
import com.onemove.exception.InvalidPasswordException;
import com.onemove.model.Corporations;
import com.onemove.model.LoginRequests;
import com.onemove.model.PortalUsers;
import com.onemove.model.ResultSet;
import com.onemove.model.UserPasswords;
import com.onemove.model.UserUpdateObject;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.App;
public class AuthenticationUtil {

	final static Logger logger = Logger.getLogger(AuthenticationUtil.class);
	public static String getHashedPassword(String password,String salt){
		if(password != null && salt != null){
			String saltedPassword = salt + password;
			MessageDigest digester;
			String generatedPassword = null;
			try {
				digester = MessageDigest.getInstance("SHA-512");
				byte[] digest = saltedPassword.getBytes(StandardCharsets.US_ASCII);

				for(int j=0;j<ApplicationConstants.HASH_ITERATIONS;j++){
					digester.reset();
					digester.update(digest);
					digest = digester.digest();

					StringBuilder sb = new StringBuilder();
					for(int i=0; i< digest.length ;i++){
						sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
					}
					generatedPassword = sb.toString();
					digest = generatedPassword.getBytes(StandardCharsets.US_ASCII);
				} }catch (NoSuchAlgorithmException e) {
					logger.error("No such algorithm SHA-512", e );
					e.printStackTrace();
				}


			return generatedPassword;
		}
		return null;
	}

	public static boolean comparePasswords(String hashedPassword, String savedPassword){
		if(hashedPassword.equals(savedPassword)){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isAccountLocked(PortalUsers portalUser){

		if(portalUser.getAttempts() >= ApplicationConstants.MAX_NUMBER_OF_LOGIN_ATTEMPTS && portalUser.getLockedAt() != null){
			System.out.println("Attempts is " + portalUser.getAttempts());
			System.out.println("Locked At is " + portalUser.getLockedAt());
			Date currentDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(portalUser.getLockedAt());
			cal.add(Calendar.MINUTE, ApplicationConstants.LOCK_OUT_DURATION);
			Date lock_release_date = cal.getTime();
			if(lock_release_date.after(currentDate)){
				return true;
			}
		}else{
			return false;
		}
		return false;
	}

	public static PortalUsers updateAttempts(PortalUsers portalUser){

		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int currentAttempts = portalUser.getAttempts();
		currentAttempts += 1;
		portalUser.setAttempts(currentAttempts);
		if(currentAttempts >= ApplicationConstants.MAX_NUMBER_OF_LOGIN_ATTEMPTS){
			portalUser.setLockedAt(new Date());
		}
		boolean isUpdated = CRUDHandler.updatePortalUser(portalUser);
		if(!isUpdated){
			// Log INFO
		}
		return portalUser; 
	}
	public static PortalUsers resetAttempts(PortalUsers portalUser){

		portalUser.setAttempts(0);
		portalUser.setLockedAt(null);
		boolean isUpdated = CRUDHandler.updatePortalUser(portalUser);
		if(!isUpdated){
			// Log INFO
		}
		return portalUser; 
	}

	public static void logRequest(HttpServletRequest requestContext, ResultSet result, PortalUsers portalUser, Corporations corporation, String sourceIp, int appCode){
		LoginRequests loginRequest = new LoginRequests();
		loginRequest.setIpAddress(requestContext.getRemoteAddr());
		loginRequest.setSourceIpAddress(sourceIp);
		if(portalUser != null){
			loginRequest.setUserName(portalUser.getUserName());
		}
		if(corporation != null){
			loginRequest.setCorporationId(corporation.getCorporationId());
		}
		loginRequest.setResult(result.isSuccess());
		loginRequest.setFailureCode(result.getFailureCode());
		loginRequest.setAppCode(appCode);
		boolean inserted = CRUDHandler.addLoginRequests(loginRequest);
		if(!inserted){
			logger.error("Login Request failed to insert " + loginRequest.getUserName());
		}

	}

	public static boolean isAdminLoginSuccess(UserUpdateObject userUpdateObject){
		PortalUsers adminUser = CRUDHandler.getPortalUser(userUpdateObject.getAdminUserName());
		String hashedPassword = AuthenticationUtil.getHashedPassword(userUpdateObject.getAdminPassword(),adminUser.getPasswordSalt());
		if(AuthenticationUtil.comparePasswords(hashedPassword, adminUser.getPassword())){
			if(isValidRole(adminUser.getRoleId())){
				return true;
			}else{
				logger.error("Admin does not have permission to do the operation " + adminUser.getUserName());
				return false;
			}

		}else{
			logger.error("Admin Login Failed " + adminUser.getUserName());
			return false;
		}
	}

	public static boolean isAdminLoginSuccess(String adminUserName, String adminPassword){
		PortalUsers adminUser = CRUDHandler.getPortalUser(adminUserName);
		String hashedPassword = AuthenticationUtil.getHashedPassword(adminPassword, adminUser.getPasswordSalt());
		if(AuthenticationUtil.comparePasswords(hashedPassword, adminUser.getPassword())){
			if(isValidRole(adminUser.getRoleId())){
				return true;
			}else{
				logger.error("Admin does not have permission to do the operation " + adminUser.getUserName());
				return false;
			}

		}else{
			logger.error("Admin Login Failed " + adminUser.getUserName());
			return false;
		}
	}

	public static PortalUsers addPassword(PortalUsers portalUser, String password) throws InvalidPasswordException{
		System.out.println("Inside add password" + password);
		if(!isValidRegex(password)){
			throw new InvalidPasswordException("Regex check failed");
		}
		String salt = getRandomSalt();
		System.out.println("Salt is " + salt );
		try{
		String currentPassword = AuthenticationUtil.getHashedPassword(password, salt);
		System.out.println("current password is " + currentPassword);
		portalUser.setPassword(currentPassword);
		portalUser.setPasswordSalt(salt);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Inside Exception in add Password");
		}
		return portalUser;
	}

	public static PortalUsers updatePassword(String username, String password) throws InvalidPasswordException{

		System.out.println("Inside update password" + password);
		if(!isValidRegex(password)){
			throw new InvalidPasswordException("Regex check failed");
		}
		String salt = getRandomSalt();
		PortalUsers existingPortalUser = CRUDHandler.getPortalUser(username);
		if(existingPortalUser != null){
			String currentPassword = AuthenticationUtil.getHashedPassword(password, existingPortalUser.getPasswordSalt());
			if(!currentPassword.equals(existingPortalUser.getPassword())){
				if(checkValidPassword(existingPortalUser.getUserId(), password)){
					String hashedPassword = AuthenticationUtil.getHashedPassword(password, salt);
					existingPortalUser.setPassword(hashedPassword);
					existingPortalUser.setPasswordSalt(salt);
				}else{
					throw new InvalidPasswordException("Password previously used");
				}
			}else{
				throw new InvalidPasswordException("Same Password");
			}
		}
		return existingPortalUser;
	}

	public static boolean checkValidPassword(int portalUserId, String password){
		List<UserPasswords> userPasswords = CRUDHandler.getUserPasswords(portalUserId);
		if(userPasswords == null){
			System.out.println("UserPasswords is NULL");
		}else{
			System.out.println("UserPasswords is not NULL" + userPasswords.size());
		}
		for(UserPasswords userPassword : userPasswords){
			String hashedPassword = AuthenticationUtil.getHashedPassword(password, userPassword.getPasswordSalt());
			System.out.println("Inside Loop ");
			System.out.println("User Password is " + userPassword.getPassword());
			System.out.println("Current password is " + password);
			System.out.println("Hashed password is " + hashedPassword);

			if(userPassword.getPassword().equals(hashedPassword)){
				return false;
			}
		}

		return true;
	}

	public static boolean isValidRole(int roleId){
		if(roleId == ApplicationConstants.SUPERMEMBER || roleId == ApplicationConstants.ADMINISTRATOR || roleId == ApplicationConstants.CONTROLLER){
			return true;
		}else{
			return false;
		}
	}

	public static String getRandomSalt(){
		Random random = new Random();
		String salt = Math.round(random.nextFloat() * Math.pow(10,16))+"."+ Math.round(random.nextFloat() * Math.pow(10,16));
		return salt;
	}

	public static boolean deleteHistoricPasswordEntry(int portalUserId){
		List<UserPasswords> userPasswords = CRUDHandler.getUserPasswords(portalUserId);
		if(userPasswords.size() > ApplicationConstants.NUMBER_OF_HISTORICAL_PASSWORD_STORED){
			UserPasswords firstUserPassword = userPasswords.get(0);
			CRUDHandler.deleteUserPasswords(firstUserPassword);
			logger.info("First entry deleted in User Passwords with id  " + firstUserPassword.getId()+ " for userId " + firstUserPassword.getPortalUserId());
			return true;
		}
		return false;
	}
	
	public static boolean isValidRegex(String password){
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,15}";
		if(password.matches(pattern)){
			return true;
		}else{
			return false;
		}
	}
}
