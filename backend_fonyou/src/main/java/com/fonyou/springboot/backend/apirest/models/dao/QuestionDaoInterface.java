package com.fonyou.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fonyou.springboot.backend.apirest.models.entity.QuestionEntity;

public interface QuestionDaoInterface extends CrudRepository<QuestionEntity, Long>{

}
