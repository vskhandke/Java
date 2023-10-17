package JDBC;
import java.sql.*;
public class JDBC_IUD_Commands {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/main";
		String username = "root";
		String password = "root@9890";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered!");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established!");
			
			Statement st = conn.createStatement();
			// Update Insert Delete
			String query = "UPDATE student SET Marks=84 WHERE Id=2";
//			String query = "INSERT INTO student (Id, Name, Age, Marks) values (7, 'Kiran', 21, 65);";
//			String query = "DELETE FROM student WHERE Id=7";
			int noRowsAffected = st.executeUpdate(query);
			
			System.out.println("Number of Rows Affected: " + noRowsAffected);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}