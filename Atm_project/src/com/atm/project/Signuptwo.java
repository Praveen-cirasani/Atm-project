package com.atm.project;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener
{
	String formno;
	JComboBox religion,category,income,education,occupation;
	JTextField pan,adharno;
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	
	Signuptwo(String formno)
	{
		this.formno=formno;
		setLayout(null);
		
		 
		JLabel additiondetails=new JLabel("Page 2: Personal additional Details");
		additiondetails.setFont(new Font("Raleway",Font.BOLD,22));
		additiondetails.setBounds(290, 80, 400, 30);
		add(additiondetails);
		
		JLabel religion1=new JLabel("Religion:");
		religion1.setFont(new Font("Raleway",Font.BOLD,22));
		religion1.setBounds(100, 140, 100, 30);
		add(religion1);
		
		String valreligion[]= {"Hindu","Muslim","Christian","Other"};
		religion = new JComboBox(valreligion);
		religion.setBounds(300, 140, 400, 30);
		religion.addActionListener(this);
		religion.setBackground(Color.white);
		add(religion);
		
		 
		
		JLabel category1=new JLabel("Category:");
		category1.setFont(new Font("Raleway",Font.BOLD,22));
		category1.setBounds(100, 190, 200, 30);
		add(category1);
		
		String valcategory[]= {"General","OBC","SC","ST","Other"};
		category = new JComboBox(valcategory);
		category.setBounds(300, 195, 400, 30);
		category.addActionListener(this);
		category.setBackground(Color.white);
		add(category);
		
		
		JLabel income1=new JLabel("Income:");
		income1.setFont(new Font("Raleway",Font.BOLD,22));
		income1.setBounds(100, 240, 200, 30);
		add(income1);
		
		String incomecategory[]= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
		income = new JComboBox(incomecategory);
		income.setBounds(300, 240, 400, 30);
		income.addActionListener(this);
		income.setBackground(Color.white);
		add(income);
		
		
		
		JLabel eduaction2=new JLabel("Educational");
		eduaction2.setFont(new Font("Raleway",Font.BOLD,20));
		eduaction2.setBounds(100, 290, 200, 30);
		add(eduaction2);
		
		
		JLabel qualify=new JLabel("Qualification:");
		qualify.setFont(new Font("Raleway",Font.BOLD,20));
		qualify.setBounds(100, 320, 200, 30);
		add(qualify);
		
		String educationcategory[]= {"Non-Graduation","Graduate","Post-Graduated","Doctrate","others"};
		education = new JComboBox(educationcategory);
		education.setBounds(300, 320, 400, 30);
		education.addActionListener(this);
		education.setBackground(Color.white);
		add(education);
		
		
		
		JLabel occupation1=new JLabel("Occupation:");
		occupation1.setFont(new Font("Raleway",Font.BOLD,20));
		occupation1.setBounds(100, 390, 200, 30);
		add(occupation1);
		
		String occupationcategory[]= {"Salaried","Self Employed","Student","Retired","others"};
		occupation = new JComboBox(occupationcategory);
		occupation.setBounds(300, 390, 400, 30);
		occupation.addActionListener(this);
		occupation.setBackground(Color.white);
		add(occupation);
		
		
		
		JLabel panno=new JLabel("Pan Number:");
		panno.setFont(new Font("Raleway",Font.BOLD,20));
		panno.setBounds(100, 440, 200, 30);
		add(panno);
		
		 pan=new JTextField();
		pan.setFont(new Font("Raleway",Font.BOLD,14));
		pan.setBounds(300, 440, 400, 30); 
		pan.addActionListener(this);
		add(pan);
		
		JLabel adhar=new JLabel("Adhar number:");
		adhar.setFont(new Font("Raleway",Font.BOLD,20));
		adhar.setBounds(100, 490, 200, 30);
		add(adhar);
		
		 adharno=new JTextField();
		 adharno.setFont(new Font("Raleway",Font.BOLD,14));
		 adharno.setBounds(300, 490, 400, 30);
		 adharno.addActionListener(this);
		add(adharno);
		
		JLabel Senior=new JLabel("Senior citizen:");
		Senior.setFont(new Font("Raleway",Font.BOLD,20));
		Senior.setBounds(100, 540, 200, 30);
		add(Senior);
		
		 	syes =new JRadioButton("Yes");
		 	syes.setBounds(300, 540, 60, 30);
		 	syes.setBackground(Color.white);
			add(syes);
			
			sno =new JRadioButton("No");
			sno.setBounds(450, 540, 100, 30);
			sno.setBackground(Color.white);
			add(sno);
			
			ButtonGroup Seniorgroup=new ButtonGroup();
			Seniorgroup.add(syes);
			Seniorgroup.add(sno);
		
		
		
		JLabel exisit=new JLabel("Exisiting account:");
		exisit.setFont(new Font("Raleway",Font.BOLD,20));
		exisit.setBounds(100, 590, 200, 30);
		add(exisit);
		
		eyes =new JRadioButton("Yes");
	 	eyes.setBounds(300, 590, 60, 30);
	 	eyes.setBackground(Color.white);
		add(eyes);
		
		eno =new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup exisitgroup=new ButtonGroup();
		exisitgroup.add(eyes);
		exisitgroup.add(eno);
		
		 next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		
		setTitle("new Application form-Page2");
		getContentPane().setBackground(Color.WHITE);
		setSize(800, 800); 
		setLocation(350, 10);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String sreligion=(String)religion.getSelectedItem();
		String scategory=(String)category.getSelectedItem();
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		String pannumber=pan.getText();
		String adhar=adharno.getText();
		String senior=null;
		if(syes.isSelected())
		{
			senior="yes";
		}
		else if(sno.isSelected())
		{
			senior="no";
		}
		String exisit=null;
		if(eyes.isSelected())
		{
			exisit="yes";
		}
		else if(eno.isSelected())
		{
			exisit="no";
		}
		
		try
		{
			Conn c=new Conn();
			String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pannumber+"','"+adhar+"','"+senior+"','"+exisit+"')";
			c.s.executeUpdate(query);
				
			setVisible(false);
			new SignupThree(formno).setVisible(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Signuptwo("");

	}

}
