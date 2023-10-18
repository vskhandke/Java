import java.sql.*;
import java.util.Scanner;

public class JDBC_PreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println("Hello World!");
		// Use of Prepared Statement
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("JDBC CONNECTION!!");
		System.out.println("Load and Register Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Establish the Connection");
		String url = "jdbc:mysql://localhost:3306/main";
		String username = "root";
		String password = "root@9890";
		Connection connect = DriverManager.getConnection(url, username, password);
		
		System.out.println("Create Statement to transfer Query");
//		Statement st = connect.createStatement();
		/*
		 * Using statement it executes the query every time, with compilation.
		 */
		// Prepared Statement: At runtime it pass the query, auto compile, runtime pass the values
		String query = "INSERT INTO student (Id, Name, Age, Marks) values (?, ?, ?, ?)";
		// ? in place of this we can pass values on run time, thats why need scanner class
		PreparedStatement prst = connect.prepareStatement(query);
		
		System.out.println("Enter your ID: ");
		int id = scan.nextInt();
		System.out.println("Enter your Name: ");
		String name = scan.next();
		System.out.println("Enter your Age: ");
		int age = scan.nextInt();
		System.out.println("Enter your Marks: ");
		int mark = scan.nextInt();
		
		prst.setInt(1, id);
		prst.setString(2, name);
		prst.setInt(3, age);
		prst.setInt(4, mark);
		
		// execute() OR executeUpdate()
		int rowAffected = prst.executeUpdate();
		System.out.println("Number of rows affected: " + rowAffected);
		
		prst.close();
		connect.close();
	}
}