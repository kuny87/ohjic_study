package com.ohjic.test_ohjic.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.rest.common.ResponseCode;
import com.ohjic.test_ohjic.rest.common.RestResponse;
import com.ohjic.test_ohjic.service.BoardService;

@RestController
@RequestMapping("/rest")
public class BoardRestController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value = "/board_regist", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardRegist(
			@ModelAttribute Board board) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			boardService.registBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/board_modify", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardModify(
			@ModelAttribute Board board) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			boardService.modifyBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/board_remove", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardRemove(
			@ModelAttribute Board board) {

		RestResponse response = new RestResponse();
		response.setSuccess(true);
		
		try {
			boardService.removeBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
			response.setResCode(ResponseCode.UNKOWN);
		}
		
		return response;
	}
	
}