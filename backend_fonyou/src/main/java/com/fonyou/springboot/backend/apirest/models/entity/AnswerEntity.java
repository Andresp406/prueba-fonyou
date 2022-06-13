package com.fonyou.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "answers")
public class AnswerEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="opcion")
	private String option;

	@NotNull(message = "Se requiere indicar si la respuesta correcta.")
	@Column(name="is_valid")
	private Boolean isValid;
	
	@JsonIgnoreProperties({"answer", "hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch=FetchType.LAZY)
	private QuestionEntity question;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOption() {
		return option;
	}


	public void setOption(String option) {
		this.option = option;
	}


	public Boolean getIsValid() {
		return isValid;
	}


	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}


	public QuestionEntity getQuestion() {
		return question;
	}


	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}


	private static final long serialVersionUID = 1L;

}
