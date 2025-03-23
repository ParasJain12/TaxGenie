package com.taxgenie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CaseStudyCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "casestudy_categoryId")
	private int id;
	private String name;

	public CaseStudyCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaseStudyCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
