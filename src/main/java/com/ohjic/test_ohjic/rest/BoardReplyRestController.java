package com.ohjic.test_ohjic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.test_ohjic.model.BoardReply;
import com.ohjic.test_ohjic.rest.common.ResponseCode;
import com.ohjic.test_ohjic.rest.common.RestResponse;
import com.ohjic.test_ohjic.search.type.EBoardType;
import com.ohjic.test_ohjic.service.BoardReplyService;

@RestController
@RequestMapping("/rest")
public class BoardReplyRestController {

	@Autowired
	private BoardReplyService boardReplyService;
	
	
	@RequestMapping(value = "/board_reply_regist", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardReplyRegist(
			@ModelAttribute BoardReply boardReply) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
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
			@ModelAttribute BoardReply boardReply) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
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