package com.ohjic.test_ohjic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	public ModelAndView boardList(
			@ModelAttribute Board board) {
		
		ModelAndView mav = new ModelAndView("board/list");
		
		List<Board> boardList = boardService.getBoardList();
		
		mav.addObject("list", boardList);
		
		return mav;
	}
	
	
	@RequestMapping(value = "/board_get", method = RequestMethod.GET)
	public ModelAndView boardSelectOne(
			@ModelAttribute Board board) {
		
		ModelAndView mav = new ModelAndView("board/get");
		
		board = boardService.getBoard(board);
		
		mav.addObject("board", board);
		
		return mav;
	}
	
	
	@RequestMapping(value = "/board_regist", method = RequestMethod.GET)
	public ModelAndView boardRegist() {
		
		ModelAndView mav = new ModelAndView("board/regist");
		
		return mav;
	}
	
}
