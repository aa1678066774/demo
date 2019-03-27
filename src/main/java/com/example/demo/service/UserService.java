package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.User;

public interface UserService {

	void insertUser(User user);

	void insertUserAndDepartment(User user, Department department);

}
