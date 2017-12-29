//package com.ohjic.test_ohjic.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import com.ohjic.test_ohjic.model.User;
//import com.ohjic.test_ohjic.rest.common.ResponseCode;
//import com.ohjic.test_ohjic.rest.common.RestResponse;
//
//@Component
//public class UserValidator implements Validator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return User.class.isAssignableFrom(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		User user = (User) target; // validate 하고 싶은 객체를 받아와서 셋팅!
//		
//		if(user == null) {
//			errors.rejectValue("user", "1", "user 객체가 없습니다.");
//		} else if(user.getId().length() == 0) {
//			errors.rejectValue("userId", "2", "아이디를 입력해 주세요.");
//		} else if(user.getPw().length() == 0) {
//			errors.rejectValue("userPw", "3", "비밀번호를 입력해 주세요.");
//		} else if(user.getName().length() == 0) {
//			errors.rejectValue("userName", "4", "이름을 입력해 주세요.");
//		}
//		
//	}
//	
//	
//	@Autowired
//	public RestResponse bindingError(BindingResult bindingResult) {
//		RestResponse response = new RestResponse(); // 유효성 검사 후 리턴 시킬 값을 세팅하기 위함, default값으로 success에 true가 설정되어 있다.
//		
//		if (bindingResult.getFieldError() == null) { // getFreldError()이 null이면 null포인터 익셉션이 생겨서 따로 처리해줘야한다.
//			return response;
//		}
//		
//		if ("user".equals(bindingResult.getFieldError().getField())) { // Field에 세팅된 값이 "bank" 이면 다음과 같이 response를 세팅한다. 
//			response.setSuccess(false);
//			response.setResCode(ResponseCode.INVALID_INPUT_VALUE);
//		} else if ("userId".equals(bindingResult.getFieldError().getField())) {
//			response.setSuccess(false);
//			response.setResCode(ResponseCode.EMPTY_ID);
//		} else if ("userPw".equals(bindingResult.getFieldError().getField())) {
//			response.setSuccess(false);
//			response.setResCode(ResponseCode.EMPTY_PW);
//		} else if ("userName".equals(bindingResult.getFieldError().getField())) {
//			response.setSuccess(false);
//			response.setResCode(ResponseCode.EMPTY_NAME);
//		}
//		
//		return response; // 유효성 검사 메소드에서 에러가 발생했다면 위에서 response의 success에 false로 세팅되고 아무런 에러가 발생하지 않았다면 true로 세팅되었을 것이다.
//	}
//	
//}
