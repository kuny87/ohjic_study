package com.ohjic.test_ohjic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.service.BoardService;

@Controller
public class HomeController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("board/board_list");
		
		List<Board> boardList = boardService.getBoardList();
		
		mav.addObject("list", boardList);
		
		return mav;
	}

}
