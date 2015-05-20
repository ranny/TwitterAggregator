package model;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuth {

	private AccessToken accessToken;
	private ConfigurationBuilder cb;
	
	public Twitter twitter;
	public Twitter twitter2;
	
	public AccessToken getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	
	public void oauthLogin() throws Exception {
		//enable JSONStore
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setJSONStoreEnabled(true);
		
		twitter = new TwitterFactory(cb.build()).getInstance();
		twitter.setOAuthConsumer(DevKey.getTWITTER_CONSUMER_KEY(), DevKey.getTWITTER_CONSUMER_SECRET());
		
		/*START: OAUTH WITHOUT PIN*/
		AccessToken oauthAccessToken = new AccessToken("2401038984-ifcGJt56Iigoj31IL90zgs2BeOMZXjEnL0cMCAZ", "TbFUv7uvjAxvq6ZfzilxL7pStBxmxrQVBMfho8xlXka0p");
		twitter.setOAuthAccessToken(oauthAccessToken);
		/*END*/
		
	}
	
}
