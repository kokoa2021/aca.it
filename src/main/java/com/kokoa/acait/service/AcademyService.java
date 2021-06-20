package com.kokoa.acait.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CityVO;
import com.kokoa.acait.vo.RateVO;

public interface AcademyService {

  AcademyVO selectAcadDetail(String acadCd) throws RuntimeException;

  List<AcademyVO> selectTrainDetail(String acadCd) throws RuntimeException;

  RateVO selectAcadRate(String acadCd) throws RuntimeException;

  //지역 대분류 코드 조회
  List<CityVO> selectCityCode() throws RuntimeException;

  //지역 중분류 코드 조회
  List<BoardVO> selectListCityDtl(CityVO vo) throws RuntimeException;

  //학원 목록 조회
  List<HashMap<String, String>> selectListAcademy(CityVO vo) throws RuntimeException;

}
