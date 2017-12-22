package com.ohjic.test_ohjic.mapper;

import org.springframework.stereotype.Repository;

import com.ohjic.test_ohjic.model.User;


@Repository
public interface UserMapper {

	int insertUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(User user);
	
	User selectUser(User user);
	
}
