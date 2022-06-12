package com.fonyou.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fonyou.springboot.backend.apirest.model.Answer;

import lombok.Data;

@Data
@Entity
@Table(name="question")
public class QuestionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Valid
	private String answer;
	private String title;
	private Integer point;
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}


	
	private static final long serialVersionUID = 1L;

}
