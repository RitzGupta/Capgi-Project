package com.capgemini.onlineWallet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static Connection con=null;
	public static Connection createConnection() {
		try {
	    	Class.forName("oracle.jdbc.OracleDriver");
	    	con= DriverManager.getConnection(url, "Ritik", "12345");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
