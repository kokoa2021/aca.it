package com.kokoa.acait.controller;

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
import com.kokoa.acait.service.AcademyService;

@Controller
public class AcademyController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AcademyController.class);
  
  @Autowired
  private AcademyService academyService;
  
}
