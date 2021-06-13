package com.kokoa.acait.service.impl;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kokoa.acait.mapper.CommentMapper;
import com.kokoa.acait.service.CommentService;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CommentVO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper CommentMapper;

	@Override
	public List<CommentVO> list(int boardNo) throws Exception {
		return CommentMapper.list();
	}
	

	@Override
	public void write(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		CommentMapper.write(vo);
	}

	@Override
	public void modify(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		CommentMapper.modify(vo);
	}

	@Override
	public void delete(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		CommentMapper.delete(vo);
	}

}