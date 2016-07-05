package com.onemove.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.onemove.authenticate.AuthenticationController;
import com.onemove.model.Corporations;
import com.onemove.model.LoginRequests;
import com.onemove.model.PortalUsers;
import com.onemove.model.UserPasswords;

public class CRUDHandler {

	final static Logger logger = Logger.getLogger(CRUDHandler.class);
	public static boolean addPortalUser(PortalUsers portalUser){

		try{
			Session session = SessionHandler.getSession();
			session.save(portalUser);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while adding PortalUser: " + portalUser.getUserName());
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}

	public static PortalUsers getPortalUser(String userName){

		Session session = SessionHandler.getSession();
		PortalUsers portalUser = null;
		try{
			String queryString = "from PortalUsers where username = :username";
			Query query = session.createQuery(queryString);
			query.setString("username", userName);
			portalUser = (PortalUsers) query.uniqueResult();
			System.out.println("Username iss " + userName);
			System.out.println("Inside getPortaUser " + portalUser.getUserName());
			return portalUser;
		}catch(Exception e){
			logger.error("Error while getting PortalUser: " + userName);
			e.printStackTrace();
		}finally{
			SessionHandler.closeSession();
		}
		return null;
	}

	public static boolean updatePortalUser(PortalUsers portalUser){
		Session session = SessionHandler.getSession();
		try{
			session.update(portalUser);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while updating PortalUser: " + portalUser.getUserName() + ":" + e);
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}
	
	public static boolean deletePortalUser(PortalUsers portalUser){
		Session session = SessionHandler.getSession();
		try{
			session.delete(portalUser);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while deleting PortalUser: " + portalUser.getUserName() + ":" + e);
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}
	
	public static Corporations addCorporation(Corporations corporation){
		try{
			Session session = SessionHandler.getSession();
			session.save(corporation);
			session.getTransaction().commit();
			return corporation;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while adding Corporation: " + corporation.getCompanyName());
			return null;
		}finally{
			SessionHandler.closeSession();
		}
	}

	public static Corporations getCorporation(int corpId){

		Session session = SessionHandler.getSession();
		Corporations corporation = null;
		try{
			String queryString = "from Corporations where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", corpId);
			corporation = (Corporations) query.uniqueResult();
			return corporation;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while getting PortalUser: " + corpId);
		}finally{
			SessionHandler.closeSession();
		}
		return null;
	}
	
	public static boolean addLoginRequests(LoginRequests loginRequest){
		try{
			Session session = SessionHandler.getSession();
			session.save(loginRequest);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while adding LoginRequest: " + loginRequest.getUserName());
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}
	
	public static boolean addUserPasswords(UserPasswords userPassword){
		try{
			Session session = SessionHandler.getSession();
			session.save(userPassword);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while adding UserPasswords: " + userPassword.getPortalUserId());
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<UserPasswords> getUserPasswords(int portalUserId){

		Session session = SessionHandler.getSession();
		List<UserPasswords> userPasswords  = null;
		try{
			
			System.out.println("portal Id isssss " + portalUserId);
			Criteria cr = session.createCriteria(UserPasswords.class);
			cr.add(Restrictions.eq("portalUserId", portalUserId));
			cr.addOrder(Order.asc("createdAt"));
			userPasswords = (List<UserPasswords>) cr.list();
		
			
			return userPasswords;
		}catch(Exception e){
			logger.error("Error while getting UserPasswords for Portal User Id: " + portalUserId);
			e.printStackTrace();
		}finally{
			SessionHandler.closeSession();
		}
		return null;
	}

	public static boolean updateUserPasswords(UserPasswords userPassword){
		Session session = SessionHandler.getSession();
		try{
			session.update(userPassword);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while updating UserPasswords: " + userPassword.getPortalUserId());
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}
	
	public static boolean deleteUserPasswords(UserPasswords userPassword){
		Session session = SessionHandler.getSession();
		try{
			session.delete(userPassword);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while deleting UserPasswords: " + userPassword.getPortalUserId());
			return false;
		}finally{
			SessionHandler.closeSession();
		}
	}
}
