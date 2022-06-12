package com.fonyou.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fonyou.springboot.backend.apirest.model.Question;
import com.fonyou.springboot.backend.apirest.models.dao.QuestionDaoInterface;
import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

@Service
@ComponentScan
public class QuestionServicesImpl implements QuestionServicesInterface {

	@Autowired
	private QuestionDaoInterface questionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<QuestionEntity> findAll() {
		return (List<QuestionEntity>) this.questionDao.findAll();
	}
	
	public void createQuestion(Question question) {
		QuestionEntity questionSave = new QuestionEntity();
		
		questionSave.setAnswer(String.valueOf(questionSave.getAnswer()));
		questionSave.setPoint(question.getPoints());
		questionSave.setTitle(question.getTitle());
		
		questionDao.save(questionSave);
	}
}
