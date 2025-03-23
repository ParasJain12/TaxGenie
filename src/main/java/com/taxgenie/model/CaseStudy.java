package com.taxgenie.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CaseStudy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String example;
	private String description;
	private String photo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "casestudy_categoryId", referencedColumnName = "casestudy_categoryId")
	private CaseStudyCategory caseStudyCategory;

	public Long getId() {
		return id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CaseStudyCategory getCaseStudyCategory() {
		return caseStudyCategory;
	}

	public void setCaseStudyCategory(CaseStudyCategory caseStudyCategory) {
		this.caseStudyCategory = caseStudyCategory;
	}

	public CaseStudy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseStudy(Long id, String title, String example, String description, String photo,
			CaseStudyCategory caseStudyCategory) {
		super();
		this.id = id;
		this.title = title;
		this.example = example;
		this.description = description;
		this.photo = photo;
		this.caseStudyCategory = caseStudyCategory;
	}


}
