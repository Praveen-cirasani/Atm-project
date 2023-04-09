package com.atm.project;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener
{
	JRadioButton r1,r2,r3,r4;
	
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	
	JButton submit,cancel;
	
	String formno;
	
	SignupThree(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
		JLabel l1=new JLabel("Page 3:Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280, 40, 400, 40);
		add(l1);
		
		JLabel type=new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100, 140, 200, 30);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 180, 150, 20);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(400, 180, 250, 20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 220, 250, 20);
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(400, 220, 250, 20);
		add(r4);
		
		ButtonGroup groupaccount=new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card=new JLabel("Card Number:");
		card.setFont(new Font("Raleway",Font.BOLD,20));
		card.setBounds(100, 300, 200, 30);
		add(card);
		
		JLabel carddetails=new JLabel("Your 16 Digit Account Number");
		carddetails.setFont(new Font("Raleway",Font.BOLD,12));
		carddetails.setBounds(100, 320, 300, 30);
		add(carddetails);
		
		JLabel cardnumber=new JLabel("XXXX-XXXX-XXXX-XXXX");
		cardnumber.setFont(new Font("Raleway",Font.BOLD,16));
		cardnumber.setBounds(250, 300, 300, 30);
		add(cardnumber);
		
		JLabel pin=new JLabel("Pin Number:");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100, 350, 300, 30);
		add(pin);
		
		JLabel pindetails=new JLabel("Your 4 Digit Password");
		pindetails.setFont(new Font("Raleway",Font.BOLD,12));
		pindetails.setBounds(100, 370, 300, 30);
		add(pindetails);
		
		JLabel pinnumber=new JLabel("XXXX");
		pinnumber.setFont(new Font("Raleway",Font.BOLD,16));
		pinnumber.setBounds(250, 350, 300, 30);
		add(pinnumber);
		
		JLabel services=new JLabel("Services Required:");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100, 420, 300, 30);
		add(services);
		
		c1=new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("raleway",Font.BOLD,16));
		c1.setBounds(130, 460, 300, 30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("raleway",Font.BOLD,16));
		c2.setBounds(130, 490, 300, 30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("raleway",Font.BOLD,16));
		c3.setBounds(130, 520, 300, 30);
		add(c3);
		
		c4=new JCheckBox("EMAIL & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("raleway",Font.BOLD,16));
		c4.setBounds(450, 520, 300, 30);
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("raleway",Font.BOLD,16));
		c5.setBounds(450, 460, 350, 30);
		add(c5);
		
		c6=new JCheckBox("E Statements");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("raleway",Font.BOLD,16));
		c6.setBounds(450, 490, 350, 30);
		add(c6);
		
		c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("raleway",Font.BOLD,12));
		c7.setBounds(100, 600, 600, 30);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("raleway",Font.BOLD,14));
		submit.setBounds(250, 650, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("raleway",Font.BOLD,14));
		cancel.setBounds(400, 650, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		setTitle("Application form-3");
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(300, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			String accounttype=null;
			if(r1.isSelected())
			{
				accounttype="Saving Account";
			}
			else if(r2.isSelected())
			{
				accounttype="Fixed Deposit Account";
			}
			else if(r3.isSelected())
			{
				accounttype="Current Account";
			}
			else if(r4.isSelected())
			{
				accounttype="Recurring Deposit Account";
			}
			
			Random random=new Random(); 
			String cardnumber=""+Math.abs((random.nextLong()%90000000L)+ 3204905000000000L);
			
			String pinnumber=""+Math.abs((random.nextLong()%90L))+ 10L;
			
			String facility="";
			if(c1.isSelected())
			{
				facility=facility+"ATM Card";
			}
			else if(c2.isSelected())
			{
				facility=facility+"Internet Banking";
			}
			else if(c3.isSelected())
			{
				facility=facility+"Mobile Banking";
			}
			else if(c4.isSelected())
			{
				facility=facility+"EMAIL & SMS Alerts";
			}
			else if(c5.isSelected())
			{
				facility=facility+"Cheque Book";
			}
			else if(c6.isSelected())
			{
				facility=facility+"E Statements";
			}
			
			try
			{
				if(accounttype.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Account type is require");
				}
				else
				{
					Conn c=new Conn();
					
					String query1="insert into signupthree values ('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2="insert into login values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					
					c.s.executeUpdate(query1); 
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null,"Card Number:"+cardnumber+"\n Pin: "+pinnumber);
					
					setVisible(false);
					new Transcations(pinnumber).setVisible(true);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==cancel)
		{
			setVisible(false);
			new LoginPage().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new SignupThree("");

	}

}
