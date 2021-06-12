package com.kokoa.acait.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.service.BoardService;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;
import com.kokoa.acait.vo.PageMakerVO;

@Controller
public class BoardController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
  
  @Autowired
  private BoardService boardService;
  
//  @RequestMapping(value = "/board", method = RequestMethod.GET)
//  public ModelAndView getList(ModelAndView model)  {
//	  List<BoardVO> list = null;
//	  
//	  try {
//		list = boardService.list();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	model.setViewName("board/board");
//	model.addObject("boardlist", list);
//	
//	return model;
//  }
  
  /* 게시판 목록 페이지 접속(페이징 적용) */
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView getList(ModelAndView model, CriteriaVO cri)  {
	  List<BoardVO> list = null;
	  
	  try {
		list = boardService.getListPaging(cri);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  int total = boardService.getTotal();
	  PageMakerVO pageMake = new PageMakerVO(cri, total);
	
	  model.setViewName("board/board");
	  model.addObject("pageMaker", pageMake);
	  model.addObject("boardlist", list);
	
	return model;
  }
  
	//게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView getWirte(ModelAndView model, BoardVO vo) throws Exception {
		boardService.write(vo);
	//return "redirect:/board";
		model.setViewName("board/write");
		return model;
	}
	
	//게시물 작성
		@RequestMapping(value = "/write", method = RequestMethod.POST)
		public String postWirte(BoardVO vo,  RedirectAttributes rttr) throws Exception {
			boardService.write(vo);
			rttr.addFlashAttribute("result", "enrol success");
			return "redirect:/board";
	}