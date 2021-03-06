package com.ohjic.test_ohjic.controller.board;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.model.User;
import com.ohjic.test_ohjic.page.Paging;
import com.ohjic.test_ohjic.search.BoardSearch;
import com.ohjic.test_ohjic.search.type.EBoardType;
import com.ohjic.test_ohjic.search.type.SBoardSearchType;
import com.ohjic.test_ohjic.search.type.SBoardSizeType;
import com.ohjic.test_ohjic.service.BoardService;

@Controller
@SessionAttributes("user")
public class NoticeController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(value = "/board_notice_list", method = RequestMethod.GET)
	public ModelAndView boardList(
			@ModelAttribute BoardSearch boardSearch,
			@ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView("board/notice/list");
		
		boardSearch.setType(EBoardType.NOTICE);
		
		Paging<Board> boardPaging = boardService.getBoardList(boardSearch);
		
		mav.addObject("searchTypeList", Arrays.asList(SBoardSearchType.values()));
		mav.addObject("boardSizeTypeList", Arrays.asList(SBoardSizeType.values()));
		mav.addObject("paging", boardPaging);
		mav.addObject("searchType", boardSearch.getSearchType().getName());
		mav.addObject("boardSize", Integer.toString(boardSearch.getBoardSize()));
		mav.addObject("keyword", boardSearch.getKeyword());
		mav.addObject("startDate", boardSearch.getStartDate());
		mav.addObject("endDate", boardSearch.getEndDate());
		
		return mav;
	}
	
	
	@RequestMapping(value = "/board_notice_get", method = RequestMethod.GET)
	public ModelAndView boardSelectOne(
			@ModelAttribute Board board,
			@ModelAttribute BoardSearch boardSearch,
			@ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView("board/notice/get");
		
		board.setType(EBoardType.NOTICE);
		
		board = boardService.getBoard(board);
		
		mav.addObject("board", board);
		mav.addObject("boardSearch", boardSearch);
		
		return mav;
	}
	
	
	@RequestMapping(value = "/board_notice_regist", method = RequestMethod.GET)
	public ModelAndView boardRegist(
			@ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView("board/notice/regist");
		
		return mav;
	}
	
}
