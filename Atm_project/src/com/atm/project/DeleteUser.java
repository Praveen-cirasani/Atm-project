package com.atm.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteUser {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "root");
		Statement s=con.createStatement();
		s.executeUpdate("delete from signuptwo where seniorcitizen='null'");

	}

}
