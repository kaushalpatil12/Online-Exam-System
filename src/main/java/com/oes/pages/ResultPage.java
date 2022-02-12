package com.oes.pages;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.oes.app.Application;
import com.oes.pojos.Result;

public class ResultPage extends Page {

	private static ResultPage resultPage;
	private JButton logoutBtn;
	JTextField nameTextField, percentTextField, statusTextField;
	Result result;
	

	private ResultPage() {
		super();
		name = "OES - Results";
		width = 400;
		height = 400;
		panel = new JPanel();
		logoutBtn = new JButton("Logout");
		init();
	}

	public static ResultPage getInstance() {
		if(resultPage == null) 
			resultPage = new ResultPage();
		return resultPage;
	}
	
	private void init() {
		initUI();
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				LoginPage.getInstance().open();
			}
		});
	}
	
	private JPanel getResultPanel() {
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(3, 2, 10, 10));
		//name, percent, status
		JLabel nameLabel = new JLabel("Name");
		JLabel percentLabel = new JLabel("Percent");
		JLabel statusLabel = new JLabel("Status");
		
		nameTextField = new JTextField(20);
		percentTextField = new JTextField(20);
		statusTextField = new JTextField(20);
		
		nameTextField.setEditable(false);
		percentTextField.setEditable(false);
		statusTextField.setEditable(false);
		
		resultPanel.add(nameLabel);
		resultPanel.add(nameTextField);
		
		resultPanel.add(percentLabel);
		resultPanel.add(percentTextField);
		
		resultPanel.add(statusLabel);
		resultPanel.add(statusTextField);
		
		return resultPanel;
	}
	

	private void initUI() {
		panel.setLayout(new BorderLayout(20, 15));
		
		JLabel resultLabel = new JLabel("Result");
		
		panel.add(resultLabel, BorderLayout.NORTH);
		panel.add(getResultPanel(), BorderLayout.CENTER);
		panel.add(logoutBtn, BorderLayout.SOUTH); 
		
		panel.setBorder(new EmptyBorder(10, 10, 20, 10));
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
		updateResult();
	}
	
	
	private void updateResult() {
		nameTextField.setText(Application.getInstance().getLoggedInStudent().getFirstName());
		percentTextField.setText(result.getPercent()+"%");
		statusTextField.setText(result.getStatus().toString());
	}
	
	

}
