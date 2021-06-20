package com.kokoa.acait.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.CityVO;
import com.kokoa.acait.vo.RateVO;

public interface AcademyMapper {

  int createAcademy(Map<String, String> map);

  AcademyVO selectAcadDetail(String acadCd);

  List<AcademyVO> selectTrainDetail(String acadCd);

  RateVO selectAcadRate(String acadCd);

  //지역 대분류 조회
  List<CityVO> selectCityCode();

  //지역 중분류 조회
  List<BoardVO> selectListCityDtl(CityVO vo);

  //학원 목록 조회
  List<HashMap<String, String>> selectListAcademy(CityVO vo);

}
