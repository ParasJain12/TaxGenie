package com.taxgenie.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class FAQ {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ques;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faq_category_id", referencedColumnName = "faq_category_id")
	private FAQCategory faqCategory;
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

	public FAQCategory getFaqCategory() {
		return faqCategory;
	}

	public void setFaqCategory(FAQCategory faqCategory) {
		this.faqCategory = faqCategory;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
