package com.oes.pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.oes.pojos.Exam;
import com.oes.pojos.Option;
import com.oes.pojos.Question;

public class ExamPage extends Page {

	private static ExamPage examPage;
	private Question currentQuestion;
	private JRadioButton optionA, optionB, optionC, optionD;
	private Exam exam;
	private JLabel currentQuestionLabel;
	private JLabel optionALabel, optionBLabel, optionCLabel, optionDLabel ;
	private ButtonGroup options;


	private ExamPage() {
		super();
		exam = new Exam();
		name = "OES - Online Exam";
		width = 400;
		height = 400;
		panel = new JPanel();
		optionA = new JRadioButton("a");
		optionB = new JRadioButton("b");
		optionC = new JRadioButton("c");
		optionD = new JRadioButton("d");
		
		currentQuestion = exam.getCurrentQuestion();
		init();
	}

	public static ExamPage getInstance() {
		if(examPage == null) 
			examPage = new ExamPage();
		return examPage;
	}

	private void init() {
		initUI();
	}


	private void initUI() {
		panel.setLayout(new BorderLayout(20, 15));
		panel.add(getEndExamButtonPanel(), BorderLayout.NORTH);
		panel.add(getQuestionWithOptionsPanel(), BorderLayout.CENTER);
		panel.add(getNavButtonPanel(), BorderLayout.SOUTH); 
		panel.setBorder(new EmptyBorder(10, 10, 20, 10));
		addListenersToRadioButtons();
	}


	private JPanel getQuestionWithOptionsPanel() {
		JPanel qoPanel = new JPanel();
		qoPanel.setLayout(new BorderLayout(10, 10));
		qoPanel.add(getQuestionPanel(), BorderLayout.NORTH);
		qoPanel.add(getOptionsPanel(), BorderLayout.CENTER);

		return qoPanel;
	}

	private JPanel getQuestionPanel() {
		JPanel qPanel = new JPanel();
		qPanel.setLayout(new FlowLayout());
		String index = "Que " + (exam.getCurrentQuestionIndex() + 1) + ". ";
		currentQuestionLabel =  new JLabel(index + currentQuestion.getQuestion());
		qPanel.add(currentQuestionLabel);

		return qPanel;
	}

	private JPanel getOptionsPanel() {
		JPanel oPanel = new JPanel();
		oPanel.setLayout(new GridLayout(4,1));
		options = new ButtonGroup();
		options.add(optionA);
		options.add(optionB);
		options.add(optionC);
		options.add(optionD);
		
		
		for (Option option : currentQuestion.getOptions()) {
			oPanel.add(getOPanel(option));
		}
		return oPanel;
	}

	private JPanel getOPanel(Option option) {
		JPanel optionPanel = new JPanel();
		switch (option.getName().toLowerCase()) {
		case "a":
			optionPanel.add(optionA);
			optionALabel = new JLabel(option.getValue());
			optionPanel.add(optionALabel);
			break;
		case "b":
			optionPanel.add(optionB);
			optionBLabel = new JLabel(option.getValue());
			optionPanel.add(optionBLabel);
			break;
		case "c":
			optionPanel.add(optionC);
			optionCLabel = new JLabel(option.getValue());
			optionPanel.add(optionCLabel);
			break;
		case "d":
			optionPanel.add(optionD);
			optionDLabel = new JLabel(option.getValue());
			optionPanel.add(optionDLabel);
			break;
		default:
			break;
		}
		return optionPanel;
	}
	
	
	private JPanel getEndExamButtonPanel() {
		JPanel endButtonPanel = new JPanel();
		endButtonPanel.setLayout(new BorderLayout());
		JButton endButton = new JButton("End Exam");
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				endExamButtonPressed();
			}
		});
		
		endButtonPanel.add(endButton, BorderLayout.LINE_END);
		return endButtonPanel;
	}

	private JPanel getNavButtonPanel() {
		JButton prevBtn = new JButton("<-");
		JButton nextBtn = new JButton("->");

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(prevBtn);
		buttonPanel.add(nextBtn);

		prevBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prevButtonPressed();
			}
		});
		
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nextButtonPressed();
				
			}
		});

		return buttonPanel;
	}
	
	private void endExamButtonPressed() {
		System.out.println("--------------------------------------");
		System.out.println("Ohooo, here are your Results:");
		System.out.println("--------------------------------------");
		System.out.println(exam.generateResult());
		System.out.println("--------------------------------------");
	}

	private void prevButtonPressed() {
		int currentQueIndex = exam.getCurrentQuestionIndex();
		if(currentQueIndex > 0) {
			exam.setCurrentQuestionIndex(currentQueIndex - 1);
		}
		System.out.println("Previous button pressed." + currentQueIndex);
		updateQuestion();
	}

	private void nextButtonPressed() {
		int currentQueIndex = exam.getCurrentQuestionIndex();
		if(currentQueIndex < exam.getQuestions().size() - 1) {
			exam.setCurrentQuestionIndex(currentQueIndex + 1);
		}
		System.out.println("next button pressed." + currentQueIndex + exam.getCurrentQuestion());
		updateQuestion();
	}
	
	private void updateQuestion() {
		options.clearSelection();
		//Question
		String index = "Que " + (exam.getCurrentQuestionIndex() + 1) + ". ";
		String question = index + exam.getCurrentQuestion().getQuestion();
		currentQuestionLabel.setText(question);
		
		//options
		exam.getCurrentQuestion().getOptions().forEach( option -> updateOPanel(option));
		updateRadioButtonSelection();
		
	}
	
	private void updateOPanel(Option option) {

		switch (option.getName().toLowerCase()) {
		case "a":
			optionALabel.setText(option.getValue());
			break;
		case "b":
			optionBLabel.setText(option.getValue());
			break;
		case "c":
			optionCLabel.setText(option.getValue());
			break;
		case "d":
			optionDLabel.setText(option.getValue());
			break;
		default:
			break;
		}
	}
	
	private void updateRadioButtonSelection() {
		System.out.println("isAnswered --- "+ exam.getCurrentQuestion().isAnswered());
		
		if(exam.getCurrentQuestion().isAnswered()) {
			switch (exam.getCurrentQuestion().getUserSelectedOption().getName()) {
			case "a":
				optionA.setSelected(true);
				break;
			case "b":
				optionB.setSelected(true);
				break;
			case "c":
				optionC.setSelected(true);
				break;
			case "d":
				optionD.setSelected(true);
				break;
			default:
				break;
			}
		}
	}
	
	
	private void addListenersToRadioButtons() {
		optionA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Option A --- selected.");
				exam.getCurrentQuestion().setUserSelectedOption(getOption("a"));
			}
		});
		
		optionB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Option B --- selected.");
				exam.getCurrentQuestion().setUserSelectedOption(getOption("b"));
			}
		});
		
		optionC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Option C --- selected.");
				exam.getCurrentQuestion().setUserSelectedOption(getOption("c"));
			}
		});
		
		optionD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Option D --- selected.");
				exam.getCurrentQuestion().setUserSelectedOption(getOption("d"));
			}
		});
	}
	
	
	
	private Option getOption(String name) {
		return new Option(name, "");
	}
	
	
}
