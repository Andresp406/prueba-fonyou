package com.fonyou.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fonyou.springboot.backend.apirest.models.entity.AnswerEntity;
import com.fonyou.springboot.backend.apirest.models.entity.ExamEntity;
import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

public interface ExamDaoInterface extends CrudRepository<ExamEntity, Long>{

	@Query("from QuestionEntity")
	public List<QuestionEntity> findAllQuestion();
	
	@Query("from AnswerEntity")
	public List<AnswerEntity> findAllAnswer();
}
