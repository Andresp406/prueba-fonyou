package com.fonyou.springboot.backend.apirest.models.services;

import java.util.List;


import com.fonyou.springboot.backend.apirest.models.entity.AnswerEntity;
import com.fonyou.springboot.backend.apirest.models.entity.ExamEntity;
import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

public interface ExamServicesInterface {
	
	public List<ExamEntity> findAll();
	
	public ExamEntity save(ExamEntity question);
	
	public ExamEntity findById(Long id);
	
	public void delete(Long id);
	
	public List<QuestionEntity> findAllQuestion();
	
	public List<AnswerEntity> findAllAnswer();
	
}
