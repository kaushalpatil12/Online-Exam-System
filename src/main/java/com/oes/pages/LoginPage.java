package com.oes.pages;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.oes.app.Application;

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
					boolean isAuthenticated = Application.getInstance().login(username, password);
					if(isAuthenticated) {
						close();
						WelcomePage.getInstance().open();
					}else {
						display("Username or password is wrong, please try again.");
					}
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
		if(!emailValidate(username)) {
			display("please enter valid email id");
			return false;
		}
		return true;
		
	}
	
	private boolean emailValidate(String email) {
	    Matcher matcher = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}(.[a-z]{2,3})+$|^$", Pattern.CASE_INSENSITIVE).matcher(email);
	    return matcher.find();
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
