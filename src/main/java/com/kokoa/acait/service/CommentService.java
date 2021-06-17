package com.kokoa.acait.service;
import java.util.List;

import com.kokoa.acait.vo.CommentVO;
public interface CommentService {
	
	// 댓글 조회
	public List<CommentVO> list(int boardNo) throws Exception;

	// 댓글 조회
	public void write(CommentVO vo) throws Exception;

	// 댓글 수정
	public void modify(CommentVO vo) throws Exception;

	// 댓글 삭제
	public void delete(CommentVO vo) throws Exception;
}

