package com.ohjic.test_ohjic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.test_ohjic.mapper.BoardMapper;
import com.ohjic.test_ohjic.model.Board;
import com.ohjic.test_ohjic.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public boolean registBoard(Board board) {
		return false;
	}

	@Override
	public boolean modifyBoard(Board board) {
		return false;
	}

	@Override
	public boolean removeBoard(Board board) {
		return false;
	}

	@Override
	public List<Board> getBoardList() {
		return boardMapper.selectBoardList();
	}

}
