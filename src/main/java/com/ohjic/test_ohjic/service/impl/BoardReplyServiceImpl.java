package com.ohjic.test_ohjic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohjic.test_ohjic.mapper.BoardReplyMapper;
import com.ohjic.test_ohjic.model.BoardReply;
import com.ohjic.test_ohjic.service.BoardReplyService;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

	@Autowired
	private BoardReplyMapper boardReplyMapper;

	@Override
	public boolean registBoardReply(BoardReply boardReply) {
		
		boolean result = false;
		
		if(boardReply.getReparent() == null) {
			boardReply.setReorder(boardReplyMapper.selectReplyReorder(boardReply));
			result = boardReplyMapper.insertBoardReply(boardReply) == 1;
			boardReply = boardReplyMapper.selectMaxReply();
			result = boardReplyMapper.updateGroupSeq(boardReply) == 1;
		}else {
			boardReply.setGroupSeq(boardReplyMapper.selectReparentGroupSeq(boardReply).getGroupSeq());
			boardReply.setBoardReplySeq(boardReplyMapper.selectReparentGroupSeq(boardReply).getBoardReplySeq());
			int reorder = boardReplyMapper.selectGroupDepthCheck(boardReply);
			if(boardReply.getRedepth() == null || reorder == 0){
				boardReply.setReorder(boardReplyMapper.selectReReplyReorder(boardReply));
			}else {
				boardReply.setReorder(boardReplyMapper.selectGroupDepthCheck(boardReply));
			}
			result = boardReplyMapper.insertBoardReReply(boardReply) == 1;
			if(result){
				boardReply = boardReplyMapper.selectMaxReply();
				result = boardReplyMapper.updateReplyReorderAdd(boardReply) == 1;
				// 최건희 - update문을 셀렉트문과 업데이트문으로 쪼개기
				boardReply.setGroupSeq(boardReplyMapper.selectReparentGroupSeq(boardReply).getGroupSeq());
				result = boardReplyMapper.updateGroupSeqChilde(boardReply) == 1;
			}
		}
		return result;
	}

	@Override
	public boolean modifyBoardReply(BoardReply boardReply) {
		return boardReplyMapper.updateBoardReply(boardReply) == 1;
	}

	@Override
	public boolean removeBoardReply(BoardReply boardReply) {
		return boardReplyMapper.deleteBoardReply(boardReply) == 1;
	}

}
