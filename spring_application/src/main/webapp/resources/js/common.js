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