package com.oes.pages;

import java.awt.BorderLayout;
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
		
		String formatedName = getFormatedName(Application.getInstance().getLoggedInStudent().getFirstName());
		String welcomeMessage = formatedName;
		JLabel welcomeLabel = new JLabel(welcomeMessage);
		
		panel.add(welcomeLabel, BorderLayout.NORTH);
		panel.add(getExamRulesPanel(), BorderLayout.CENTER);
		panel.add(startExamBtn, BorderLayout.SOUTH); 
		
		panel.setBorder(new EmptyBorder(10, 10, 20, 10));
	}
	
	private JPanel getExamRulesPanel() {
		JPanel rulePanel = new JPanel();
		rulePanel.setLayout(new BorderLayout());
		String ruleText = "This is a simple user friendly software developed using Java. "
				+ "It can be applied to schools ,colleges etc to conduct exams. "
				+ "The procedure for using this software is very easy. "
				+ "Select one of the exams listed in the menu."
				+ "After selecting the choice the exam will be started by clicking continue button. "
				+ "The questions and options are displayed on the screen. "
				+ "We can choose one of the answer. "
				+ "After completing the exam the results are displayed on the screen.";
		ruleText = "<html><body><div style=\" padding: 3px;\"><p style=\" border: 1px solid black; padding: 4px; \">" + ruleText + "</p></div></body></html>";
		JLabel ruleLabel = new JLabel(ruleText);
		
		rulePanel.add(ruleLabel, BorderLayout.CENTER);
		
		return rulePanel;
	}
	
	
	private String getFormatedName(String name) {
		return "<html> <font color=\"#6C07F3\"> Welcome, " + name + "</font></html>";
	}
	

}
