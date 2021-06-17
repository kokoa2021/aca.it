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
	 public List<BoardVO> list(int BoardNo) throws Exception {
		 BoardMapper.updateBoardHit(BoardNo);
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
	 
	 /* 게시물 조회수 */
	 @Override
	 public void updateBoardHit(int BoardNo) {
		 BoardMapper.updateBoardHit(BoardNo);
	}

	 /* 게시물 등록 */
	@Override
	public void write(BoardVO vo) {
		try {
			BoardMapper.write(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 게시물 조회
	@Override
	public BoardVO view(int BoardNo) throws Exception {

	 return BoardMapper.view(BoardNo);
	}
	
	// 게시물 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		BoardMapper.modify(vo);
	}
	
	// 게시물 삭제
	public void delete(int BoardNo) throws Exception {
		BoardMapper.delete(BoardNo);
	}

  // 학원 상세 관련 악담 리스트
  @Override
  public List<BoardVO> getListBoardAjax(CriteriaVO cri) throws RuntimeException {
    return BoardMapper.getListBoardAjax(cri);
  }

  // 학원 상세 관련 악담 게시물 총 갯수
  @Override
  public int getTotalAjax(String acadCd) throws RuntimeException {
    return BoardMapper.getTotalAjax(acadCd);
  }

}

