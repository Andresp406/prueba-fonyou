package com.fonyou.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.fonyou.springboot.backend.apirest.models.entity.*;

public interface StudentDaoInterface extends CrudRepository<StudentEntity, Long>{

	@Query("from ExamEntity")
	public List<ExamEntity> findAllExam();
	
}
