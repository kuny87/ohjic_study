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

import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.rest.common.ResponseCode;
import com.ohjic.test_ohjic.rest.common.RestResponse;
import com.ohjic.test_ohjic.service.BoardService;
import com.ohjic.test_ohjic.validator.BoardValidator;

@RestController
@RequestMapping("/rest")
public class BoardRestController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	BoardValidator boardValidator;
	
	@InitBinder("board")
	public void initRegEquipBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(boardValidator);
	}
	
	@RequestMapping(value = "/board_regist", method = RequestMethod.GET, produces = "application/json")
	public RestResponse boardRegist(
			@ModelAttribute("board") @Valid Board board,
			BindingResult boardBindingResult) {

		RestResponse response = boardValidator.bindingError(boardBindingResult);
		
		if(response.isSuccess() == false) {
			return response;
		}
		
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
			@ModelAttribute("board") @Valid Board board,
			BindingResult boardBindingResult) {

		RestResponse response = boardValidator.bindingError(boardBindingResult);
		
		if(response.isSuccess() == false) {
			return response;
		}
		
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