package com.atm.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn 
{
	Connection con;
	Statement s;
	Conn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement", "root", "root");
			s=con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
