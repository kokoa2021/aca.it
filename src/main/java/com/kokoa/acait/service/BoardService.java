package com.kokoa.acait.service;

import java.util.List;

import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;

public interface BoardService {
	
	// 게시물 목록
	public List<BoardVO> list(int BoardNo) throws Exception; 
	
  // 게시물 총 갯수 
  public int getTotal();

  // 게시물 조회수
  public void updateBoardHit(int BoardNo);

  // 게시물 등록
  public void write(BoardVO vo) throws Exception;

  // 게시물 상세 
  public BoardVO view(int BoardNo) throws Exception;

  // 게시물 수정
  public void modify(BoardVO vo) throws Exception;

  // 게시물 삭제
  public void delete(int BoardNo) throws Exception;
    
	public List<BoardVO> getListPaging(CriteriaVO cri) throws Exception;
  
  //학원 상세 관련 악담 리스트
  public List<BoardVO> getListBoardAjax(CriteriaVO cri) throws RuntimeException;
  
  //학원 상세 관련 악담 게시물 총 갯수
  public int getTotalAjax(String acadCd) throws RuntimeException;

}

