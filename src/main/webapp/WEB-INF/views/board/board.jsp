<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	<style>
		a{
		  	text-decoration : none;
		  }
		  table{
		 	border-collapse: collapse;
		 	width: 1000px;    
		 	margin-top : 20px;
		 	text-align: center;
		  }
		  td, th{
		  	border : 1px solid black;
		  	height: 50px;
		  }
		  th{
		  	font-size : 17px;
		  }
		  thead{
		  	font-weight: 700;
		  }
		  .table_wrap{
		  	margin : 50px 0 0 50px;
		  }
		  .bno_width{
		  	width: 12%;
		  }
		  .content_width{
		  	width: 20%;
		  }
		  .regdate_width{
		  	width: 15%;
		  }
		  .hit_width{
		  	width: 15%;
		  }
		  .top_btn{
		  	font-size: 20px;
		    padding: 6px 12px;
		    background-color: #fff;
		    border: 1px solid #ddd;
		    font-weight: 600;
		  }
		.pageInfo{
		      list-style : none;
		      display: inline-block;
		    margin: 50px 0 0 100px;      
		  }
		  .pageInfo li{
		      float: left;
		    font-size: 20px;
		    margin-left: 18px;
		    padding: 7px;
		    font-weight: 500;
		  }
		 a:link {color:black; text-decoration: none;}
		 a:visited {color:black; text-decoration: none;}
		 a:hover {color:black; text-decoration: underline;}
		.active{
		      background-color: #cdd5ec;
		  }
	</style>
	<head>
		<title>Board</title>
		<meta charset="UTF-8">
		<script
		  src="https://code.jquery.com/jquery-3.4.1.js"
		  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" 
		  crossorigin="anonymous"></script>
	</head>
	<body>
	<h1>목록페이지입니다.</h1>
		<div class="table_wrap">
						<!-- 정렬 버튼 -->
						<a href="/acait/board?sort=HIT">조회순</a>
						<a href="/acait/board?sort=REG_DATE">날짜순</a>
			<table>
				<thead>
					<tr>
					    <th class="bno_width">번호</th>
						<th class="title_width">제목</th>
						<th class="content_width">내용</th>
						<th class="regdate_width">작성일</th>
						<th class="hit_width">조회수</th>					
					</tr>
				</thead>
					<c:forEach var="boardlist" items="${boardlist}">
					<tr>
						<td> ${boardlist.boardNo} </td>
						<td> <a href="/acait/view?boardNo=${boardlist.boardNo}">${boardlist.title}</a> </td>
						<td> ${boardlist.content} </td>
						<th> ${boardlist.regDate} </th>
						<th> ${boardlist.hit} </th>
					</tr>
					</c:forEach>
			</table>
			<form id="moveForm" method="get">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount}"> 
				<input type="hidden" name="sort" value="${pageMaker.cri.sort}">
			</form>
		<div class="sort_wrap">
	        <div class="search_area">
	            <input type="String" name="sort" value="${pageMaker.cri.sort}">
	            <button>Sort</button>
	        </div>
	    </div>  
		<div class="pageInfo_wrap">
			<div class="pageInfo_area">
					<ul id="pageInfo" class="pageInfo">
						<!-- 이전페이지 버튼 -->
		                <c:if test="${pageMaker.prev}">
		                    <li class="pageInfo_btn previous"><a href="/acait/board?pageNum=${pageMaker.startPage-1}">Previous</a></li>
		                </c:if>
			                
		                <!-- 페이지 번호 버튼 -->
						<c:forEach var="num" begin="${pageMaker.startPage}" end ="${pageMaker.endPage}">
							<li class="pageInfo_btn ${pageMaker.cri.pageNum == num ? "active":"" }"><a href="/acait/board?pageNum=${num}">${num}</a></li>
						</c:forEach>
		                
		                <!-- 다음페이지 버튼 -->
		                <c:if test="${pageMaker.next}">
		                    <li class="pageInfo_btn next"><a href="/acait/board?pageNum=${pageMaker.endPage + 1 }">Next</a></li>
		                </c:if> 
		                
		                <button type="button" class="acadam-write-btn" onclick="openEditModal()">
			                  글쓰기
			               </button>  
					</ul>
				</div>
			</div>
		</div>
		<script>
		    $(document).ready(function(){
		    	let result = '<c:out value="${result}"/>'
		    		checkAlert(result);
		        
			        function checkAlert(result){
			            
			            if(result === ''){
			                reutrn;
			            }
			            
			            if(result === "enrol success"){
			                alert("등록이 완료되었습니다.");
			            }
			            
			        }    
		    });
		 
		</script>	
	</body>
</html>