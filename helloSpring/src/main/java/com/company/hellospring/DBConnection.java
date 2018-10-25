package com.company.hellospring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException, NamingException, ClassNotFoundException{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "spring", "spring");		
	}
}
