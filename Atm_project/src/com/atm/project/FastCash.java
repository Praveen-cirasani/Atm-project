package com.atm.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
	JButton one,five,thousand,twothousand,fivethousand,tenthousand,back;
	String pinnumber;
	
	FastCash(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		
		JLabel text =new JLabel("Select Withdrawl Amount");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(230, 300, 700, 35);
		image.add(text);
		
		one=new JButton("Rs 100");
		one.setBounds(170, 415, 150, 30);
		one.addActionListener(this);
		image.add(one);
		
		
		five=new JButton("Rs 500");
		five.setBounds(355, 415, 150, 30);
		five.addActionListener(this);
		image.add(five);
		
		thousand=new JButton("Rs 1000");
		thousand.setBounds(170, 450, 150, 30);
		thousand.addActionListener(this);
		image.add(thousand);	
		
		
		twothousand=new JButton("RS 2000");
		twothousand.setBounds(355, 450, 150, 30);
		twothousand.addActionListener(this);
		image.add(twothousand);
		
		fivethousand=new JButton("Rs 5000");
		fivethousand.setBounds(355, 485, 150, 30);
		fivethousand.addActionListener(this);
		image.add(fivethousand);
		
		tenthousand=new JButton("Rs 10000");
		tenthousand.setBounds(170, 485, 150, 30);
		tenthousand.addActionListener(this);
		image.add(tenthousand);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setUndecorated(true);
		setVisible(true);
		setLocation(300, 0);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Transcations(pinnumber).setVisible(true);
		}
		else
		{
			String amount=((JButton)ae.getSource()).getText().substring(3);
			Conn conn=new Conn();
			try
			{
				ResultSet rs=conn.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
				int balance=0;
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
				if(ae.getSource()!=back && balance<Integer.parseInt(amount))
				{
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				Date date=new Date();
				String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs: "+amount+" debited Sucessfully");
				
				setVisible(false);
				new Transcations(pinnumber).setVisible(true);
			}
			catch(Exception e)
			{
				
			}
		}
	}
	public static void main(String[] args) 
	{
		new FastCash("");

	}

}
