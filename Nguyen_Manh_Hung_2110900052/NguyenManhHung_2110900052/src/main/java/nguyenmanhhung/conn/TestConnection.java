package nguyenmanhhung.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args)
			throws ClassNotFoundException,
			SQLException {

			System.out.println("Get connection ... ");

			Connection conn = NguyenManhHung_Connection.getMSSQLConnection();

			System.out.println("Get connection " + conn);
			System.out.println("Done!");
	}
}
