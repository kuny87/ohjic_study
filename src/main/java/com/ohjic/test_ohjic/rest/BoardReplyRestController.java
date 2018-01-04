package com.ohjic.test_ohjic.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.test_ohjic.model.BoardReply;
import com.ohjic.test_ohjic.rest.common.ResponseCode;
import com.ohjic.test_ohjic.rest.common.RestResponse;
import com.ohjic.test_ohjic.service.BoardReplyService;
import com.ohjic.test_ohjic.validator.BoardReplyValidator;

@RestController
@RequestMapping("/rest")
public class BoardReplyRestController {

	@Autowired
	private BoardReplyService boardReplyService;
	
	@Autowired
	BoardReplyValidator boardReplyValidator;
	
	@InitBinder("boardReply")
	public void initRegEquipBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(boardReplyValidator);
	}
	
	@RequestMapping(value = "/board_reply_regist", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardReplyRegist(
			@ModelAttribute("boardReply") @Valid BoardReply boardReply,
			BindingResult boardReplyBindingResult) {

		RestResponse response = boardReplyValidator.bindingError(boardReplyBindingResult);
		
		if(response.isSuccess() == false) {
			return response;
		}
		
		try {
			boardReplyService.registBoardReply(boardReply);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/board_reply_modify", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardReplyModify(
			@ModelAttribute("boardReply") @Valid BoardReply boardReply,
			BindingResult boardReplyBindingResult) {

		RestResponse response = boardReplyValidator.bindingError(boardReplyBindingResult);
		
		if(response.isSuccess() == false) {
			return response;
		}
		
		try {
			boardReplyService.modifyBoardReply(boardReply);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/board_reply_remove", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardReplyRemove(
			@ModelAttribute BoardReply boardReply) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			boardReplyService.removeBoardReply(boardReply);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
}