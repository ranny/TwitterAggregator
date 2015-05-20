package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private String db = "twitteraggregator";
	private String url = "jdbc:mysql://localhost:3306/"+db;
	private String user = "root";
	private String password = "";
	
	public Connector() {
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException cfe) {
			cfe.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return con;
	}
	
}
