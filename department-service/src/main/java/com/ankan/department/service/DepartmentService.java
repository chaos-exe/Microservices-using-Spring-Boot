package com.ankan.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankan.department.entity.Department;
import com.ankan.department.repository.DepartmentRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("Inside saveDepartment method of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findDepartmentByID(Long departmentId){
		log.info("Inside saveDepartment method of DepartmentController");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
