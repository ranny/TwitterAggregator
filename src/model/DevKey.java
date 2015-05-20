package model;

public class DevKey {

	static String TWITTER_CONSUMER_KEY = "lUo7a08DNZbmymzX6P98Q";
    static String TWITTER_CONSUMER_SECRET = "Kg1fn9RTkgerxvTMbLFBxtywGQ0IiEkR9AKsg1ok5Bs";
 
    static String PREFERENCE_NAME = "twitter_oauth";
    static final String PREF_KEY_OAUTH_TOKEN = "oauth_token";
    static final String PREF_KEY_OAUTH_SECRET = "oauth_token_secret";
    static final String PREF_KEY_TWITTER_LOGIN = "isTwitterLogedIn";
 
    static final String TWITTER_CALLBACK_URL = "oauth://tiBOX";
 
    static final String URL_TWITTER_AUTH = "auth_url";
    static final String URL_TWITTER_OAUTH_VERIFIER = "oauth_verifier";
    static final String URL_TWITTER_OAUTH_TOKEN = "oauth_token";
    
	public static String getTWITTER_CONSUMER_KEY() {
		return TWITTER_CONSUMER_KEY;
	}
	
	public static String getTWITTER_CONSUMER_SECRET() {
		return TWITTER_CONSUMER_SECRET;
	}
	
	public static String getPREFERENCE_NAME() {
		return PREFERENCE_NAME;
	}
	
	public static String getPrefKeyOauthToken() {
		return PREF_KEY_OAUTH_TOKEN;
	}
	
	public static String getPrefKeyOauthSecret() {
		return PREF_KEY_OAUTH_SECRET;
	}
	
	public static String getPrefKeyTwitterLogin() {
		return PREF_KEY_TWITTER_LOGIN;
	}
	
	public static String getTwitterCallbackUrl() {
		return TWITTER_CALLBACK_URL;
	}
	
	public static String getUrlTwitterAuth() {
		return URL_TWITTER_AUTH;
	}
	
	public static String getUrlTwitterOauthVerifier() {
		return URL_TWITTER_OAUTH_VERIFIER;
	}
	
	public static String getUrlTwitterOauthToken() {
		return URL_TWITTER_OAUTH_TOKEN;
	}
	
}
