package hung.conn;

import java.sql.*;

public class ConnectionUtils {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String sqlInstanceName = "ADMIN";
        String dbName = "Lab04JspServletJDBC";
        String userName = "sa";
        String password = "sa123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName=" +dbName + ";encrypt=true;trustServerCertificate=true";
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());  
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
	
	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch (Exception e) {
			
		}
	}
	
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch (Exception e) {
			
		}
	}
}
