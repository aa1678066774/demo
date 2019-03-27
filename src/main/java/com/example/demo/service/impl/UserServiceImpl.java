package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DepartmentMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.Department;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserMapper userMapper;
	
	@Autowired
    private DepartmentMapper departmentMapper;

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	@Override
	@Transactional(timeout=-1,rollbackForClassName= {"ArithmeticException"},propagation=Propagation.REQUIRED,isolation=Isolation.REPEATABLE_READ)
	public void insertUserAndDepartment(User user, Department department) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
		departmentMapper.insert(department);
	}
		
	
}
