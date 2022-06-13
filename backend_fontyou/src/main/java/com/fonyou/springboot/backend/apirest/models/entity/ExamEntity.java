package com.fonyou.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "exams")
public class ExamEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer grade;
	
	@JsonIgnoreProperties({"exam", "hibernateLazyInitializer", "handler",})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="exam", cascade=CascadeType.ALL)
	private List<QuestionEntity> question;
	
	@JsonIgnoreProperties({"exam", "hibernateLazyInitializer", "handler",})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="exam", cascade=CascadeType.ALL)
	private List<StudentEntity> student;
	
	//construct
	public ExamEntity() {
		this.question = new ArrayList<>();
		this.student = new ArrayList<>();
	}
	
	//getter and setter

	public Long getId() {
		return id;
	}

	public List<StudentEntity> getStudent() {
		return student;
	}

	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}

	public List<QuestionEntity> getQuestion() {
		return this.question;
	}

	public void setQuestion(List<QuestionEntity> question) {
		this.question = question;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	private static final long serialVersionUID = 1L;

}
