package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler {
	
	private static String selectAllCustomers = "select * from users";
	private static String insertNewCustomer = "insert into users (name, address, phone) values ('212', '4376 st', '67444')";
	public static void main(String[] args) {
	
		//url/file location
		//db name
		//username, password
		String url = "C:\\Users\\ipros\\";
		String dbName = "newdemodatabase.db";
		String connectionString = "jdbc:sqlite:" + url + dbName;
		
		//JDC Java database connectivity
		
		try {
			Connection conn = DriverManager.getConnection(connectionString);//create statement - another object to run sql
			Statement statement = conn.createStatement();
			//statement.execute(insertNewCustomer);
			
		ResultSet results =	statement.executeQuery(selectAllCustomers);
		
		while(results.next()) {
		String name = results.getString(2);
		String address = results.getString(3);
		String phone = results.getString(4);
		System.out.println("name:" + name + ", Address: " + address + ", Phone: " + phone);
		}
			System.out.println("Execute the sql successfully");
			
		} catch (SQLException e) {
			System.out.println("SQL command failed");
		}
	}

}
