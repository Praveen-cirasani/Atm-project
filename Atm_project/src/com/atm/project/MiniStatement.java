package com.atm.project;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame
{
		
	MiniStatement(String pinnumber)
	{
		setLayout(null);
		JLabel mini =new JLabel();
		
		add(mini);
		
		JLabel statement= new JLabel("Mini Statement");
		statement.setFont(new Font("Raleway",Font.BOLD,22));
		statement.setBounds(100, 20, 200, 20);
		add(statement);
		
		JLabel card=new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance=new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		
		try
		{
			Conn conn=new Conn();
			ResultSet rs=conn.s.executeQuery("select * from login where pinnumber='"+pinnumber+"'");
			while(rs.next())
			{
				card.setText("card number: "+rs.getString("cardnumber").substring(0, 4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12, 16));	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			Conn c=new Conn();
			int bal=0;
			ResultSet rs=c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
			while(rs.next())
			{
				mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				if(rs.getString("type").equals("deposit"))
				{
					bal+=Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					bal-=Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("your current Account balance: "+bal);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mini.setBounds(20, 140, 400, 200);
		
		
		setLocation(100, 50);
		setSize(400, 600);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MiniStatement("");

	}

}
