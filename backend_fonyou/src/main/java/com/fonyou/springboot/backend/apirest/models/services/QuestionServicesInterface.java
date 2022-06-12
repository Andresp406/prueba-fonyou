package com.fonyou.springboot.backend.apirest.models.services;

import java.util.List;

import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

public interface QuestionServicesInterface {
	public List<QuestionEntity> findAll();
}
