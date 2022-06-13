package com.fonyou.springboot.backend.apirest.models.services;


import java.util.List;

import com.fonyou.springboot.backend.apirest.models.entity.ExamEntity;
import com.fonyou.springboot.backend.apirest.models.entity.StudentEntity;

public interface StudentServicesInterface {
	
	public List<StudentEntity> findAll();
	
	public void delete(Long id);
	
	public StudentEntity findById(Long id);
	
	public StudentEntity save(StudentEntity student);
	
	public List<ExamEntity> findAllExam();
}
