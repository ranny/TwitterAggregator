package model;

public class User {

	private long userId;
	private String screenName;
	private String name;
	private String description;
	private int followersCount;
	private int friendsCount;
	private boolean isVerified;
	private String profilePictURL;
	
	public User(long userId, String screenName, String name, String description, int followersCount, int friendsCount,
			boolean isVerified, String profilePictUrl) throws Exception{
		this.userId = userId;
		this.screenName = screenName;
		this.name = name;
		this.description = description;
		this.followersCount = followersCount;
		this.friendsCount = friendsCount;
		this.isVerified = isVerified;
		this.profilePictURL = profilePictUrl;
	}
	
	public User() {
		
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId= userId;
	}
	
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	
	public int getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}
	
	public boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public String getProfilePictURL() {
		return profilePictURL;
	}

	public void setProfilePictURL(String profilePictURL) {
		this.profilePictURL = profilePictURL;
	}
	
}
