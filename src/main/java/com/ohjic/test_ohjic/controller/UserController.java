package com.ohjic.test_ohjic.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ohjic.test_ohjic.exception.IdNoMatchException;
import com.ohjic.test_ohjic.exception.PasswordNoMatchException;
import com.ohjic.test_ohjic.model.User;
import com.ohjic.test_ohjic.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_regist", method = RequestMethod.GET)
	public ModelAndView userRegist() {
		
		ModelAndView mav = new ModelAndView("user/regist");
		
		return mav;
	}
	
	@RequestMapping(value = "/user_login", method = RequestMethod.GET)
	public ModelAndView userLogin(
			@ModelAttribute User user,
			HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException, IdNoMatchException, PasswordNoMatchException {
		
		ModelAndView mav = new ModelAndView("user/login");
		
		user = userService.getUser(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		mav.addObject("user", user);
		
		return mav;
	}
	
	
	@RequestMapping(value = "/user_logout", method = RequestMethod.GET)
	public ModelAndView userLogout(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("index/home");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return mav;
	}
	
}
