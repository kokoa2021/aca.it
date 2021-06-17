package com.kokoa.acait.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.kokoa.acait.service.BoardService;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;
import com.kokoa.acait.vo.PageMakerVO;

@Controller
public class BoardController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService boardService;

  /* 게시판 목록 페이지 접속(페이징 적용) */
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView getList(ModelAndView model, CriteriaVO cri) {
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

  //학원 상세 관련 악담 리스트
  @RequestMapping(value = "/boardAjax", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> boardAjax(CriteriaVO cri) {
    List<BoardVO> list = null;
    HashMap<String, Object> map = new HashMap<>();
    int total = 0;

    try {
      list = boardService.getListBoardAjax(cri);
      total = boardService.getTotalAjax(cri.getAcadCd());
    } catch (Exception e) {
      e.printStackTrace();
    }

    map.put("result", list);
    map.put("total", total);

    return map;
  }



}
