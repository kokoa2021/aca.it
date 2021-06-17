package com.kokoa.acait.service;

import java.util.List;
import com.kokoa.acait.vo.AcademyVO;
import com.kokoa.acait.vo.BoardVO;
import com.kokoa.acait.vo.RateVO;

public interface AcademyService {

  AcademyVO selectAcadDetail(String acadCd) throws RuntimeException;

  List<AcademyVO> selectTrainDetail(String acadCd) throws RuntimeException;

  RateVO selectAcadRate(String acadCd) throws RuntimeException;

}
