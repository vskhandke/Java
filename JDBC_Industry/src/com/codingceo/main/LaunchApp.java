package com.codingceo.main;
import java.sql.*;

import com.codingceo.util.*;

public class LaunchApp {

	public static void main(String[] args) {
		// Open the Resources
		Connection conn = null;
		Statement st = null;
		ResultSet result = null;

		//Query
		String query = "SELECT * from student;";
		
		// Get Connection
		try {
			conn = utility.getDBConnection();
			if (conn != null) {
				st = conn.createStatement();
				if (st != null) {
					result = st.executeQuery(query);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nID\tName\t  Age\tMarks");
		try {
			while(result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getNString(2) + 
						"\t  " + result.getInt(3) + "\t" + result.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				utility.closeResource(result, st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}