package com.kokoa.acait.service;
import java.util.List;

import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;
public interface BoardService {
	
	// 게시물 목록
	public List<BoardVO> list() throws Exception; 
	
	// 게시물 총 갯수 
    public int getTotal();

	public List<BoardVO> getListPaging(CriteriaVO cri) throws Exception;
}

