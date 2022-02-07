package com.oes.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPage {

	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton loginBtn;
	private JButton registerBtn;
	private JPanel panel;

	public LoginPage() {
		panel = new JPanel();
		usernameInput = new JTextField(10); // accepts upto 10 characters
		passwordInput = new JPasswordField(10);
		loginBtn = new JButton("Login");
		registerBtn = new JButton("Sign up");
		init();
	}
	
	private void init() {
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validate();
				//System.out.println("Login button pressed." + username);
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				validate();
			}
		});
	}
	
	private void validate() {
		String username = usernameInput.getText();
		char[] password = passwordInput.getPassword();
		
		if(username.equals("kaushal") && String.valueOf(password).equals("pass123")) {
			JOptionPane.showMessageDialog(panel, "Login Successful.");
		}else {
			JOptionPane.showMessageDialog(panel, "Username or password is wrong, please try again.");
		}
	}

	public JPanel getLoginUI() {
		//Creating the panel at bottom and adding components
		JPanel panel = new JPanel(); // the panel is not visible in output

		JLabel usernameLabel = new JLabel("Enter Username");
		JLabel passwordLabel = new JLabel("Enter Password");

		panel.add(usernameLabel); // Components Added using Flow Layout
		panel.add(usernameInput);
		panel.add(passwordLabel);
		panel.add(passwordInput);

		panel.add(loginBtn);
		panel.add(registerBtn);
		panel.setLayout(new GridLayout(3,2, 20, 30));
		panel.setBorder(new EmptyBorder(10, 10, 20, 10));
		return panel;
	}

}
