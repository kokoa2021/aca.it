package com.kokoa.acait.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CityVO;
import com.kokoa.acait.vo.CriteriaVO;
import com.kokoa.acait.vo.RateVO;

@Controller
public class AcademyController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcademyController.class);

  @Autowired
  private AcademyService academyService;

  //학원 상세 페이지
  @RequestMapping(value = "/academy/{acadCd}", method = RequestMethod.GET)
  public ModelAndView academyDetail(@PathVariable("acadCd") String acadCd, ModelAndView mav) {
    AcademyVO acadVO = academyService.selectAcadDetail(acadCd);
    List<AcademyVO> trainVO = academyService.selectTrainDetail(acadCd);
    RateVO rateVO = academyService.selectAcadRate(acadCd);

    mav.setViewName("academy/academyDetail");
    mav.addObject("acadVO", acadVO);
    mav.addObject("trainVO", trainVO);
    mav.addObject("rateVO", rateVO);
    return mav;
  }
  
  //학원 목록 페이지
  @RequestMapping(value = "/academy", method = RequestMethod.GET)
  public ModelAndView academyList(ModelAndView mav) {
    List<CityVO> cityVO = academyService.selectCityCode();

    mav.setViewName("academy/academyList");
    mav.addObject("cityVO", cityVO);
    return mav;
  } 
  
  //지역 중분류 조회
  @RequestMapping(value = "/cityDtl", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> cityDtl(CityVO vo) {
    List<BoardVO> list = null;
    HashMap<String, Object> map = new HashMap<>();

    try {
      list = academyService.selectListCityDtl(vo);
    } catch (Exception e) {
      e.printStackTrace();
    }

    map.put("result", list);

    return map;
  }

  //학원 목록 조회
  @RequestMapping(value = "/academyAjax", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> academyAjax(CityVO vo) {
    List<HashMap<String,String>> list = null;
    HashMap<String, Object> map = new HashMap<>();

    try {
      list = academyService.selectListAcademy(vo);
    } catch (Exception e) {
      e.printStackTrace();
    }

    map.put("result", list);

    return map;
  }
  
  //학원 간단 상세 조회
  @RequestMapping(value = "/academyDtlAjax", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> academyDtlAjax(String acadCd) {
    HashMap<String, Object> map = new HashMap<>();
    List<AcademyVO> trainVO = null;
    RateVO rateVO = null;
    
    try {
    	trainVO = academyService.selectTrainDetail(acadCd);
        rateVO = academyService.selectAcadRate(acadCd);        
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    map.put("trainVO", trainVO);
    map.put("rateVO", rateVO);

    return map;
  }  

}
