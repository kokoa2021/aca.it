package com.kokoa.acait.service;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import com.kokoa.acait.vo.BoardVO;
public interface BoardService {
	
	// 게시물 목록
	public List<BoardVO> list() throws Exception; 
	
	// 게시물 총 갯수
	public int count() throws Exception;

}

