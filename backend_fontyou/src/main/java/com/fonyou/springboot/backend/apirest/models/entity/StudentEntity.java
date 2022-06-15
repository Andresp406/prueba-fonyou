package com.fonyou.springboot.backend.apirest.models.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="students")
public class StudentEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable=false)
	@Size(min=4, max=21)
	private String name; 
	
	@Column(name="last_name", nullable=false)
	@Size(min=4, max=21)
	private String lastName;
	
	@Column(nullable=false)
	private Integer age;
	
	@Column(nullable=false)
	private String city;
	
	@Column(name="time_zone")
	@Temporal(TemporalType.DATE)
	private Date timeZone;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "exam"})
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="exam_id")
	private ExamEntity exam;
	
	private String photo;
	
	//getter and setter
	public ExamEntity getExam() {
		return exam;
	}

	public void setExam(ExamEntity exam) {
		this.exam = exam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Date timeZone) {
		this.timeZone = timeZone;
	}
	
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}



	private static final long serialVersionUID = 1L;

}
