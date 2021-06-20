<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학원목록</title>
<script type="text/javascript">
	var isFirstLoad = true;
	$(function(){
		//서울 기본 세팅
		getCityDtlCd('11');
		
		$('.sd-item').click(function(){
			getCityDtlCd(this.id);
		});
	});
	//동적으로 생선된 div click 이벤트는 이렇게 사용해야 함...
	$(document).on("click",".sgg-item",function(){
		getAcademyList(this.id, $(this).text());			
	});
	
	function getCityDtlCd(id){
 		$.ajax({
 			url:"/acait/cityDtl",
 			type:"GET",
 			data:{'cityUpperCd':id},
 			success:function(data){
 				var list = data.result;
 				var html = ''
				for(var i=0; i<list.length; i++){
					html += '<div id="'+list[i].cityDtlCd+'" class=sgg-item>'
					html += list[i].cityDtlNm
					html += '</div>'
					console.log(list[i].cityDtlNm);
 				}	
 				
 				$('.city-sgg').html(html);
 			},
 			error: function(xhr, status, error){
 				console.log(error);
			}
 		});
 		
 		$('.sd-item').removeClass("on");

 		$("#"+id).addClass("on");
 		
 		if(isFirstLoad){
 			//강남구 기본 세팅
 			getAcademyList('11680','강남구');
 			isFirstLoad = false;
 		}else{
 			getAcademyList('0','전체');
 		}

	}
	
	function getAcademyList(id,nm){
		//전체 선택시 citydtlnm을 상위 시도 이름으로 설정
		if(id == '0') nm = ($('.sd-item.on').html()).trim();
 		$.ajax({
 			url:"/acait/academyAjax",
 			type:"GET",
 			data:{'cityDtlCd':id,
 				  'cityDtlNm':nm	
 			     },
 			success:function(data){
 				var list = data.result;
 				var acadCd = ''
 				console.log(list);
 				var html = '<div><span>학원명</span><span>강좌수</span><span>게시글수</span>';
				for(var i=0; i<list.length; i++){
					//처음 학원 기본값으로 상세 정보 보여줌
					if(i==0) acadCd = list[i].ACAD_CD
					html+="<div>";
					html+="<span>"+list[i].ACAD_TITLE+"</span>";
					html+="<span>"+list[i].강좌수+"</span>";
					html+="<span>"+list[i].게시글수+"</span>";
					html+="</div>";
 				}	
 				
 				$('.academy-list').html(html);
 				getAcademyDetail(acadCd);
 				
 			},
 			error: function(xhr, status, error){
 				console.log(error);
			}
 		});		
	}
	
	function getAcademyDetail(acadCd){
 		$.ajax({
 			url:"/acait/academyDtlAjax",
 			type:"GET",
 			data:{'acadCd':acadCd},
 			success:function(data){
 				var trainVO = data.trainVO;
 				var rateVO = data.rateVO;
 				
 				var html = '';
 				
 				$('.academy-detail').html(html);
 			},
 			error: function(xhr, status, error){
 				console.log(error);
			}
 		});		
	}
</script>
</head>
<body>
<div class="city-sd">
	<c:forEach var="city" items="${cityVO}">
		<div id="${city.cityCd}" class="sd-item">
			${city.cityNm}	
		</div>				
	</c:forEach>
</div>
<br>
<div class="city-sgg">
	
</div>
<br>
<div class="academy-list">

</div>

<br>
<div class="academy-detail">
	간략정보
	<div class="info">
		
	</div>
	커리큘럼
	<div class="curriculum">
		
	</div>
</div>

</body>
</html>