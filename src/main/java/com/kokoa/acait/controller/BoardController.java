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
import org.springframework.web.bind.annotation.RequestParam;
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
		model.setViewName("board/view");
		BoardVO vo = boardService.view(boardNo);
		model.addObject("view", vo);
		return model;
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
 

}

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





//
//package com.kokoa.acait.controller;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.kokoa.acait.service.BoardService;
//@Controller
////@RequestMapping("//*")
//public class BoardController {
//
//@Autowired
//private BoardService service;
// 
//	 // 게시물 목록
//	 @RequestMapping(value = "/list", method = RequestMethod.GET)
//	 public void getList(Model model) throws Exception {
//	  
//	  List list = null;
//	  model.addAttribute("list", list);
//	 }
//}
	


//package com.kokoa.acait.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.kokoa.acait.service.BoardService;
//
//@Controller
//public class BoardController {
//
//	@Autowired
//	private BoardService boardService;
//
//	@GetMapping(value = "/board/write.do")
//	public String openBoardWrite(Model model) {
//		return "board/write";
//	}
//
//}