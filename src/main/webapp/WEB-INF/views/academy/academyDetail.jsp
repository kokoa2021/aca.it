<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학원 상세 페이지</title>
<script type="text/javascript">
	var loading = false;
	var page = 1;
	var maxPage = 1;
	
	$(function(){	
		acadam_load();
		
	 	$('.acadam-contents-container').scroll(function(){ 
			if($(this).scrollTop() + $(this).innerHeight()>=$(this)[0].scrollHeight-10){
				if(maxPage>=page) {
					//실행가능 상태
					if(!loading) {
						loading = true; //실행 불가능 상태로 변경
						acadam_load(); 
					} 
				}
			} 
		});
	});
	//악담 스크롤링		
	function acadam_load(){
 		$.ajax({
 			url:"/acait/boardAjax",
 			type:"GET",
 			data:{'pageNum':page,
 				  'amount' : '5',
 				  'acadCd' : $('#acadCd').val()
 				},
 			success:function(data){
 				var list = data.result;
 				var total = data.total;
				for(var i=0; i<list.length; i++){
 					var child = $(".clone").children();
 					var clone = child.clone();
 					var major = "";
 					
 					if(list[i].major == 0) major = "전공생위주"
 					else major = "비전공생위주"
 					
 					$(clone).find('.acadam-post-tag.major').html(major);
 					$(clone).find('.acadam-title').html(list[i].title);
 					$(clone).find('.academy-title').html(list[i].acadTitle);
					$(clone).find('.view-cnt').html(list[i].hit);
					$(clone).find('.date').html(list[i].regDate);
					
 					setGrade($(clone).find('.acadam-post-tag.environment'), list[i].environment);
 					setGrade($(clone).find('.acadam-post-tag.teacher'), list[i].teacher);
 					
 					$(".acadam-contents-container").append(clone);
 				}	
 				page++;
 				maxPage = total/5 + 1;
				loading=false;
 			},
 			error: function(xhr, status, error){
 				console.log(error);
			}
 		});
	}
	//평가 상,중,하 grade
	function setGrade(clone, rate){
		if(rate == 1){
			$(clone).addClass('bronze');
			$(clone).html("하");
		}
		if(rate == 3){
			$(clone).addClass('silver');
			$(clone).html("중");
		}
		if(rate == 5){
			$(clone).addClass('gold');
			$(clone).html("상");
		}		
	}
</script>
</head>
<body>
	<input type="hidden" id="acadCd" value="${acadVO.acadCd}">
	<div class="academy-container">
		<div class="academy-wrapper">
			<div class="academy-contents">
				<div class="academy-info-container">
					<div class="info-container">
						<div class="info-box left">
							<div class="academy-label">
								<div class="academy-name">${acadVO.acadTitle}</div>
								<div class="academy-addr">${acadVO.address}</div>
								<div class="academy-label-detail">
									<div class="label-detail-cell">
										<span class="cat-label">홈페이지 : </span>
										<span class="cat-text">${acadVO.url}</span>
									</div>
									<div class="label-detail-cell">
										<span class="cat-label">전화번호 : </span>
										<span class="cat-text">${acadVO.telNo}</span>
									</div>									
								</div>
							</div>
						</div>
						<div class="info-box middle">
							<div class="title">평가</div>
							<div class="academy-rate">
								<div class="total-rate">${rateVO.totalRate}</div>
								<div class="academy-rate-detail">
									<div class="rate-detail-cell">
										<span class="cat-label">전공생위주</span>
										<span class="cat-ratio">${rateVO.majorRate}  ${rateVO.nonMajorRate}</span>
									</div>
									<div class="rate-detail-cell">
										<span class="cat-label">강사진</span>
										<span class="cat-text">${rateVO.teacher}</span>
									</div>
									<div class="rate-detail-cell">
										<span class="cat-label">실습환경</span>
										<span class="cat-text">${rateVO.environment}</span>
									</div>																		
								</div>
							</div>
						</div>
						<div class="info-box right">
							<div class="title">강의정보</div>
							<div class="academy-train">
							<c:forEach var="train" items="${trainVO}">
								<div class="train-container">
									<div class="train-title">
										${train.trainTitle}
									</div>
									<span class="target">${train.target}</span>
									<span class="yard-man">정원 ${train.yardMan}명</span>
									<span class="start-date">${train.startDate}</span>
									~
									<span class="start-date">${train.endDate}</span>
								</div>							
							</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="academy-acadam-container">
					<div class="title">ACA담</div>
					<button type="button" class="acadam-write-btn" onclick="openEditModal()">
						글쓰기
					</button>						
					<div class="acadam-contents-container">															
					</div>
					<div class="clone">
						<div class="acadam-post-container">
							<div class="acadam-title"></div>
							<div class="tag-list">
								<div class="acadam-post-tag major"></div>
								<div class="acadam-post-tag environment"></div>
								<div class="acadam-post-tag teacher"></div>
							</div>
							<span class="academy-title"></span>
							<span class="view-cnt"></span>
							<span class="date"></span>
						</div>
					</div>					
				</div>
				<div class="academy-map-container">
					<div class="title">위치정보</div>
					<div id="map"></div>
					<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=904b0d1b4b8f0dc681621555a51cfa3f&libraries=services"></script>
					<script>
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						    mapOption = {
						        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
						        level: 3 // 지도의 확대 레벨
						    };  
						
						// 지도를 생성합니다    
						var map = new kakao.maps.Map(mapContainer, mapOption); 
						
						// 주소-좌표 변환 객체를 생성합니다
						var geocoder = new kakao.maps.services.Geocoder();
						
						// 주소로 좌표를 검색합니다
						geocoder.addressSearch('${acadVO.address}', function(result, status) {
						
						    // 정상적으로 검색이 완료됐으면 
						     if (status === kakao.maps.services.Status.OK) {
						
						        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
						
						        // 결과값으로 받은 위치를 마커로 표시합니다
						        var marker = new kakao.maps.Marker({
						            map: map,
						            position: coords
						        });
						
						        // 인포윈도우로 장소에 대한 설명을 표시합니다
						        var infowindow = new kakao.maps.InfoWindow({
						            content: '<div style="width:150px;text-align:center;padding:6px 0;">${acadVO.acadTitle}</div>'
						        });
						        infowindow.open(map, marker);
						
						        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
						        map.setCenter(coords);
						    } 
						});   
					</script>					
				</div>
			</div>
		</div>
	</div>

</body>
</html>