<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.css">
  <!-- Summernote -->
  <script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/summernote/summernote-bs4.min.js"></script>
</head>

<body>

 <!-- Main content -->
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
  <!-- Main content -->
    <section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width:960px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">공지등록</h3>
						<div class ="card-tools">
							<button type="button" class="btn btn-primary" id="registBtn" onclick="regist_go();">등 록</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-warning" id="cancelBtn" onclick="CloseWindow();" >취 소</button>
						</div>
					</div><!--end card-header  -->
					<div class="card-body pad">
						<form role="form" method="post" action="regist.do" name="registForm">
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title"  title="제목"
									name='title' class="form-control notNull" placeholder="제목을 쓰세요">
							</div>							
							<div class="form-group row">														
								<label for="writer">작성자</label>
								<div class="col-sm-6 row">									
									<div class="col-sm-2" >
										<span class="person-info" data-id="mimi" ></span>
									</div>
									<div class="col-sm-10" >mimi</div>									
								</div> 
								
								<input type="hidden" id="writer" title="작성자" readonly
									name="writer" class="form-control notNull" value="mimi" >
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="content" id="content" rows="20"
									cols="90" placeholder="1000자 내외로 작성하세요." ></textarea>
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer" style="display:none">
					
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>





<script>
function regist_go(){
	var form = document.forms.registForm;
	
	var inputNotNull = document.querySelectorAll(".notNull");
	for(var input of inputNotNull){
		if(!input.value){
			alert(input.getAttribute("title")+"은 필수입니다.");
			input.focus();
			return;
		}
	}	
	
	form.action="regist";
	form.method="post";
	form.submit();
}
</script>



<script>
MemberPictureBackground("<%=request.getContextPath()%>");

$(".person-info").css({
	"display":"block",
	"width":"30px",
	"height":"30px",
	"border-radius":"10px"
});

$("textarea#content").summernote({
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
                  sendFile(file,this,'<%=request.getContextPath()%>');
             }
    		  
    	   },
    	   onMediaDelete : function(target) {}
       }
       
});
</script>

<script>
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
</script>
</body>





