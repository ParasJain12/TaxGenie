package com.taxgenie.dto;

import lombok.Data;

@Data
public class CaseStudyDTO {

	private Long id;
	private String title;
	private String example;
	private String description;
	private String photo;
	private int casestudy_categoryId;

	public Long getId() {
		return id;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getCasestudy_categoryId() {
		return casestudy_categoryId;
	}

	public void setCasestudy_categoryId(int casestudy_categoryId) {
		this.casestudy_categoryId = casestudy_categoryId;
	}

	public CaseStudyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
