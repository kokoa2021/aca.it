<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <div class="main-wrapper">
    <div class="main-title-container">
      <span class="main-title">국비지원 IT학원, </span>
      <span class="main-title">알아보고 가자!</span>
    </div>
    <div class="main-search-box-container">
      <div class="search-box-wrapper">
        <div class="search-box-search-btn">
          <img src="../../../resources/images/search_y.png" alt="searh"/>
        </div>
        <div class="search-box-query-box">
          <input type="text" class="search-query" placeholder="학원을 검색해보세요">
        </div>
        <div class="search-box-cancel-btn">
          <img src="../../../resources/images/close_y.png" alt="cancel"/>
        </div>
      </div>
    </div>
    <div class="main-recent-wrapper">
      <div class="recent-academy">
        <div class="d-recent-academy-wrapper d-recent-academy">
          <div class="list-header">
            <span>실시간 검색 기업</span>
            <span class="reload-btn">
              <img src="../../../resources/images/refresh_b.png"  width="20px" height="20px" align="bottom" "searh"/>
            </span>
          </div>
          <div class="row" style="height: 220px; overflow-y: scroll;">
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>엔디에스</span>
                </div>
              </a>
            </div>
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>미소정보기술</span>
                </div>
              </a>
            </div>
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>에스케이씨솔믹스</span>
                </div>
              </a>
            </div>
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>웹젠</span>
                </div>
              </a>
            </div>
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>언더독스</span>
                </div>
              </a>
            </div>
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>피벗크리에이티브</span>
                </div>
              </a>
            </div>
            <div class="col-md-12">
              <a href="/">
                <div class="list-item">
                  <span>티르티르</span>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="recent-acadam">
        <div class="d-recent-acadam-wrapper d-recent-acadam">
          <div class="list-header">
            <span>최신 댓글 기업</span>
            <span class="total">총 27762 건</span>
          </div>
          <div class="row">
            <div>
              <div class="infinite-scroll-component" style="height: 220px; overflow: auto;">
                <div class="col-md-12">
                  <a href="/">
                    <div class="list-item">
                      <span class="list-item-a">퇴사자 210명 돌파</span>
                      <span class="list-item-b">인라이플</span>
                    </div>
                  </a>
                </div>
                <div class="col-md-12">
                  <a href="/">
                    <div class="list-item">
                      <span class="list-item-a">요기도</span>
                      <span class="list-item-b">그립랩스</span>
                    </div>
                  </a>
                </div>
                <div class="col-md-12">
                  <a href="/">
                    <div class="list-item">
                      <span class="list-item-a">여기뭐지</span>
                      <span class="list-item-b">스티브리자바</span>
                    </div>
                  </a>
                </div>
                <div class="col-md-12">
                  <a href="/">
                    <div class="list-item">
                      <span class="list-item-a">직원한테 돈을 너무 아끼는 회사같음.</span
                        ><span class="list-item-b">크리에이티브소프트</span>
                    </div>
                  </a>
                </div>
                <div class="col-md-12">
                  <a href="/">
                    <div class="list-item">
                      <span class="list-item-a">마지막에 들어온 아줌마 면접관맞아요?</span>
                      <span class="list-item-b">마크로밀엠브레인</span>
                    </div>
                  </a>
                </div>
                <div class="col-md-12">
                  <a href="/">
                    <div class="list-item">
                      <span class="list-item-a">여기 연봉 뭐야?</span>
                      <span class="list-item-b">경기평택항만공사</span>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>    
   </div>
</body>
</html>
