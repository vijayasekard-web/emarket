package com.onemove.util;

import org.hibernate.Session;

public class SessionHandler {
	private static Session session;

	public static Session getSession(){
		if(session == null || !session.isOpen()){
			session = HibernateSessionManager.getSessionFactory().openSession();
			session.beginTransaction();
			return session;
		}else{
			return session;
		}

	}

	public static void closeSession(){
		session.clear();
		session.flush();
		session.close();	
	}
}
