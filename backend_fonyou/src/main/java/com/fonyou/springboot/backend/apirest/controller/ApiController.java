package com.fonyou.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.springboot.backend.apirest.model.Question;
import com.fonyou.springboot.backend.apirest.model.Student;
import com.fonyou.springboot.backend.apirest.models.dao.StudentDaoInterface;
import com.fonyou.springboot.backend.apirest.models.entity.StudentEntity;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController()
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private StudentDaoInterface studentDao;
	
	@Autowired
	private StudentRestController controllerStudent;
	
	@Autowired
	private QuestionRestController controllerQuestion;
	
	@GetMapping("/student")
	public List<StudentEntity> index(){
		return (List<StudentEntity>) this.studentDao.findAll();
	}
	
	@PostMapping("/create-question")
	public ResponseEntity<?> createQuestion(@RequestBody Question question){
		return new ResponseEntity<>(controllerQuestion.createQuestion(question), HttpStatus.CREATED);
	}
	
	@PostMapping("/create-student")
	public ResponseEntity<?> createStudent(@RequestBody Student student){
		return new ResponseEntity<>(controllerStudent.createStudent(student), HttpStatus.CREATED);
		
	}
}
