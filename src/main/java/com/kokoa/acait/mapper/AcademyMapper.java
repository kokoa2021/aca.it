package com.kokoa.acait.mapper;

import java.util.List;
import java.util.Map;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.RateVO;

public interface AcademyMapper {

  int createAcademy(Map<String, String> map);

  AcademyVO selectAcadDetail(String acadCd);

  List<AcademyVO> selectTrainDetail(String acadCd);

  RateVO selectAcadRate(String acadCd);

}
