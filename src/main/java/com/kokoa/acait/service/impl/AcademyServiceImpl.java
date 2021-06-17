package com.kokoa.acait.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kokoa.acait.mapper.AcademyMapper;
import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.RateVO;

@Service
public class AcademyServiceImpl implements AcademyService {
  @Autowired
  private AcademyMapper academyMapper;

  @Override
  public AcademyVO selectAcadDetail(String acadCd) throws RuntimeException {
    return academyMapper.selectAcadDetail(acadCd);
  }

  @Override
  public List<AcademyVO> selectTrainDetail(String acadCd) throws RuntimeException {
    return academyMapper.selectTrainDetail(acadCd);
  }

  @Override
  public RateVO selectAcadRate(String acadCd) throws RuntimeException {
    return academyMapper.selectAcadRate(acadCd);
  }


}
