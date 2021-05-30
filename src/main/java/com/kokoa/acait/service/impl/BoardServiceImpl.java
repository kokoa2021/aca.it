package com.kokoa.acait.service.impl;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kokoa.acait.mapper.BoardMapper;
import com.kokoa.acait.service.BoardService;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper BoardMapper;
	
	 
	 /* 게시물 목록 */
	 @Override
	 public List<BoardVO> list() throws Exception {
	
	  return BoardMapper.list();
	 }
	 
	 /* 게시판 목록(페이징 적용) */
	 @Override
	 public List<BoardVO> getListPaging(CriteriaVO cri) throws Exception {
	        
	   return BoardMapper.getListPaging(cri);
	 }
	 
	 /* 게시물 총 개수 */
	 @Override
	 public int getTotal() {
		return BoardMapper.getTotal();
	}  
	
}


//package com.kokoa.acait.service;
//
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.kokoa.acait.domain.BoardDTO;
//import com.kokoa.acait.mapper.BoardMapper;
//
//@Service
//public class BoardServiceImpl implements BoardService {
//
//	@Autowired
//	private BoardMapper boardMapper;
//
//	@Override
//	public boolean registerBoard(BoardDTO params) {
//		int queryResult = 0;
//
//		if (params.getBOARD_NO() == 0) {
//			queryResult = boardMapper.insertBoard(params);
//		} else {
//			queryResult = boardMapper.updateBoard(params);
//		}
//
//		return (queryResult == 1) ? true : false;
//	}
//
//	@Override
//	public BoardDTO getBoardDetail(int BOARD_NO) {
//		return boardMapper.selectBoardDetail(BOARD_NO);
//	}
//
//	@Override
//	public boolean deleteBoard(int BOARD_NO) {
//		int queryResult = 0;
//
//		BoardDTO board = boardMapper.selectBoardDetail(BOARD_NO);
//
//		if (board != null && "N".equals(board.getDEL_YN())) {
//			queryResult = boardMapper.deleteBoard(BOARD_NO);
//		}
//
//		return (queryResult == 1) ? true : false;
//	}
//
//	@Override
//	public List<BoardDTO> getBoardList() {
//		List<BoardDTO> boardList = Collections.emptyList();
//
//		int boardTotalCount = boardMapper.selectBoardTotalCount();
//
//		if (boardTotalCount > 0) {
//			boardList = boardMapper.selectBoardList();
//		}
//
//		return boardList;
//	}
//
//}