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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.service.BoardService;
import com.kokoa.acait.service.CommentService;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CommentVO;
import com.kokoa.acait.vo.CriteriaVO;
import com.kokoa.acait.vo.PageMakerVO;

@Controller
public class BoardController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService boardService;
  private CommentService commentService;
  
//@Autowired
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
  
  
  /*  */
  @RequestMapping(value = "/board", method = RequestMethod.POST)
  public String post(ModelAndView model, BoardVO vo)  {
	  try {
		boardService.write(vo);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	
		return "redirect:/board";
	}

	

  
	//게시물 작성1
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public ModelAndView getWirte(ModelAndView model, BoardVO vo) throws Exception {
		boardService.write(vo);
	//return "redirect:/board";
		model.setViewName("board/write");
		return model;
	}
	
	//게시물 작성2
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(BoardVO vo,  RedirectAttributes rttr) throws Exception {
		boardService.write(vo);
		rttr.addFlashAttribute("result", "enrol success");
		return "redirect:/board";
	}
		
	// 게시물 상세
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView getView(ModelAndView model, @RequestParam("boardNo") int boardNo) throws Exception {
		//List<CommentVO> commentList = null;
		model.setViewName("board/view");
		
		// 댓글 조회
//		List<CommentVO> comment = null;
		//commentList = commentService.list(boardNo);
//		model.addObject("comment", comment);
		
		BoardVO vo = boardService.view(boardNo);
		model.addObject("view", vo);
		return model;
	}
	
	// 게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView getModify(@RequestParam("boardNo") int boardNo, ModelAndView model) throws Exception {
		model.setViewName("board/modify");
		BoardVO vo = boardService.view(boardNo);
	   
		model.addObject("view", vo);
		return model;
	}
	
	//게시물 수정2
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String postModify(BoardVO vo,  RedirectAttributes rttr) throws Exception {
			boardService.modify(vo);
			rttr.addFlashAttribute("result", "enrol success");
			return "redirect:/view?boardNo=" + vo.getBoardNo();
		}
		
	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("boardNo") int boardNo) throws Exception {
	  
		boardService.delete(boardNo);  

	 return "redirect:/board";
	}

//	
//	/* 게시판 등록 */
//    @RequestMapping(value = "/write", method = RequestMethod.POST)
//    public void boardWritePOST(BoardVO vo) {
//        
//        LOGGER.info("BoardVO : " + vo);
//        
//    }

    
  
//  /* 게시물 등록 */
//  @RequestMapping(value = "/write", method = RequestMethod.GET)
//  public String posttWirte(BoardVO vo) throws Exception {
//	  //model.setViewName("board/write");
//	  //LOGGER.info("BoardVO : " + vo);
//	  boardService.write(vo);
//	  return "redirect:/board/board";
//  }
//  

  
//  /* 게시판 등록 */
//  @RequestMapping("/write")
//  public void boardWritePOST(BoardVO vo) {
//      
//      LOGGER.info("BoardVO : " + vo);
//      
//  }


//@RequestMapping(value = "/board", method = RequestMethod.GET)
//public ModelAndView academyDetail(@PathVariable("acadCd") String acadCd, ModelAndView mav) {
//    AcademyVO acadVO = academyService.selectAcadDetail(acadCd);
//    List<AcademyVO> trainVO = academyService.selectTrainDetail(acadCd);
//    
//    mav.setViewName("academy/academyDetail");
//    mav.addObject("acadVO",acadVO); 
//    mav.addObject("trainVO",trainVO);  
//    return mav;
//}


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
