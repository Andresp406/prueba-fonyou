package com.fonyou.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fonyou.springboot.backend.apirest.models.dao.ExamDaoInterface;
import com.fonyou.springboot.backend.apirest.models.entity.AnswerEntity;
import com.fonyou.springboot.backend.apirest.models.entity.ExamEntity;
import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

@Service
@ComponentScan
public class ExamServicesImpl implements ExamServicesInterface {

	@Autowired
	private ExamDaoInterface examDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ExamEntity> findAll() {
		return (List<ExamEntity>) this.examDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ExamEntity findById(Long id) {
		return this.examDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ExamEntity save(ExamEntity exam) {
		return examDao.save(exam);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		this.examDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<QuestionEntity> findAllQuestion() {
		return this.examDao.findAllQuestion();
	}

	@Override
	@Transactional(readOnly = true)
	public List<AnswerEntity> findAllAnswer() {
		return this.examDao.findAllAnswer();
	}

}
