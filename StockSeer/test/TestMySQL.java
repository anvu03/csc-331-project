
import java.sql.*;

import persistence.CredentialChecker;
import persistence.DBConnection;

public class TestMySQL {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success load driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
		// "jdbc:mysql://addressofthedatabase/table"
		final String URL = "jdbc:mysql://localhost/stock_seer";
		final String USER = "appuser";
		final String PASS = "password";

		// try to connect
		try {
			// Connection conn = DriverManager.getConnection(URL, USER, PASS);
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql;
			sql = "Select username, first_name, last_name from user";
			ResultSet rs = stmt.executeQuery(sql);

			// get query result
			System.out.println("Print result of the query...");
			while (rs.next()) {
				System.out.println(rs.getString("username"));
				System.out.println(rs.getString("first_name"));
				System.out.println(rs.getString("last_name"));
			}

			// check credential
			if (CredentialChecker.checkUsernameAndPassword("ginger", "password")) {
				System.out.println("Valid credential");
			} else {
				System.out.println("Invalid credential");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try

	}
}
