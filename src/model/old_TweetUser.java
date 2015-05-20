package model;

public class old_TweetUser {
	
	private long userId;
	private String screenName;
	private String name;
	private String description;
	private int followersCount;
	private int friendsCount;
	private boolean isVerified;
	private String profileImageURL;
	
	public old_TweetUser(long userId, String screenName, String name, String description, int followersCount, int friendsCount,
			boolean isVerified, String profileImageURL) throws Exception{
		this.userId = userId;
		this.screenName = screenName;
		this.name = name;
		this.description = description;
		this.followersCount = followersCount;
		this.friendsCount = friendsCount;
		this.isVerified = isVerified;
		this.profileImageURL = profileImageURL;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getProfileImageURL() {
		return profileImageURL;
	}

	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}
	
}
