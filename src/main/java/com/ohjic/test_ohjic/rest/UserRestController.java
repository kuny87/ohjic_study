package com.ohjic.test_ohjic.rest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.test_ohjic.exception.IdDuplicatedException;
import com.ohjic.test_ohjic.exception.IdNoMatchException;
import com.ohjic.test_ohjic.exception.PasswordNoMatchException;
import com.ohjic.test_ohjic.model.User;
import com.ohjic.test_ohjic.rest.common.ResponseCode;
import com.ohjic.test_ohjic.rest.common.RestResponse;
import com.ohjic.test_ohjic.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user_regist", method = RequestMethod.GET, produces = "application/json")
	public RestResponse userRegist(
			@ModelAttribute User user
			) throws UnsupportedEncodingException, NoSuchAlgorithmException, IdDuplicatedException {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			userService.registUser(user);
		} catch (IdDuplicatedException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.ID_DUPLICATED);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/user_pwCheck", method = RequestMethod.GET, produces = "application/json")
	public RestResponse userPwCheck(
			@ModelAttribute User user) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			userService.getUserCheck(user);
		} catch (IdNoMatchException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.ID_NO_MATCH);
		} catch (PasswordNoMatchException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.PASSWORD_NO_MATCH);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/user_modify", method = RequestMethod.GET, produces = "application/json")
	public RestResponse userModify(
			@ModelAttribute User user) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			userService.modifyUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/user_remove", method = RequestMethod.GET, produces = "application/json")
	public RestResponse userRemove(
			@ModelAttribute User user) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			userService.removeUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/user_login", method = RequestMethod.GET, produces = "application/json")
	public RestResponse userLogin(
			@ModelAttribute User user,
			HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException, IdNoMatchException, PasswordNoMatchException {
		
		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			userService.getUserCheck(user);
			user = userService.getUser(user);
		} catch (IdNoMatchException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.ID_NO_MATCH);
		} catch (PasswordNoMatchException e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.PASSWORD_NO_MATCH);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		return response;
	}
	
	
}