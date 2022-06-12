package com.fonyou.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fonyou.springboot.backend.apirest.constants.EnumConstantsApi;
import com.fonyou.springboot.backend.apirest.model.Message;
import com.fonyou.springboot.backend.apirest.model.Student;
import com.fonyou.springboot.backend.apirest.models.services.StudentServicesImpl;

@Component
public class StudentRestController {

	@Autowired
	StudentServicesImpl studentEntity;
	
	public Message createStudent(Student student) {
		Message msg = new Message();
		try {
			studentEntity.createStudent(student);
			msg.setMessage(EnumConstantsApi.ST_MESSAGE_QUESTION_OK.getValue());
		}catch(Exception e){
			msg.setMessage("Error: " + e.getMessage());
		}
		return msg;
	}
}
