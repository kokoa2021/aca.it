<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<script type="text/javascript">	    
	$(function(){
		$('.major-toggle-bg').on('click',function(){
	     var toggleBg = $(this);
	     var toggleFg = $(this).find('.major-toggle-fg');
		var left = toggleFg.css('left');
		
	     if(left == '0px'){ //토글 off -> on
	     	startToggleAction(toggleBg,toggleFg,'TO_RIGHT');
	         setMajorValue('TO_RIGHT');
	     }else{ //토글 on -> off
	     	startToggleAction(toggleBg,toggleFg,'TO_LEFT');
	         setMajorValue('TO_LEFT');
	     }	    		
		});
	});
</script>
<body>
    <div class="footer-infos">
      <div class="footer-info"></div>
      <div class="footer-copyright" style="margin-top: 90px">with<br>KOKOA TEAM</div>
    </div>
    <form name="acadam-write-form" id="acadam-write-form" method="post" action="/acait/board">
		<div class="acadam-edit-modal">
			<div class="acadam-edit-modal-container">
				<div class="acadam-edit-modal-wrapper">
		        	<i class="close-btn pointer" onclick="closeEditModal()">x</i>
			        <div class="search-bar">
			          <i class="search-icon">돋보기</i>
			          <div class="autosuggest_container">
			          	<input type="hidden" name="acadCd" value="">
			            <input type="text" class="autosuggest_input" name="acadTitle" value="" placeholder="학원을 검색해주세요.">
			          </div>
			        </div>
			        <div class="rate-list">
			          <div class="acadam-post-tag">
			            <span class="title">전공생 위주</span>
			            <span class="content">
			            	<input type="hidden" name="major" value="1">
			            	<div class='major-toggle-bg'>
    							<button type='button' id='buttonID' class='major-toggle-fg'></button>
							</div>
			            </span>
			          </div>
			          <div class="acadam-post-tag">
			            <span class="title">강사진</span>
			            <span class="content">
			              <label><input type="radio" name="teacher" value="5" checked>상</label>
			              <label><input type="radio" name="teacher" value="3">중</label>
			              <label><input type="radio" name="teacher" value="1">하</label>
			            </span>
			          </div>
			          <div class="acadam-post-tag">
			            <span class="title">실습환경</span>
			            <span class="content">
			              <label><input type="radio" name="environment" value="5" checked>상</label>
			              <label><input type="radio" name="environment" value="3">중</label>
			              <label><input type="radio" name="environment" value="1">하</label>
			            </span>
			          </div>          
			        </div>
			        <div class="contents">
			          <div class="post-title-wrapper">
			            <input type="text" name="title" placeholder="제목을 입력해주세요">
			          </div>
			          <div class="post-content-wrapper">
			            <textarea placeholder="내용을 입력해주세요" name="content" rows="8" style="margin-top: 10px; width: 100%; height: 240px;"></textarea>
			          </div>
			      	</div>
			      	<div class="input-pwd">
				        <button type="submit" class="confirm-btn pointer">게시</button>
				        <input type="password" name="pwd" placeholder="비밀번호 8자리" maxlength="8">
			      	</div>
				</div>
			</div>
		</div>
	</form>
</body>