package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	
	public void insert(User user);
    
    public User getById(Integer id);
    
    public void update(User user);
    
    public void deleteById(Integer id);
}
