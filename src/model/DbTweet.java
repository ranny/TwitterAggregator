package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbTweet {

	private Connection c;
	
	public void openConnection(){
		Connector con = new Connector();
		this.c = con.getConnection();
	}
	
	public void closeConnection(){
		try {
			this.c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertTweet(Tweet t) {
		PreparedStatement stmt;
			try {
				stmt = c.prepareStatement("insert into tweet_raw_copy values(default,?,?,?,?,?,?,?,?,?,default,default)");
				stmt.setLong(1, t.getTweetId());
				stmt.setString(2, t.getTweetText());
				stmt.setString(3, t.getCreatedAt());
				stmt.setString(4, t.getSource());
				stmt.setBoolean(5, t.isRetweet());
				stmt.setBoolean(6, t.isFavorited());
				stmt.setLong(7, t.getRetweetCounted());
				stmt.setBoolean(8, t.isTruncated());
				stmt.setLong(9,t.getUserId());
				stmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<Tweet> getTweets() throws Exception {
		List<Tweet> tweet = new ArrayList<Tweet>();
		PreparedStatement stmt;
		try {
			stmt = c.prepareStatement("SELECT tweet_id, tweet_text, created_at, source, is_retweet, is_favourited, retweet_counted, is_truncated, user_id FROM tweet_raw_copy");
			ResultSet rs = (ResultSet) stmt.executeQuery();
			while(rs.next()) {
				long tweetId = rs.getLong("tweet_id");
				String tweetText = rs.getString("tweet_text");
				String createdAt = rs.getString("created_at");
				String source = rs.getString("source");
				boolean isRetweet = rs.getBoolean("is_retweet");
				boolean isFavourited = rs.getBoolean("is_favourited");
				long retweetCounted = rs.getLong("retweet_counted");
				boolean isTruncated = rs.getBoolean("is_truncated");
				long userId = rs.getLong("user_id");
				
				Tweet t = new Tweet(tweetId, tweetText, createdAt, source, isRetweet, isFavourited, retweetCounted, isTruncated, userId);
				tweet.add(t);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return tweet;
	}
	
	public List<Tweet> getTweetsLimit() throws Exception {
		List<Tweet> tweet = new ArrayList<Tweet>();
		PreparedStatement stmt;
		try {
			//stmt = c.prepareStatement("SELECT tweet_id, tweet_text, created_at, source, is_retweet, is_favourited, retweet_counted, is_truncated, user_id FROM tweet_raw WHERE ISNULL(class) OR class = '' OR class = 'null' LIMIT 25");
			stmt = c.prepareStatement("SELECT t.tweet_id as tweet_id, t.tweet_text as tweet_text, t.created_at as created_at, t.source as source,"
									+ "t.is_retweet as is_retweet, t.is_favourited as is_favourited, t.retweet_counted as retweet_counted,"
									+ "t.is_truncated as is_truncated, t.user_id as user_id, u.screen_name as screen_name, u.name as name, u.profile_pict_url as profile_pict_url "
									+ "FROM tweet_raw_copy t, twt_user u "
									+ "WHERE t.user_id = u.user_id AND (ISNULL(t.label) OR t.label = '' OR t.label = 'null' OR t.label = 1) LIMIT 50");
			/*sementara untuk pelabelan ulang nasional*/
			/*stmt = c.prepareStatement("SELECT t.tweet_id as tweet_id, t.tweet_text as tweet_text, t.created_at as created_at, t.source as source,"
					+ "t.is_retweet as is_retweet, t.is_favourited as is_favourited, t.retweet_counted as retweet_counted,"
					+ "t.is_truncated as is_truncated, t.user_id as user_id, u.screen_name as screen_name, u.name as name, u.profile_pict_url as profile_pict_url "
					+ "FROM tweet_raw t, twt_user u "
					+ "WHERE t.user_id = u.user_id AND t.label=3 LIMIT 50");*/
			ResultSet rs = (ResultSet) stmt.executeQuery();
			while(rs.next()) {
				long tweetId = rs.getLong("tweet_id");
				String tweetText = rs.getString("tweet_text");
				String createdAt = rs.getString("created_at");
				String source = rs.getString("source");
				boolean isRetweet = rs.getBoolean("is_retweet");
				boolean isFavourited = rs.getBoolean("is_favourited");
				long retweetCounted = rs.getLong("retweet_counted");
				boolean isTruncated = rs.getBoolean("is_truncated");
				long userId = rs.getLong("user_id");
				String screenName = rs.getString("screen_name");
				String name = rs.getString("name");
				String profileImageURL = rs.getString("profile_pict_url");
				
				Tweet t = new Tweet(tweetId, tweetText, createdAt, source, isRetweet, isFavourited, retweetCounted, isTruncated, userId, screenName, name, profileImageURL);
				tweet.add(t);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return tweet;
	}
	
	public boolean updateLabel(Tweet t) {
		PreparedStatement stmt;
			try {
				stmt = c.prepareStatement("UPDATE tweet_raw_copy SET label = ? WHERE tweet_id = ?");
				//if(t.getLabel() == 0) {
					/*String setNull = null;
					stmt.setString(1, setNull);*/
					//stmt.setInt(1, 1);
				//} else {
					stmt.setInt(1, t.getLabel());
				//}
				stmt.setLong(2, t.getTweetId());
				stmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return true;
	}
	
	public int countTweet() throws Exception {
		int totalTweet = 0;
		PreparedStatement stmt;
		try {
			stmt = c.prepareStatement("SELECT count(tweet_id) as total_tweet FROM tweet_raw_copy");
			ResultSet rs = (ResultSet) stmt.executeQuery();
			while(rs.next()) {
				totalTweet = rs.getInt("total_tweet");
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return totalTweet;
	}
	
	public String getLastCreatedAt() throws Exception {
		String lastCreatedAt = null;
		PreparedStatement stmt;
		try {
			stmt = c.prepareStatement("SELECT MAX(created_at) as last_created_at FROM tweet_raw_copy");
			ResultSet rs = (ResultSet) stmt.executeQuery();
			while(rs.next()) {
				lastCreatedAt = rs.getString("last_created_at");
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return lastCreatedAt;
	}
	
	public List<String> getTweetsForPrepro() throws Exception {
		List<String> tweetText = new ArrayList<String>();
		PreparedStatement stmt;
		try {
			stmt = c.prepareStatement("SELECT tweet_text "
									+ "FROM tweet_raw_copy "
									+ "WHERE is_preprocessing = 0 LIMIT 2000");
			ResultSet rs = (ResultSet) stmt.executeQuery();
			while(rs.next()) {
				String tweet = rs.getString("tweet_text");
				tweetText.add(tweet);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return tweetText;
	}
	
}
