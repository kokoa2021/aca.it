package com.kokoa.acait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kokoa.acait.vo.BoardVO;


public interface BoardMapper {
	
	public List<BoardVO> list() throws Exception; 
	//public List<BoardVO> selectBoardList();
	
	public void write(BoardVO vo) throws Exception;
	//public int insertBoard(BoardVO params);

	public BoardVO view(int BOARD_NO) throws Exception;
	//public BoardVO selectBoardDetail(int BOARD_NO);
	
	public void modify(BoardVO vo) throws Exception;
	//public int updateBoard(BoardVO params);

	public void delete(int BOARD_NO) throws Exception;
	//public int deleteBoard(int BOARD_NO);

	public int count() throws Exception;
	public List listPage(int displayPost, int postNum) throws Exception;
	public List<BoardVO> listPageSearch(
			   int displayPost, int postNum, String searchType, String keyword) throws Exception;
}



