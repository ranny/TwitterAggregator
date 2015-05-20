package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbUser {
	
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
	
	public void insertUser(old_TweetUser tu) {
		PreparedStatement stmt;
			try {
				stmt = c.prepareStatement("insert into twt_user values(default,?,?,?,?,?,?,?,?)");
				stmt.setLong(1,tu.getUserId());
				stmt.setString(2, tu.getScreenName());
				stmt.setString(3, tu.getName());
				stmt.setString(4, tu.getDescription());
				stmt.setInt(5, tu.getFollowersCount());
				stmt.setInt(6, tu.getFriendsCount());
				stmt.setBoolean(7, tu.isVerified());
				stmt.setString(8, tu.getProfileImageURL());
				stmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	public List<User> getUser() throws Exception {
		List<User> user = new ArrayList<User>();
		PreparedStatement stmt;
		try {
			stmt = c.prepareStatement("SELECT user_id, screen_name, name, description, followers_count, friends_count, is_verified, profile_pict_url FROM twt_user");
			//stmt.setInt(1, 1001);
			ResultSet rs = (ResultSet) stmt.executeQuery();
			
			while(rs.next()) {
				long userId = rs.getLong("user_id");
				String screenName = rs.getString("screen_name");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int followersCount = rs.getInt("followers_count");
				int friendsCount= rs.getInt("friends_count");
				boolean isVerified = rs.getBoolean("is_verified");
				String profileImageURL = rs.getString("profile_pict_url");
				
				User u = new User(userId, screenName, name, description,
						followersCount, friendsCount, isVerified, profileImageURL);
				user.add(u);
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return user;
	}

}
