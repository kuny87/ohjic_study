package com.ohjic.test_ohjic.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.ohjic.test_ohjic.exception.IdDuplicatedException;
import com.ohjic.test_ohjic.exception.IdNoMatchException;
import com.ohjic.test_ohjic.exception.PasswordNoMatchException;
import com.ohjic.test_ohjic.model.User;

public interface UserService {

	boolean registUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException, IdDuplicatedException;
	
	boolean modifyUser(User user);
	
	boolean removeUser(User user);

	User getUser(User user);

	void getUserCheck(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException, IdNoMatchException, PasswordNoMatchException;
}
