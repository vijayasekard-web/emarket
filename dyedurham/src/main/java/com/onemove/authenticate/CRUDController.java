package com.onemove.authenticate;

import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;

import com.onemove.constants.ApplicationConstants;
import com.onemove.exception.CRUDException;
import com.onemove.exception.InvalidPasswordException;
import com.onemove.model.Corporations;
import com.onemove.model.PortalUsers;
import com.onemove.model.ResultSet;
import com.onemove.model.UserPasswords;
import com.onemove.model.UserUpdateObject;
import com.onemove.util.AuthenticationUtil;
import com.onemove.util.CRUDHandler;

public class CRUDController {
	final static Logger logger = Logger.getLogger(CRUDController.class);
	public static ResultSet addPortalUser(UserUpdateObject userUpdateObject){
		ResultSet resultSet = new ResultSet();
		PortalUsers portalUser = new PortalUsers();
		portalUser = copyPortalUser(portalUser, userUpdateObject);
		try {
			portalUser = AuthenticationUtil.addPassword(portalUser, userUpdateObject.getPassword());
		} catch (InvalidPasswordException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			resultSet.setSuccess(false);
			resultSet.setFailureMessage( e1.getMessage() + portalUser.getUserName());
			return resultSet;
		}
		System.out.println("After Copy call" + portalUser.getUserName() + portalUser.getPassword() + portalUser.getCorporationId());
		try{
			if(portalUser.getUserName() != null && portalUser.getPassword() != null && String.valueOf(portalUser.getCorporationId()) != null){
				System.out.println("inside if after  Copy call" + portalUser.getUserId());
				boolean result = CRUDHandler.addPortalUser(portalUser);
				PortalUsers insertedPortalUser = CRUDHandler.getPortalUser(portalUser.getUserName());
				UserPasswords userPassword = new UserPasswords(insertedPortalUser.getUserId(), insertedPortalUser.getPassword(), insertedPortalUser.getPasswordSalt());
				CRUDHandler.addUserPasswords(userPassword);
				System.out.println("Before result set true");
				resultSet.setSuccess(result);
			}
		}catch(Exception e){
			logger.info("User Can't be added for " + portalUser.getUserName()+ ": " + e);
			//throw new CRUDException("Cannot Add User ";)
		}
		return resultSet;
	}

	public static ResultSet updatePortalUser(UserUpdateObject userUpdateObject){
		ResultSet resultSet = new ResultSet();
		try{	
			PortalUsers existingUser = CRUDHandler.getPortalUser(userUpdateObject.getUserName());
			if(existingUser != null){
				existingUser = copyPortalUser(existingUser, userUpdateObject);
			}else{
				logger.info("No such user to update with username " + userUpdateObject.getUserName());
				resultSet.setSuccess(false);
				resultSet.setFailureMessage("No such User" + userUpdateObject.getUserName());
				return resultSet;
			}
			System.out.println("role id is " + userUpdateObject.getRoleId());
		}catch(Exception e){
			logger.info("User Can't be updated for " + userUpdateObject.getUserName()+ ": " + e);
		}
		return resultSet;
	}

	public static ResultSet deletePortalUser(UserUpdateObject userUpdateObject){
		ResultSet resultSet = new ResultSet();
		try{
			PortalUsers existingUser = CRUDHandler.getPortalUser(userUpdateObject.getUserName());
			if(existingUser != null){
				boolean result = CRUDHandler.deletePortalUser(existingUser);
				resultSet.setSuccess(result);
			}else{
				logger.info("No such user to delete with username " + userUpdateObject.getUserName());
				resultSet.setSuccess(false);
				resultSet.setFailureMessage("No such User " + userUpdateObject.getUserName());
				return resultSet;
			}
		}catch(Exception e){
			logger.info("User Can't be deleted for " + userUpdateObject.getUserName()+ ": " + e);
		}
		return resultSet;
	}

	public static Corporations addCorporation(int corporationCode, String corporationName){
		Corporations corporation = new Corporations();
		corporation.setCorporationCode(corporationCode);
		corporation.setCompanyName(corporationName);
		CRUDHandler.addCorporation(corporation);
		return corporation;
	}

	public static PortalUsers copyPortalUser(PortalUsers existingPortalUser, UserUpdateObject receivedPortalUser){
		if(receivedPortalUser.getFirstName() != null){
			existingPortalUser.setFirstName(receivedPortalUser.getFirstName());
		}
		if(receivedPortalUser.getRoleId() != 0){
			existingPortalUser.setRoleId(receivedPortalUser.getRoleId());   // Need to be verified
		}
		if(receivedPortalUser.getLastName() != null){
			existingPortalUser.setLastName(receivedPortalUser.getLastName());
		}
		if(receivedPortalUser.getEmail() != null){
			existingPortalUser.setEmail(receivedPortalUser.getEmail());
		}
		if(receivedPortalUser.getStartPath() != null){
			existingPortalUser.setStartPath(receivedPortalUser.getStartPath());
		}
		if(receivedPortalUser.getIsConfirmationRequired() != 0){
			existingPortalUser.setIsConfirmationRequired(receivedPortalUser.getIsConfirmationRequired());  // Need to be verified
		}
		if(receivedPortalUser.getConfirmationKey() != null){
			existingPortalUser.setConfirmationKey(receivedPortalUser.getConfirmationKey());
		}
		if(receivedPortalUser.getPasswordChangedAt() != null){
			existingPortalUser.setPasswordChangedAt(receivedPortalUser.getPasswordChangedAt());
		}
		if(receivedPortalUser.getIsPasswordExpired() != null){
			existingPortalUser.setIsPasswordExpired(receivedPortalUser.getIsPasswordExpired()); // Need to be verified
		}
		if(receivedPortalUser.getUserName() != null){
			existingPortalUser.setUserName(receivedPortalUser.getUserName());
		}
		if(receivedPortalUser.getCorporationId() != 0){
			existingPortalUser.setCorporationId(receivedPortalUser.getCorporationId());
		}
		if(receivedPortalUser.getHasAgreedToTerms() == 0){
			existingPortalUser.setHasAgreedToTerms(receivedPortalUser.getHasAgreedToTerms());
		}
		if(receivedPortalUser.getAttempts() != 0){
			existingPortalUser.setAttempts(receivedPortalUser.getAttempts());
		}
		if(receivedPortalUser.getLockedAt() != null){
			existingPortalUser.setLockedAt(receivedPortalUser.getLockedAt());
		}
		return existingPortalUser;
	}




}
