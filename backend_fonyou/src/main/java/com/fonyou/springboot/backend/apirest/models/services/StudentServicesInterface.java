package com.fonyou.springboot.backend.apirest.models.services;


import java.util.List;

import com.fonyou.springboot.backend.apirest.model.Student;
import com.fonyou.springboot.backend.apirest.models.entity.StudentEntity;

public interface StudentServicesInterface {
	
	public List<StudentEntity> findAll();
	
	public void createStudent(Student student);
}
