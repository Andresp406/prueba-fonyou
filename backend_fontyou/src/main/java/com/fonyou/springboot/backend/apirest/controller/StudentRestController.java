package com.fonyou.springboot.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fonyou.springboot.backend.apirest.constants.EnumConstantsApi;
import com.fonyou.springboot.backend.apirest.models.entity.ExamEntity;
import com.fonyou.springboot.backend.apirest.models.entity.StudentEntity;
import com.fonyou.springboot.backend.apirest.models.services.StudentServicesInterface;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController()
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentServicesInterface studentService;
	
	@GetMapping("/student")
	public List<StudentEntity> index(){
		return this.studentService.findAll();
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		StudentEntity student = null;
		Map<String, Object> response = new HashMap<>();
		try {
			student = this.studentService.findById(id);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar la consulta : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (student == null) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "El estudiante con ID: ".concat(id.toString().concat("No existe en base de datos")));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PostMapping("/create-student")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody StudentEntity student, BindingResult result){
		StudentEntity studentNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo '"+ error.getField() +"' " + error.getDefaultMessage()).collect(Collectors.toList());
			
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			studentNew = this.studentService.save(student);
		}catch(DataAccessException e) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar el Insert : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Cliente creado con exito");
		response.put(EnumConstantsApi.ST_STUDENT_JSON.getValue(), studentNew);
		
		return new ResponseEntity<>( response, HttpStatus.CREATED);
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody StudentEntity student,BindingResult result,  @PathVariable Long id) {
		System.out.println(student);
		StudentEntity studentNow = studentService.findById(id);
		StudentEntity studentUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo '"+ error.getField() +"' " + error.getDefaultMessage()).collect(Collectors.toList());
			
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (studentNow == null) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error no se pudo editar con ID: ".concat(id.toString()));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			studentNow.setName(student.getName());
			studentNow.setLastName(student.getLastName());
			studentNow.setAge(student.getAge());
			studentNow.setCity(student.getCity());
			studentNow.setTimeZone(student.getTimeZone());
			
			studentUpdate = studentService.save(studentNow);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar la consulta : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Cliente actualizado con exito");
		response.put(EnumConstantsApi.ST_STUDENT_JSON.getValue(), studentUpdate);
	
		
		return new ResponseEntity<>( response, HttpStatus.CREATED); 
		
	}
	 

	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try{
			this.studentService.delete(id);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al eliminar al estudiante : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "cliente eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/student/exam")
	public List<ExamEntity> getExams(){
		return this.studentService.findAllExam();
	}
	
	
}
