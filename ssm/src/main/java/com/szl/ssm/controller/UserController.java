package com.szl.ssm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sz.ssm.base.BaseController;
import com.szl.ssm.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping("queryUserById")
	public String queryUserById(){
		Long id = 5L;
		Map<String, Object> map = userService.queryUserById(id);
		return "hello";
	}
}
