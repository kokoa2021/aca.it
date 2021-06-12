package com.kokoa.acait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;


public interface BoardMapper {
	
	public List<BoardVO> list() throws Exception; 
	//public List<BoardVO> selectBoardList();
	
	public void write(BoardVO vo) throws Exception;
	//public int insertBoard(BoardVO params);

	public BoardVO view(int BoardNo) throws Exception;
	//public BoardVO selectBoardDetail(int BoardNo);
	
	public void modify(BoardVO vo) throws Exception;
	//public int updateBoard(BoardVO params);

	public void delete(int BoardNo) throws Exception;
	//public int deleteBoard(int BoardNo);
	
	public List<BoardVO> getListPaging(CriteriaVO cri);
	
	/* 게시판 총 갯수 */
    public int getTotal();
    
	public List listPage(int displayPost, int postNum) throws Exception;
	public List<BoardVO> listPageSearch(
			   int displayPost, int postNum, String searchType, String keyword) throws Exception;
}


