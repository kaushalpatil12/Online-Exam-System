package com.oes.pojos;

import java.util.List;
import java.util.stream.Collectors;

import com.oes.data.QuestionData;

public class Exam {
	
	Student student;
	List<Question> questions;
	private Question currentQuestion;
	int currentQuestionIndex;
	int totalQuestionCount;
	int attemptedQuestionCount;
	int passedQuestionCount;
	
	public Exam() {
		this(new QuestionData().getAllQuestions());
	}
	
	public Exam(List<Question> questions) {
		super();
		currentQuestionIndex = 0;
		this.questions = questions;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int getCurrentQuestionIndex() {
		return currentQuestionIndex;
	}

	public void setCurrentQuestionIndex(int currentQuestionIndex) {
		this.currentQuestionIndex = currentQuestionIndex;
	}

	public int getTotalQuestionCount() {
		return totalQuestionCount;
	}

	public void setTotalQuestionCount(int totalQuestionCount) {
		this.totalQuestionCount = totalQuestionCount;
	}

	public int getAttemptedQuestionCount() {
		return attemptedQuestionCount;
	}

	public void setAttemptedQuestionCount(int attemptedQuestionCount) {
		this.attemptedQuestionCount = attemptedQuestionCount;
	}

	public int getPassedQuestionCount() {
		return passedQuestionCount;
	}

	public void setPassedQuestionCount(int passedQuestionCount) {
		this.passedQuestionCount = passedQuestionCount;
	}
	

	public Question getCurrentQuestion() {
		return questions.get(currentQuestionIndex);
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public Result generateResult() {
		totalQuestionCount = questions.size();
		List<Question> attemptedQuestions = questions.stream().filter( que -> que.isAnswered).collect(Collectors.toList());
		attemptedQuestionCount = attemptedQuestions.size();
		
		List<Question> passedQuestions = attemptedQuestions.stream().filter( que -> que.getAnswer().equals(que.getUserSelectedOption())).collect(Collectors.toList());
		passedQuestionCount = passedQuestions.size();
		
		Result result = new Result(passedQuestionCount, totalQuestionCount);
		return result;
	}

}
