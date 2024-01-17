package ex.jdbc;
import java.sql.*;
import java.sql.Connection;

public class ConnectionUtils {
	public static void main(String[] args)
			throws ClassNotFoundException,
			SQLException {

			System.out.println("Get connection ... ");

			Connection conn = null;
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connectionUrl = "jdbc:sqlserver://ADMIN;database=CustomerManager;integratedSecurity=true;";
				conn = DriverManager.getConnection(connectionUrl);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				

			System.out.println("Get connection " + conn);
			System.out.println("Done!");
		}
}
