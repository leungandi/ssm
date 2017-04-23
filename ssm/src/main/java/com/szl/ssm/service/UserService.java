package com.szl.ssm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szl.ssm.dao.UserDao;
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	public Map<String, Object> queryUserById(Long id){
		return userDao.queryUserById(id);
	}
}
