package com.fonyou.springboot.backend.apirest.model;

import java.util.List;

import com.fonyou.springboot.backend.apirest.models.entity.AnswerEntity;
import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
	
	private List<QuestionEntity> question;
	private List<AnswerEntity> answer;
	private Integer point;
	private Integer grade;
	
	
	public List<QuestionEntity> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionEntity> question) {
		this.question = question;
	}
	public List<AnswerEntity> getAnswer() {
		return answer;
	}
	public void setAnswer(List<AnswerEntity> answer) {
		this.answer = answer;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
		
	
	

}
