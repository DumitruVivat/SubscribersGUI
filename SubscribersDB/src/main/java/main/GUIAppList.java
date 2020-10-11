package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import domain.Human;
import domain.HumanRepository;

public class GUIAppList {
	
private static HumanRepository hr;

public static void main(String[] args) throws SQLException {
		
		//HW1: LOAD FROM DATABASE
		// some data list (aka - database subscribers)
	    hr = new HumanRepository();
		
		
		//PREPARING GUI INTERFACE
		JFrame window = new JFrame("Simple GUI APP");
		window.setSize(600, 600); // pixels
		
		//set Grid layout for the CONTENT panel
		window.getContentPane().setLayout(new GridBagLayout());
		//setting
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.ipadx = 30;
		constraints.ipady = 20;
		
		
		JList listEmails   = new JList(hr.all().toArray());
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 10;
		window.getContentPane().add(listEmails,constraints);
		
		
		
		JTextField emailField = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 7;
		constraints.gridheight = 1;
		window.getContentPane().add(emailField,constraints);
		JTextField nameField  = new JTextField();
		constraints.gridx = 1;
		constraints.gridy = 8;
		constraints.gridheight = 1;
		window.getContentPane().add(nameField,constraints);
		JButton btnAdd   = new JButton("ADD");
		constraints.gridx = 1;
		constraints.gridy = 9;
		constraints.gridheight = 1;
		window.getContentPane().add(btnAdd,constraints);
		
		window.setVisible(true);
		
		
		//EVEMTS -> ACTIONS
		//Observer design pattern!!!
		btnAdd.addActionListener(new ActionListener() {
		 @Override
		 public void actionPerformed(ActionEvent e) {
			Human h = null;
			String email = emailField.getText(); //.setText()
		    String name  = nameField.getText();	
			h = new Human(email,name);
			try {
				hr.create(h);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		 }	
		});
	}

}
