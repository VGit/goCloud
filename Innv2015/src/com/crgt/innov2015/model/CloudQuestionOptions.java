package com.crgt.innov2015.model;

import java.util.List;

public class CloudQuestionOptions {
	private String question;
	private List<Option> optionList;
	private String answer;
	private String questionType;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}
