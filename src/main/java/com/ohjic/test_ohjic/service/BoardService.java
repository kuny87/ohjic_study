package com.ohjic.test_ohjic.service;

import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.page.Paging;
import com.ohjic.test_ohjic.search.BoardSearch;

public interface BoardService {

	// 게시판
	boolean registBoard(Board board);
	
	boolean modifyBoard(Board board);
	
	boolean removeBoard(Board board);

	Paging<Board> getBoardList(BoardSearch boardSearch);
	
	Board getBoard(Board board);
	
}
