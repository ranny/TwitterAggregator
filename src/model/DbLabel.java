package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbLabel {

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
	
	public List<TweetLabel> getLabel() throws Exception {
		List<TweetLabel> listLabel= new ArrayList<TweetLabel>();
		PreparedStatement stmt;
		try {
			//tarik data label kecuali nasional
			stmt = c.prepareStatement("SELECT id, label FROM tweet_label_copy WHERE id <> 9");
			ResultSet rs = (ResultSet) stmt.executeQuery();
			while(rs.next()) {
				int labelId = rs.getInt("id");
				String label = rs.getString("label");
				
				TweetLabel tw = new TweetLabel(labelId, label);
				listLabel.add(tw);
			}
		} catch(SQLException se) {
			se.printStackTrace();
		}

		return listLabel;
	
	}
	
}
