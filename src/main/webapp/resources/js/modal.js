//toggle시작
function startToggleAction(toggleBg, toggleFg, LR){
	if(LR == 'TO_RIGHT'){
    	toggleBg.addClass('on');
    	toggleFg.addClass('on');
	}else{
    	toggleBg.removeClass('on');
    	toggleFg.removeClass('on');
	}
}
//모달창 close
function closeEditModal(){	    	
	var form = $("#acadam-write-form")[0];
	
	//form 초기화
	for(var i=0; i<form.length; i++){
		var ele = form[i];
		var type = ele.type;
			name = ele.name;
			tag = ele.tagName.toLowerCase();
	    if (
	      type === 'text' ||
	      type === 'password' ||
	      type === 'hidden' ||
	      tag === 'textarea'
	    ) {
	    	if(ele.name == 'major') {
	    		//toggle창 초기화
	    		startToggleAction($('.major-toggle-bg'),$('.major-toggle-fg'), 'TO_LEFT');
	    		ele.value='1';
	    	}else{
	    		ele.value = '';
	    	}
	    } else if (type === 'radio') {
	    	//default값 5로 설정
	    	if(ele.value == '5') ele.checked = true;
	    	else ele.checked = false;
	    } else if (tag === 'select') {
	    	ele.selectedIndex = -1;
	    }	 				
	}
	
	$('.acadam-edit-modal').hide();
}
//모달창 open 
function openEditModal(){
	$('.acadam-edit-modal').show();
}

//major hidden값에 value 설정
function setMajorValue(LR){
	var major = $('input[name=major]');
	var value = LR == 'TO_RIGHT' ? '0' : '1';
	
	major.val(value);
}