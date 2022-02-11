package com.oes.pages;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPage extends Page {

	private static LoginPage loginPage;
	private JTextField usernameInput;
	private JPasswordField passwordInput;
	private JButton loginBtn;
	private JButton registerBtn;

	private LoginPage() {
		super();
		name = "OES - Login";
		width = 400;
		height = 200;
		panel = new JPanel();
		usernameInput = new JTextField(10); // accepts upto 10 characters
		passwordInput = new JPasswordField(10);
		loginBtn = new JButton("Login");
		registerBtn = new JButton("Sign up");
		init();
	}

	public static LoginPage getInstance() {
		if(loginPage == null) 
			loginPage = new LoginPage();
		return loginPage;
	}
	
	private void init() {
		updateUI();
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameInput.getText();
				String password = String.valueOf(passwordInput.getPassword());
				if(validate(username, password)) {
					doLogin(username, password);
				}
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				RegisterPage.getInstance().open();
			}
		});
	}
	
	private boolean validate(String username, String password) {
		//TODO: validate user input here
		String regex = "[a-z]*";
		Pattern p = Pattern.compile(regex);//. represents single character  
		boolean isUsernameValid = p.matcher(username).matches();  
		
		System.out.println("isUsernameValid====" + isUsernameValid);
		
		if(!isUsernameValid) {
			display("please enter valid username");
			return false;
		}
		return true;
		
	}
	
	private void doLogin(String username, String password) {
		if(username.equals("kaushal") && password.equals("pass123")) {
			display("Login Successful.");
		}else {
			display("Username or password is wrong, please try again.");
		}
	}
	
	private void display(String msg) {
		JOptionPane.showMessageDialog(panel, msg);
	}

	private void updateUI() {
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
	}
	

}
