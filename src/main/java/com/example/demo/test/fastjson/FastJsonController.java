package com.example.demo.test.fastjson;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Department;
import com.example.demo.model.User;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "FastJson测试", tags = { "测试接口" })
@Controller
@RequestMapping("fastjson")
public class FastJsonController {
	@Resource
	private UserService userServiceImpl;
	
	@Resource
	private DepartmentService departmentServiceImpl;
	
	@ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "path")
 	@RequestMapping(value="/test/{name}",method=RequestMethod.GET)
    @ResponseBody
    public User test(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        user.setPassword("123456");
        
        Department department=new Department();
        
        department.setName(name+"部门");
        department.setDescr("沙拉嘿呦");
        
        userServiceImpl.insertUserAndDepartment(user,department);
        
//        userServiceImpl.insertUser(user);
//        departmentServiceImpl.insertDepartment(department);
        
        return user;
    }
}
