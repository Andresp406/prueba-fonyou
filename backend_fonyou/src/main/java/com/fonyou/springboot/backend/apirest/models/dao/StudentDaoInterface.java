package com.fonyou.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.fonyou.springboot.backend.apirest.models.entity.*;

public interface StudentDaoInterface extends CrudRepository<StudentEntity, Long>{

}
