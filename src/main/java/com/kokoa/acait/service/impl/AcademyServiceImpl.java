package com.kokoa.acait.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kokoa.acait.mapper.AcademyMapper;
import com.kokoa.acait.service.AcademyService;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CityVO;
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

  //지역 대분류 조회
  @Override
  public List<CityVO> selectCityCode() throws RuntimeException {
    return academyMapper.selectCityCode();
  }

  //지역 중분류 조회 
  @Override
  public List<BoardVO> selectListCityDtl(CityVO vo) throws RuntimeException {
    return academyMapper.selectListCityDtl(vo);
  }
  
  //학원 목록 조회
  @Override
  public List<HashMap<String, String>> selectListAcademy(CityVO vo) throws RuntimeException {
    return academyMapper.selectListAcademy(vo);
  }

}
