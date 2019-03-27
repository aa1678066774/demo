package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.DepartmentMapper;
import com.example.demo.model.Department;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentTest {
	@Autowired
    private DepartmentMapper departmentMapper;
    
    @Test
    public void testInsert() {
        Department department = new Department();
        department.setId(8);
        department.setName("研发部");
        department.setDescr("开发产品");
        this.departmentMapper.insert(department);
    }
    
    
}
