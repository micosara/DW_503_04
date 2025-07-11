<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<title>회원 상세</title>
<body>
 <div >
      <section class="content-header">
        <div class="container-fluid">
           <div class="row md-2">
              <div class="col-sm-6">
                 <h1>상세페이지</h1>              
              </div>
              <div class="col-sm-6">
                 <ol class="breadcrumb float-sm-right">
                 <li class="breadcrumb-item">
                    <a href="#">
                       <i class="fa fa-dashboard">회원관리</i>
                    </a>
                 </li>
                 <li class="breadcrumb-item active">
                    상세보기
                 </li>              
            </ol>
              </div>
           </div>
        </div>
     </section>
    <!-- Main content -->
    <section class="content register-page">       
      <div class="register-box">         
          <form role="form" class="form-horizontal"  method="post" onsubmit="return false;">
             <div class="register-card-header" >
                <h1 class="text-center">회원 상세보기</h1>
             </div>
              <div class="register-card-body" >
                  <div class="row"  style="height:200px;">
                  <div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">                     
                     <div id="pictureView" class="person-info" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>                                          
                  </div>
               </div>
               <br />
                   <div class="form-group row" >
                     <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
   
                     <div class="col-sm-9">
                       <input name="id" type="text" class="form-control" id="inputEmail3"  value="${member.id }"  readonly>
                     </div>
                   </div>                  
                   <div class="form-group row">
                     <label  class="col-sm-3 control-label text-right">이  름</label>
   
                     <div class="col-sm-9">
                       <input name="pwd" type="text" class="form-control"  value="${member.name }" readonly>
                     </div>
                   </div>
                    <div class="form-group row">
                     <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
   
                     <div class="col-sm-9">
                       <input name="email" type="email" class="form-control"  value="${member.email }" readonly>
                     </div>
                   </div>
                    <div class="form-group row">
                     <label class="col-sm-3 control-label text-right">전화번호</label>
                     <div class="col-sm-9">   
                        <input name="phone" type="text" class="form-control" value="${member.phone }" readonly>                   
                     </div>                  
                   </div>               
                 </div>  
                <div class="card-footer" style="padding:5px 0;" >
                      <div class="row">
                         <div class="col-sm-4 text-center">                         	
                            <button type="button" onclick="location.href='modify?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
                         	
                         </div>
                      
                         <div class="col-sm-4 text-center">
                        	 <button type="button" onclick="remove_go()" id="deleteBtn" class="btn btn-danger" >삭 제</button>
                         </div>
                         
                         <div class="col-sm-4 text-center">
                           <button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button>
                        </div>
                     </div>  
                    
                   		<hr/>
                     	<button type="button" class="btn btn-primary col-sm-12"	
                     	        onclick="OpenWindow('authority/modifyForm?id=${member.id}','권한수정','700','500');">권한 수정</button>
                    
                </div>
              </form>
           </div>
    </section>
    
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  


<script>
	MemberPictureBackground("<%=request.getContextPath()%>");
</script>

<script>
function remove_go(){
	//alert("click remove btn");
	let answer = prompt("삭제할 회원의 아이디를 입력하세요.");
	if(answer!='${member.id}') {
		alert("아이디가 일치하지 않습니다.");
		return;
	}
	
	location.href="remove?id=${member.id}";
}

</script>


</body>




  