package com.atm.project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class Balanceenquiry extends JFrame implements ActionListener
{
	JButton back;
	String pinnumber;
	Balanceenquiry(String pinnumber)
	{
		this.pinnumber=pinnumber;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 25);
		back.addActionListener(this);
		image.add(back);
		
		Conn conn=new Conn();
		int balance=0;
		try
		{
			ResultSet rs=conn.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
			
			while(rs.next())
			{
				if(rs.getString("type").equals("deposit"))
				{
					balance+=Integer.parseInt(rs.getString("amount"));
				}
				else
				{
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel text=new JLabel("your current account balance is: "+balance);
		text.setForeground(Color.white);
		text.setBounds(170, 300, 400, 30);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		setLayout(null);
		setSize(900, 900);
		setUndecorated(true);
		setVisible(true);
		setLocation(350, 0);
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Transcations(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		
		new Balanceenquiry("");
	}
	

}
