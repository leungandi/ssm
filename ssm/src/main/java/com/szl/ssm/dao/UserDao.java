package com.szl.ssm.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface UserDao {
	public Map<String, Object> queryUserById(Long id);

}
