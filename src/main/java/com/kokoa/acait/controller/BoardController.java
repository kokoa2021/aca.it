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

import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.service.BoardService;
import com.kokoa.acait.vo.BoardVO;

@Controller
public class BoardController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
  
  @Autowired
  private BoardService boardService;
  
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView getList(ModelAndView model)  {
	  List<BoardVO> list = null;
	  
	  try {
		list = boardService.list();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	model.setViewName("board/board");
	model.addObject("boardlist", list);
	
	return model;
  }
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