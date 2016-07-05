package com.onemove.constants;

public class ApplicationConstants {
	public static int   HASH_ITERATIONS = 20;
	public static int	MAX_NUMBER_OF_LOGIN_ATTEMPTS = 6; // Allowed number of login before the account is locked
	public static int	LOCK_OUT_DURATION = 30; // 30 minutes
	public static int	REQUIRED_PASSWORD_CHANGE_INTERVAL = 90; // 90 days
	public static int	NUMBER_OF_HISTORICAL_PASSWORD_STORED = 4; // Password cannot be the same as the previous 4 passwords
	
	public static int  CREDENTIALS_INVALID = 402;
	public static int  ACCOUNT_LOCKED = 403;
	public static int  ACCOUNT_INACTIVE = 404;
	public static int  NO_SUCH_USER = 405;
	
	public static int MEMBER = 1;
	public static int SUPERMEMBER = 2;
	public static int ADMINISTRATOR = 4;
	public static int REPORT = 5;
	public static int CONTROLLER = 6;
	public static int SUPPORT = 7;
	
	
	
}
