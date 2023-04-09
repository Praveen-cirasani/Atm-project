package com.atm.project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Pinchange extends JFrame implements ActionListener
{
	JButton change,back;
	JPasswordField pin,repin;
	String pinnumber;
	Pinchange(String pinnumber)
	{
		this.pinnumber=pinnumber;
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image); 
		
		JLabel text =new JLabel("Change your Pin");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(230, 300, 700, 35);
		image.add(text);
		
		JLabel pintext =new JLabel("New Pin:");
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(175, 350, 500, 35);
		image.add(pintext);
		
		pin=new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(330, 350, 150, 30);
		image.add(pin);
		
		JLabel repintext =new JLabel("Re-Enter Pin:");
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(175, 390, 500, 35);
		image.add(repintext);
		
		repin=new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,22));
		repin.setBounds(330, 390, 150, 30);
		image.add(repin);
		
		change=new JButton("Change");
		change.setBounds(355, 485, 150, 25);
		change.addActionListener(this);
		image.add(change);
		
		back=new JButton("Back");
		back.setBounds(355, 520, 150, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900, 900);
		setUndecorated(true);
		setVisible(true);
		setLocation(300, 0);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==change)
		{
			try
			{
				String npin=pin.getText();
				String nrepin=repin.getText();
				if(!npin.equals(nrepin))
				{
					JOptionPane.showMessageDialog(null, "please enter new pin");
				}
				if(nrepin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "please enter re-new pin");
				}
				Conn conn=new Conn();
				String query="update bank set pinnumber='"+npin+"' where pinnumber='"+pinnumber+"'";
				String query1="update login set pinnumber='"+npin+"' where pinnumber='"+pinnumber+"'" ;
				String query2="update signupthree set pinnumber='"+npin+"' where pinnumber='"+pinnumber+"'" ;
				
				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "pin change sucessfully");
				
				setVisible(false);
				new Transcations(pinnumber).setVisible(true);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(ae.getSource()==back)
		{
			
		}
	}
	
	public static void main(String[] args) {
		new Pinchange("").setVisible(true);
	}

}
