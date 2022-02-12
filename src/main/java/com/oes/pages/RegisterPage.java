package com.oes.pages;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.oes.pojos.Student;

public class RegisterPage extends Page {

	private static RegisterPage registerPage;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTextField qualificationInput;
	private JTextField mobileInput;
	private JTextField emailInput;
	private JTextField passwordInput;
	private JButton registerBtn;
	private JButton cancelBtn;

	private RegisterPage() {
		super();
		name = "OES - Register";
		width = 400;
		height = 500;
		panel = new JPanel();
		panel = new JPanel();
		firstNameInput = new JTextField(10);
		lastNameInput = new JTextField(10);
		qualificationInput = new JTextField(20);
		mobileInput = new JTextField(10);
		emailInput = new JTextField(20);
		passwordInput = new JTextField(10);
		cancelBtn = new JButton("Cancel");
		registerBtn = new JButton("Register");
		init();
	}
	
	public static RegisterPage getInstance() {
		if(registerPage == null)
			registerPage = new RegisterPage();
		return registerPage;
	}
	
	private void init() {
		updateUI();
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameInput.getText();
				String lastName = lastNameInput.getText();
				String qualification = qualificationInput.getText();
				String mobile = mobileInput.getText();
				String email = emailInput.getText();
				String password = passwordInput.getText();
				
				Student studentToRegister = new Student(0, firstName, lastName, qualification, mobile, email, password);
				
				System.out.println("Register button pressed - " + studentToRegister);
				
				//TODO: register the student 
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: cancel the student registration
				close();
				LoginPage.getInstance().open();
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

	public void updateUI() {

		JLabel firstNameLabel = new JLabel("First Name");
		JLabel lastNameLabel = new JLabel("Last Name");
		JLabel qualitificationLabel = new JLabel("Qualification");
		JLabel mobileLabel = new JLabel("Mobile");
		JLabel emailLabel = new JLabel("Email");
		JLabel passwordLabel = new JLabel("Password");

		panel.add(firstNameLabel); // Components Added using Flow Layout
		panel.add(firstNameInput);
		
		panel.add(lastNameLabel);
		panel.add(lastNameInput);
		
		panel.add(qualitificationLabel);
		panel.add(qualificationInput);
		
		panel.add(mobileLabel);
		panel.add(mobileInput);
		
		panel.add(emailLabel);
		panel.add(emailInput);
		
		panel.add(passwordLabel);
		panel.add(passwordInput);

		panel.add(registerBtn);
		panel.add(cancelBtn);
		
		panel.setLayout(new GridLayout(7,2, 20, 30));
		panel.setBorder(new EmptyBorder(10, 10, 20, 10));
	}

}
