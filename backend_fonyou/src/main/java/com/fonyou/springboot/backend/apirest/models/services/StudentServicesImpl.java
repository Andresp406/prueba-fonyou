package com.fonyou.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fonyou.springboot.backend.apirest.model.Student;
import com.fonyou.springboot.backend.apirest.models.dao.StudentDaoInterface;
import com.fonyou.springboot.backend.apirest.models.entity.StudentEntity;

@Service
@ComponentScan
public class StudentServicesImpl implements StudentServicesInterface{

	@Autowired
	private StudentDaoInterface studentDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<StudentEntity> findAll() {
		return (List<StudentEntity>) this.studentDao.findAll();
	}
	
	@Override
	@Transactional()
	public void createStudent(Student student) {
		StudentEntity studentSave = new StudentEntity();
		studentSave.setName(student.getName());
		studentSave.setLastName(student.getLastName());
		studentSave.setAge(student.getAge());		
		studentSave.setTimeZone(student.getTimeZone());
		studentDao.save(studentSave);
	}

}
