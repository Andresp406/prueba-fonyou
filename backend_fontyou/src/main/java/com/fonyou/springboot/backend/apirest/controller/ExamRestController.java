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
import com.fonyou.springboot.backend.apirest.models.services.ExamServicesInterface;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController()
@RequestMapping("/api")
public class ExamRestController {
	
	@Autowired
	private ExamServicesInterface examService;

	@GetMapping("/exam")
	public List<ExamEntity> index(){
		return this.examService.findAll();
	}
	
	@GetMapping("/exam/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		ExamEntity exam = null;
		Map<String, Object> response = new HashMap<>();
		try {
			exam = this.examService.findById(id);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar la consulta : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (exam == null) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "El Examen con ID: ".concat(id.toString().concat("No existe en base de datos")));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(exam, HttpStatus.OK);
	}
	
	@PostMapping("/create-exam")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody ExamEntity exam, BindingResult result){
		ExamEntity examNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo '"+ error.getField() +"' " + error.getDefaultMessage()).collect(Collectors.toList());
			
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			examNew = this.examService.save(exam);
		}catch(DataAccessException e) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar el Insert : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Examen creado con exito");
		response.put("exam", examNew);
		
		return new ResponseEntity<>( response, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/exam/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ExamEntity exam, BindingResult result, @PathVariable Long id) {
		
		ExamEntity examNow = examService.findById(id);
		ExamEntity examUpdate = null;
		Map<String, Object> response = new HashMap<>();
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo '"+ error.getField() +"' " + error.getDefaultMessage()).collect(Collectors.toList());
			
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), errors);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		
		if (examNow == null) {
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error no se pudo editar con ID: ".concat(id.toString()));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			examNow.setGrade(exam.getGrade());
			examNow.setQuestion(exam.getQuestion());

			examUpdate = examService.save(examNow);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al realizar la consulta : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Examen actualizado con exito");
		response.put(EnumConstantsApi.ST_EXAM_JSON.getValue(), examUpdate);
	
		
		return new ResponseEntity<>( response, HttpStatus.CREATED); 
		
	}
	

	@DeleteMapping("/exam/{id}")
	public ResponseEntity<?> delete(Long id) {
		Map<String, Object> response = new HashMap<>();
		try{
			this.examService.delete(id);
		}catch(DataAccessException e){
			response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "Error al eliminar el examen : en base de datos");
			response.put(EnumConstantsApi.ST_ERROR_JSON.getValue(), e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put(EnumConstantsApi.ST_MESSAGE_JSON.getValue(), "examen eliminado con exito");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
