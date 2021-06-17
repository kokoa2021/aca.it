package com.kokoa.acait.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CriteriaVO;
import com.kokoa.acait.vo.RateVO;

@Controller
public class AcademyController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcademyController.class);
  
  @Autowired
  private AcademyService academyService;
  
  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/academy/{acadCd}", method = RequestMethod.GET)
  public ModelAndView academyDetail(@PathVariable("acadCd") String acadCd, ModelAndView mav) {
      AcademyVO acadVO = academyService.selectAcadDetail(acadCd);
      List<AcademyVO> trainVO = academyService.selectTrainDetail(acadCd);
      RateVO rateVO = academyService.selectAcadRate(acadCd);
      
      mav.setViewName("academy/academyDetail");
      mav.addObject("acadVO",acadVO); 
      mav.addObject("trainVO",trainVO);
      mav.addObject("rateVO", rateVO);
      return mav;
  }
  
}
