package JDBC;

import java.sql.*;

public class JDBC_Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("JDBC CONNECTION!!");
		System.out.println("Load and Register Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Establish the Connection");
		String url = "jdbc:mysql://localhost:3306/main";
		String username = "root";
		String password = "root@9890";
		Connection connect = DriverManager.getConnection(url, username, password);
		
		// Select Query
		System.out.println("Create Statement to transfer Query");
		Statement stmt = connect.createStatement();
		
		System.out.println("Execute the Query");
		String query = "select Id, Name, Age, Marks from student";
		ResultSet result = stmt.executeQuery(query);
		
		System.out.println("Process Data and Printing it!!");
		System.out.println("\nID\tName\tAge\tMarks");
		while(result.next()) {
			System.out.println(result.getInt(1) + "\t" + result.getNString(2) + 
					"\t" + result.getInt(3) + "\t" + result.getInt(4));
		}
		String queryUpdate = "UPDATE student SET Marks=69 WHERE Id=6";
		int count = stmt.executeUpdate(queryUpdate);
		System.out.println("Number of Rows Affected: " + count);
		
		String queryNew = "select Id, Name, Age, Marks from student";
		ResultSet result1 = stmt.executeQuery(queryNew);
		System.out.println("\n\nID\tName\tAge\tMarks");
		while(result1.next()) {
			System.out.println(result1.getInt(1) + "\t" + result1.getNString(2) + 
					"\t" + result1.getInt(3) + "\t" + result1.getInt(4));
		}
		result.close();
		stmt.close();
		connect.close();
		
		 
	}

}
