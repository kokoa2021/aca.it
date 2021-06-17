package com.kokoa.acait.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;


public interface BoardMapper {

  public List<BoardVO> list() throws Exception;
  // public List<BoardVO> selectBoardList();

  public void write(BoardVO vo) throws Exception;
  // public int insertBoard(BoardVO params);

  public BoardVO view(int BoardNo) throws Exception;
  // public BoardVO selectBoardDetail(int BoardNo);

  public void modify(BoardVO vo) throws Exception;
  // public int updateBoard(BoardVO params);

  public void delete(int BoardNo) throws Exception;
  // public int deleteBoard(int BoardNo);

  public List<BoardVO> getListPaging(CriteriaVO cri);

  /* 게시판 총 갯수 */
  public int getTotal();

  /* 게시판 조회수 */
  public void updateBoardHit(int BOARD_NO);

	public List listPage(int displayPost, int postNum) throws Exception;
	public List<BoardVO> listPageSearch(
			   int displayPost, int postNum, String searchType, String keyword) throws Exception;
  }

  // 학원 상세 관련 악담 리스트
  public List<BoardVO> getListBoardAjax(CriteriaVO cri);

  // 학원 상세 관련 악담 게시물 총 갯수
  public int getTotalAjax(String acadCd);
}


