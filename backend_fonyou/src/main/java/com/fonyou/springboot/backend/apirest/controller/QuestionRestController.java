package com.fonyou.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fonyou.springboot.backend.apirest.constants.EnumConstantsApi;
import com.fonyou.springboot.backend.apirest.model.Message;
import com.fonyou.springboot.backend.apirest.model.Question;
import com.fonyou.springboot.backend.apirest.models.services.QuestionServicesImpl;

@Component
public class QuestionRestController {
	
	@Autowired
	QuestionServicesImpl questionEntity;
	
	public Message createQuestion(Question question) {
		Message msg = new Message();
		try {
			questionEntity.createQuestion(question);
			msg.setMessage(EnumConstantsApi.ST_MESSAGE_QUESTION_OK.getValue());
		}catch(Exception e){
			msg.setMessage("Error: " + e.getMessage());
		}
		return msg;
	}
	
}
