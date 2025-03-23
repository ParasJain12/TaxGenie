package com.taxgenie.dto;

import lombok.Data;

@Data
public class FAQdto {

	private Long id;
	private String ques;
	private int faq_category_id;
	private String answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public int getFaq_category_id() {
		return faq_category_id;
	}

	public void setFaq_category_id(int faq_category_id) {
		this.faq_category_id = faq_category_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
