package com.atm.project;
import java.awt.Color;

import java.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class LoginPage extends JFrame implements ActionListener
{
	JButton login,clear,signup;
	JTextField cardfield;
	
	JPasswordField pinfield;
	
	LoginPage()
	{
		setLayout(null);
		
		
		setTitle("Automated Teller Machine(ATM)");
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(70, 50, 100, 100);
		add(l1);
		JLabel text=new JLabel("Welcome To ATM");
		text.setFont(new Font("osward",Font.BOLD,38));
		text.setBounds(200, 80, 400, 40);
		add(text);
		
		JLabel cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(80, 160, 200, 40);
		add(cardno);
		
		
		cardfield=new JTextField();
		cardfield.setBounds(220, 170, 250, 35);
		add(cardfield);
		
		JLabel pin=new JLabel("Pin:");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(145, 220, 200, 40);
		add(pin);
		
		
		 pinfield=new JPasswordField();
		pinfield.setBounds(220, 230, 250, 35);
		add(pinfield);
		
		
		login=new JButton("login");
		login.setBounds(220, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		 clear=new JButton("clear");
		clear.setBounds(350, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		
		 signup=new JButton("signup");
		signup.setBounds(280, 350, 130, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		
		setSize(600, 500);
		setVisible(true);
		setLocation(450, 100);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==clear)
		{
			cardfield.setText("");
			pinfield.setText("");
		}
		else if(ae.getSource()==login)
		{
			Conn conn=new Conn();
			String cardnumber=cardfield.getText();
			String pinnumber=pinfield.getText();
			String query="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'";
			
			try
			{
				ResultSet rs=conn.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transcations(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect card number or Pin ");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==signup)
		{
			setVisible(false);
			new Signup().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new LoginPage();

	}

}
