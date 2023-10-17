package com.codingceo.util;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utility {
	static {
		// Load and Register
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver Registered!");
	}
	
	public static Connection getDBConnection() {
		String url = "jdbc:mysql://localhost:3306/main";
		String username = "root";
		String password = "root@9890";
		try {
			return DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeResource(ResultSet rs, Statement st, Connection conn) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(st != null) {
			st.close();
		}
		if(conn != null) {
			conn.close();
		}
	}
}
