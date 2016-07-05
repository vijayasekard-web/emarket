package com.onemove.authenticate;

import com.onemove.constants.ApplicationConstants;
import com.onemove.exception.InvalidPasswordException;
import com.onemove.model.Corporations;
import com.onemove.model.PortalUsers;
import com.onemove.model.ResultSet;
import com.onemove.model.UserPasswords;
import com.onemove.util.AuthenticationUtil;
import com.onemove.util.CRUDHandler;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class AuthenticationController {

	final static Logger logger = Logger.getLogger(AuthenticationController.class);


	public static ResultSet authenticateUser(HttpServletRequest requestContext,String userName, String password, String sourceIp, int appCode){

		ResultSet result = new ResultSet();
		Corporations corporation = null;
		PortalUsers portalUser = CRUDHandler.getPortalUser(userName);
		if(portalUser != null){
			logger.info("the Username Exists : " + userName);
			result.setUserName(userName);
			result.setFirstName(portalUser.getFirstName());
			result.setLastName(portalUser.getLastName());
			// Check for corporation
			int corporationId = portalUser.getCorporationId();
			corporation = CRUDHandler.getCorporation(corporationId);
			if(corporation != null){
				result.setCorporationId(corporationId);
				result.setEmail(corporation.getEmail());
				result.setCorporationLogoURL(null);
			}

			System.out.println("Corporation is " + corporation.getCompanyName());

			if(portalUser.getPassword()!= null){
				String hashedPassword = AuthenticationUtil.getHashedPassword(password, portalUser.getPasswordSalt());
				System.out.println("Hashed is " + hashedPassword);
				System.out.println("Portal Password is " + portalUser.getPassword());
				// Check for Locked Account
				if(AuthenticationUtil.isAccountLocked(portalUser)){
					result.setSuccess(false);
					result.setFailureCode(ApplicationConstants.ACCOUNT_LOCKED);
					result.setFailureMessage("Account Locked");
					logger.info("Account Locked for  : " + userName);
					return result;
				}
				// Check for Inactive Account

				// Check for Expired Password

				// Compare Passwords for Authentication
				if(AuthenticationUtil.comparePasswords(hashedPassword, portalUser.getPassword())){
					result.setSuccess(true);
					AuthenticationUtil.resetAttempts(portalUser);
				}
				else{
					result.setSuccess(false);
					result.setFailureCode(ApplicationConstants.CREDENTIALS_INVALID);
					result.setFailureMessage("Incorrect Username/Password");
					portalUser = AuthenticationUtil.updateAttempts(portalUser);
					logger.info("Password Mismatch for  : " + userName);
				}
			}else{
				result.setSuccess(false);
				result.setFailureMessage("ApplicationConstants.CREDENTIALS_INVALID");
				logger.fatal("Passowrd empty for  : " + userName);
			}
		}else{
			result.setSuccess(false);
			result.setFailureCode(ApplicationConstants.NO_SUCH_USER);
			result.setFailureMessage("No Such User");
			logger.info("No such user available with username : " + userName);
		}
		AuthenticationUtil.logRequest(requestContext, result, portalUser, corporation, sourceIp, appCode );
		return result;
	}

	public static ResultSet updatePassword(String username, String password){
		ResultSet resultSet = new ResultSet();
		PortalUsers existingUser = null;
		try {
			existingUser = AuthenticationUtil.updatePassword(username, password);
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			resultSet.setSuccess(false);
			resultSet.setFailureMessage( e.getMessage() + username);
			return resultSet;
		}

		boolean result = CRUDHandler.updatePortalUser(existingUser);
		if(result){
			UserPasswords userPassword = new UserPasswords(existingUser.getUserId(), existingUser.getPassword(), existingUser.getPasswordSalt());
			CRUDHandler.addUserPasswords(userPassword);
			AuthenticationUtil.deleteHistoricPasswordEntry(existingUser.getUserId());
			resultSet.setSuccess(true);	
		}
		return resultSet;
	}
}
