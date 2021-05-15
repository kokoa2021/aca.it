package com.kokoa.acait.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kokoa.acait.mapper.AcademyMapper;
import com.kokoa.acait.service.AcademyService;

@Service
public class AcademyServiceImpl implements AcademyService {
  @Autowired
  private AcademyMapper academyMapper;

}
