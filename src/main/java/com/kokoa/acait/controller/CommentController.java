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
import com.kokoa.acait.service.CommentService;
import com.kokoa.acait.vo.CommentVO;

@Controller
public class CommentController {
  private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);
  
  @Autowired
  private CommentService commentService;
  
}