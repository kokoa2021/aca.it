package com.kokoa.acait.service;
import java.util.List;

import com.kokoa.acait.vo.BoardVO;
public interface BoardService {
	
	// 게시물 목록
	public List<BoardVO> list() throws Exception; 

}

