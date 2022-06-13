package com.fonyou.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.fonyou.springboot.backend.apirest.models.dao.StudentDaoInterface;
import com.fonyou.springboot.backend.apirest.models.entity.ExamEntity;
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
	@Transactional(readOnly = true)
	public StudentEntity findById(Long id) {
		return this.studentDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public StudentEntity save(StudentEntity student) {
		return studentDao.save(student);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		this.studentDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExamEntity> findAllExam() {
		return this.studentDao.findAllExam();
	}




}
