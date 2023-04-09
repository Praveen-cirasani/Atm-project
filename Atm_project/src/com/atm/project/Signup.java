package com.atm.project;

import java.awt.*;

import javax.swing.*;

import java.util.*;

import com.toedter.calendar.*;

import java.awt.event.*;

public class Signup extends JFrame implements ActionListener
{
	long random;
	JTextField namefield, fnamefield,addressfield,emailfield,cityfield,statefield,pinfield;
	JButton next;
	JRadioButton male,female,married,unmarried;
	JDateChooser datechooser;
	
	Signup()
	{
		setLayout(null);
		Random ran=new Random();
		 random = Math.abs((ran.nextLong()%9000L)+1000L);
		 
		JLabel formno=new JLabel("Application Form No: "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel persondetails=new JLabel("Page 1: Personal Details");
		persondetails.setFont(new Font("Raleway",Font.BOLD,22));
		persondetails.setBounds(290, 80, 400, 30);
		add(persondetails);
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,22));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		 namefield=new JTextField();
		namefield.setFont(new Font("Raleway",Font.BOLD,14));
		namefield.setBounds(300, 140, 400, 30);
		namefield.addActionListener(this);
		add(namefield);
		
		JLabel fname=new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,22));
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		 fnamefield=new JTextField();
		fnamefield.setFont(new Font("Raleway",Font.BOLD,14));
		fnamefield.setBounds(300, 195, 400, 30); 
		add(fnamefield);
		
		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,22));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		 datechooser=new JDateChooser();
		datechooser.setForeground(Color.black);
		datechooser.setBounds(300, 240, 400, 30);
		add(datechooser);
		
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100, 290, 100, 30);
		add(gender);
		
		 male =new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		add(male);
		
		 female =new JRadioButton("Female");
		female.setBounds(450, 290, 100, 30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email=new JLabel("Email:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100, 340, 100, 30);
		add(email);
		
		 emailfield=new JTextField();
		emailfield.setFont(new Font("Raleway",Font.BOLD,14));
		emailfield.setBounds(300, 340, 400, 30); 
		add(emailfield);
		
		JLabel marital=new JLabel("Marital:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100, 390, 100, 30);
		add(marital);
		
		 married =new JRadioButton("Married");
		married.setBounds(300, 390, 100, 30);
		married.setBackground(Color.white);
		add(married);
		
		 unmarried =new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		ButtonGroup maritalgroup=new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		
		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100, 440, 100, 30);
		add(address);
		
		 addressfield=new JTextField();
		addressfield.setFont(new Font("Raleway",Font.BOLD,14));
		addressfield.setBounds(300, 440, 400, 30); 
		add(addressfield);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100, 490, 100, 30);
		add(city);
		
		 cityfield=new JTextField();
		cityfield.setFont(new Font("Raleway",Font.BOLD,14));
		cityfield.setBounds(300, 490, 400, 30); 
		add(cityfield);
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100, 540, 100, 30);
		add(state);
		
		 statefield=new JTextField();
		statefield.setFont(new Font("Raleway",Font.BOLD,14));
		statefield.setBounds(300, 540, 400, 30); 
		add(statefield);
		
		JLabel pincode=new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100, 590, 100, 30);
		add(pincode);
		
		 pinfield=new JTextField();
		pinfield.setFont(new Font("Raleway",Font.BOLD,14));
		pinfield.setBounds(300, 590, 400, 30); 
		add(pinfield);
		
		 next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		
		setTitle("Application form-Page1");
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 800); 
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno=""+random;
		String name=namefield.getText();
		String fname=fnamefield.getText();
		String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected())
		{
			gender="male";
		}
		else if(female.isSelected())
		{
			gender="female";
		}
		
		String email=emailfield.getText();
		String marital=null;
		if(married.isSelected())
		{
			marital="married";
		}
		else if(unmarried.isSelected())
		{
			marital="unmarried";
		}
		String address=addressfield.getText();
		String city=cityfield.getText();
		String state=statefield.getText();
		String pin=pinfield.getText();
		
		try
		{
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else
			{
				Conn c=new Conn();
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+city+"','"+state+"','"+pin+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new Signuptwo(formno).setVisible(true);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Signup();

	}

	

}
