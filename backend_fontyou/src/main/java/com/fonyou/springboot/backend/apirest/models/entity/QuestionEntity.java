package com.fonyou.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "questions")
public class QuestionEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 4, max = 21)
	private String title;

	@Column(nullable = false)
	@NotEmpty
	@Size(min = 4, max = 21)
	private Integer point;

	@JsonIgnoreProperties({"question","hibernateLazyInitializer", "handler",})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="question", cascade=CascadeType.ALL)
	private List<AnswerEntity> answer;
	
	@JsonIgnoreProperties({"question", "hibernateLazyInitializer", "handler",})
    @ManyToOne(fetch=FetchType.LAZY)
	private ExamEntity exam;
	
	//construct
	public QuestionEntity() {
		this.answer = new ArrayList<>();
	}
	
	//getters and setters

	public List<AnswerEntity> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerEntity> answer) {
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
	
	public ExamEntity getExam() {
		return exam;
	}

	public void setExam(ExamEntity exam) {
		this.exam = exam;
	}


	private static final long serialVersionUID = 1L;

}
