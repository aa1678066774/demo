package com.example.demo.dao;

import com.example.demo.model.User;

public interface UserMapper {
	
	public void insert(User user);
    
    public User getById(Integer id);
    
    public void update(User user);
    
    public void deleteById(Integer id);
}
