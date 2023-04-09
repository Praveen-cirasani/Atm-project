package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener
{
	JTextField amount;
	
	JButton withdraw,back;
	
	String pinnumber;
	
	Withdraw(String pinnumber)
	{
		this.pinnumber=pinnumber;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text =new JLabel("Enter the amount you want to withdraw");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(170, 300, 700, 35);
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,20));
		amount.setBounds(200, 350, 250, 30);
		amount.addActionListener(this);
		image.add(amount);
		
		withdraw=new JButton("withdraw");
		withdraw.setBounds(355, 485, 150, 25);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 25);
		back.addActionListener(this);
		image.add(back);
		
		setLayout(null);
		setSize(900, 900);
		setUndecorated(true);
		setVisible(true);
		setLocation(350, 0);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==withdraw)
		{
			String number=amount.getText();
			
			Date date=new Date();
			
			if(number.equals(""))
			{
				JOptionPane.showMessageDialog(null, "please enter the amount");
			}
			else {
				try
				{
				Conn conn=new Conn();
				String Query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
				conn.s.executeUpdate(Query);
				
				JOptionPane.showMessageDialog(null, "Rs: "+number+" withdraw succesfully");
				
				setVisible(false);
				new Transcations(pinnumber).setVisible(true);
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(ae.getSource()==back)
		{
			setVisible(false);
			new Transcations(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) 
	{
		new Withdraw("");
	}
}
