package com.ohjic.test_ohjic.service;

import com.ohjic.test_ohjic.model.BoardReply;

public interface BoardReplyService {

	boolean registBoardReply(BoardReply boardReply);
	
	boolean modifyBoardReply(BoardReply boardReply);
	
	boolean removeBoardReply(BoardReply boardReply);

//	Paging<Board> getBoardList(BoardSearch boardSearch);
//	
//	Board getBoard(Board board);
	
}
