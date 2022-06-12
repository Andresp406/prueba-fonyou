package com.fonyou.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="exam")
public class ExamEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String question;
	private String answer;
	private Integer point;
	private Integer grade;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getAnswer() {
		return this.answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public String getQuestion() {
		return this.question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public int getPoint() {
		return this.point;
	}



	public void setPoint(Integer point) {
		this.point = point;
	}



	public int getGrade() {
		return this.grade;
	}



	public void setGrade(Integer grade) {
		this.grade = grade;
	}



	private static final long serialVersionUID = 1L;

}
