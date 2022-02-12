package com.oes.pojos;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	int id;
	String question;
	List<Option> options;
	Option answer;
	boolean isAnswered;
	Option userSelectedOption;
	
	public Question() {
		isAnswered = false;
		options = new ArrayList<Option>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option getAnswer() {
		return answer;
	}

	public void setAnswer(Option answer) {
		this.answer = answer;
	}
	
	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public Option getUserSelectedOption() {
		return userSelectedOption;
	}

	public void setUserSelectedOption(Option userSelectedOption) {
		this.userSelectedOption = userSelectedOption;
		this.isAnswered = true;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", options=" + options + ", answer=" + answer + "]";
	}

}
