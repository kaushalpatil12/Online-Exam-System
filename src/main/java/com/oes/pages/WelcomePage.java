package com.oes.pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.oes.app.Application;

public class WelcomePage extends Page {

	private static WelcomePage welcomePage;
	private JButton startExamBtn;
	

	private WelcomePage() {
		super();
		name = "OES - Welcome";
		width = 400;
		height = 400;
		panel = new JPanel();
		startExamBtn = new JButton("Start Exam");
		init();
	}

	public static WelcomePage getInstance() {
		if(welcomePage == null) 
			welcomePage = new WelcomePage();
		return welcomePage;
	}
	
	private void init() {
		updateUI();
		startExamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				ExamPage.getInstance().open();
			}
		});
	}
	

	private void updateUI() {
		panel.setLayout(new BorderLayout(20, 15));
		
		String welcomeMessage = "Welcome, " + Application.getInstance().getLoggedInStudent().getFirstName() + "!!";
		JLabel welcomeLabel = new JLabel(welcomeMessage);
		
		panel.add(welcomeLabel, BorderLayout.NORTH);
		
		panel.add(startExamBtn, BorderLayout.SOUTH); 
		
		panel.setBorder(new EmptyBorder(10, 10, 20, 10));
	}
	

}
