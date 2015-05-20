package model;

import java.sql.SQLException;

public class Tweet {

	private long tweetId;
	private String tweetText;
	private String createdAt;
	private String source;
	private boolean isRetweet;
	private boolean isFavorited;
	private long retweetCount;
	private boolean isTruncated;
	private long userId;
	private long retweetCounted;
	private int label;
	
	private String screenName;
	private String name;
	private String profileImageURL;

	public Tweet(long tweetId, String tweetText, String createdAt, String source, boolean isRetweet, boolean isFavorited,
			long retweetCounted, boolean isTruncated, long userId) throws SQLException, Exception{
		this.tweetId = tweetId;
		this.tweetText = tweetText;
		this.createdAt = createdAt;
		this.source = source;
		this.isRetweet = isRetweet;
		this.isFavorited = isFavorited;
		this.retweetCounted = retweetCounted;
		this.isTruncated = isTruncated;
		this.userId = userId;
	}
	
	public Tweet(long tweetId, String tweetText, String createdAt, String source, boolean isRetweet, boolean isFavorited,
			long retweetCounted, boolean isTruncated, long userId, String screenName, String name, String profileImageURL) throws SQLException, Exception{
		this.tweetId = tweetId;
		this.tweetText = tweetText;
		this.createdAt = createdAt;
		this.source = source;
		this.isRetweet = isRetweet;
		this.isFavorited = isFavorited;
		this.retweetCounted = retweetCounted;
		this.isTruncated = isTruncated;
		this.userId = userId;
		this.screenName = screenName;
		this.name = name;
		this.profileImageURL = profileImageURL;
	}
	
	public Tweet() {
		
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isRetweet() {
		return isRetweet;
	}

	public void setRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}

	public boolean isFavorited() {
		return isFavorited;
	}

	public void setFavorited(boolean isFavorited) {
		this.isFavorited = isFavorited;
	}

	public long getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(long retweetCount) {
		this.retweetCount = retweetCount;
	}

	public boolean isTruncated() {
		return isTruncated;
	}

	public void setTruncated(boolean isTruncated) {
		this.isTruncated = isTruncated;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRetweetCounted() {
		return retweetCounted;
	}

	public void setRetweetCounted(long retweetCounted) {
		this.retweetCounted = retweetCounted;
	}
	
	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
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

	public String getProfileImageURL() {
		return profileImageURL;
	}

	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}

}
