package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DepartmentMapper;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
//	@Autowired
//    private UserMapper userMapper;
	
	@Autowired
    private DepartmentMapper departmentMapper;

	@Override
	public void insertDepartment(Department department) {
		// TODO Auto-generated method stub
		departmentMapper.insert(department);
	}
}
