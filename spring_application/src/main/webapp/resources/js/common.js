function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth
							+",height="+ WinHeight +", top="+ wintop +", left=" 
							+ winleft +", resizable=yes, status=yes"  );
	win.focus() ; 
} 


//팝업창 닫기
function CloseWindow(){
	
	window.opener.location.reload(true);		
	window.close();
}

function picture_go(){
	//alert("change file");
	let pictureInput = document.querySelector("input[name='picture']");
	let file = pictureInput.files[0];
	
	//이미지 확장자 jpg 확인
    var fileFormat = file.name.substr(file.name.lastIndexOf(".")+1).toUpperCase();
    if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
        alert("이미지는 jpg/jpeg 형식만 가능합니다.");
        pictureInput.value="";      
        return;
    }
    
    //이미지 파일 용량 체크
    if(file.size>1024*1024*1){
         alert("사진 용량은 1MB 이하만 가능합니다.");
         pictureInput.value="";
         return;
     };
     
     //파일명 표시
 	 document.querySelector('#inputFileName').value=file.name; 
     
     let pictureView = document.querySelector("#pictureView");
     if(file){
		var reader = new FileReader();
		
		 reader.onload = function (e) {
			pictureView.style.backgroundImage = "url("+e.target.result+")";
		 	pictureView.style.backgroundPosition="center";
		 	pictureView.style.backgroundSize="cover";
		 	pictureView.style.backgroundRepeat="no-repeat";		
		 }
		 
		 reader.readAsDataURL(file);
 	}
} 


//회원 정보 유효성
var valid_data = {
		email:{
			pattern:/^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$/g,
			message:"이메일 형식이 아닙니다."
		},
		name:{
			pattern:/^[가-힣]{2,6}$/g,
			message:"이름은 한글 2~6글자 입니다."
		},
		id:{
			pattern:/^[a-z]+[a-zA-Z0-9]{3,12}$/g,
			message:"아이디 형식이 올바르지 않습니다."
		},
		pwd:{
			pattern:/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/g,
			message:"패스워드 형식이 올바르지 않습니다.\n영문자 숫자 특수문자 조합으로 8~20글자로 하세요."
		}
}
function validation(elementName){			
	let flag = true;
	
	let regExp = valid_data[elementName].pattern;
	let message =  valid_data[elementName].message;
	
	let input = $('input[name="'+elementName+'"]');		
	
	if(input.val()){ 
		if(!input.val().match(regExp)){
			alert(message);
			input.val('');
			flag=false;
		}	
	}else{
		flag=false;
	}
	
	return flag;
}

//회원 백그라운사진 : contextPath -> context path parameter
function MemberPictureBackground(contextPath){
	let elements = document.querySelectorAll('.person-info');
	for(let element of elements){
		let id = element.getAttribute("data-id");		
	
		element.style.backgroundImage ="url('"+contextPath+"/member/getPicture?id="+id+"')";
		element.style.backgroundPosition="center";
		element.style.backgroundRepeat="no-repeat";
		element.style.backgroundSize="cover";
	}
}



function sendFile(file,el,context){
	var form_data = new FormData();
	form_data.append("file", file);
	
	$.ajax({
		url:context+'/summernote/uploadImg',
		method:"POST",
		data: form_data,
		contentType:false,
		processData:false,
		success:function(img_url){
			//alert(img_url);
			$(el).summernote('editor.insertImage', img_url);
		},
		error:function(error){
			alert("이미지 등록이 불가합니다.");
	    }
	});
	
	
}
function deleteFile(fileName,context) {      
   $.ajax({
      url:context+"/summernote/deleteImg?fileName="+fileName,
      success:function(res){
         console.log(res);
      },
      error:function(error){
		alert("파일 삭제가 불가합니다.");
	  }
   });
}	

function Summernote_go(target,context){
	target.summernote({
	   placeholder:'여기에 내용을 적으세요.',
       lang:'ko-KR',
       height:350,
       disableResizeEditor: "false",
       callbacks:{
    	   onImageUpload : function(files, editor, welEditable) {
    		  // alert("images click");
    		  for(file of files){
    			  if(file.name.substring(file.name.lastIndexOf(".")+1).toUpperCase() != "JPG"){
                      alert("JPG 이미지형식만 가능합니다.");
                      return;
                   }
                   if(file.size > 1024*1024*1){
                      alert("이미지는 1MB 미만입니다.");
                      return;
                   }         
    		  }
    		  
   		  	 for (var file of files) {
                  sendFile(file,this,context);
             }
    		  
    	   },
    	   onMediaDelete : function(target) {
    		   //alert(target[0].src.split("=")[1]);
    		    let fileName = target[0].src.split("=")[1];
    		    deleteFile(fileName,context);
    	   }
       }
       
	});
	
}





