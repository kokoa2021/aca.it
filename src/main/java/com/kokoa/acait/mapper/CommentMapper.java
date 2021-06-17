package com.kokoa.acait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kokoa.acait.vo.CommentVO;


public interface CommentMapper {
	
	public List<CommentVO> list() throws Exception; 
	//public List<BoardVO> selectBoardList();
	
	/* 게시물 작성 */
	public void write(CommentVO vo) throws Exception;
	//public int insertBoard(BoardVO params);
	

	public CommentVO view(int BoardNo) throws Exception;
	//public BoardVO selectBoardDetail(int BoardNo);
	
	public void modify(CommentVO vo) throws Exception;
	//public int updateBoard(BoardVO params);

	public void delete(CommentVO vo) throws Exception;
	//public int deleteBoard(int BoardNo);
	

    
	public List listPage(int displayPost, int postNum) throws Exception;
	public List<CommentVO> listPageSearch(
			   int displayPost, int postNum, String searchType, String keyword) throws Exception;
}



