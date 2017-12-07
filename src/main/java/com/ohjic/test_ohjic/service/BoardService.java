package com.ohjic.test_ohjic.service;

import java.util.List;

import com.ohjic.test_ohjic.model.Board;

public interface BoardService {

	boolean registBoard(Board board);
	
	boolean modifyBoard(Board board);
	
	boolean removeBoard(Board board);

	List<Board> getBoardList();
	
	Board getBoard(Board board);
	
}
