package com.ohjic.test_ohjic.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ohjic.test_ohjic.model.Board;

@Repository
public interface BoardMapper {

	int insertBoard(Board board);
	
	int updateBoard(Board board);
	
	int deleteBoard(Board board);
	
	List<Board> selectBoardList();
	
	Board selectBoard(Board board);
	
}
