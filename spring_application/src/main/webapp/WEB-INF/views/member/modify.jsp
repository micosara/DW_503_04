<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>회원 수정</title>

<head></head>

<body>



<c:if test="${empty member }">
<script>
	alert("존재하지 않는 회원입니다.")
	history.go(-1);
</script>

</c:if>


<!-- Content Wrapper. Contains page content -->
<div>
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>수정페이지</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#"> <i
								class="fa fa-dashboard">회원관리</i>
						</a></li>
						<li class="breadcrumb-item active">수정</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- Main content -->
	<section class="content register-page">
		<form name="modify" class="form-horizontal" action="modify.do"
			method="post" enctype="multipart/form-data">
			<div class="card" style="min-width: 450px;">
				<div class="register-card-body">
					<div class="row">
						<input type="file" id="inputFile" name="picture" style="display: none" onchange="picture_go();" />                        
						<div class="input-group col-md-12">
							<div class="col-md-12" style="text-align: center;">
								<div id="pictureView" class="person-info" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; margin-bottom: 5px;"></div>
								<div class="input-group input-group-sm">
									<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">사진변경</label>
                                    <input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled value="${member.picture.split('\\$\\$')[1] }" />

								</div>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="id" class="col-sm-3 control-label text-center">아이디</label>
						<div class="col-sm-9">
							<input readonly name="id" type="text" class="form-control" id="id" value="${member.id }" />
						</div>
					</div>

					<div class="form-group row">
						<label for="pwd" class="col-sm-3 control-label text-center">패스워드</label>

						<div class="col-sm-9">
							<input name="pwd" type="password" class="form-control" id="pwd" value="${member.pwd }" onblur="validation(this.name);"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="name" class="col-sm-3 control-label text-center">이름</label>

						<div class="col-sm-9">
							<input name="name" type="text" class="form-control" id="name" value="${member.name }" onblur="validation(this.name);"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-3 control-label text-center">이메일</label>

						<div class="col-sm-9">
							<input name="email" type="email" class="form-control" id="email"
								placeholder="example@naver.com" value="${member.email }" onblur="validation(this.name);">
						</div>
					</div>
					<div class="form-group row">
						<label for="phone" class="col-sm-3 control-label text-center">전화번호</label>
						<div class="col-sm-9">
							<input name="phone" type="text" class="form-control"
								id="inputPassword3" value="${member.phone }">
						</div>
					</div>

					<div class="card-footer row"
						style="margin-top: 0; border-top: none;">
						<button type="button" id="modifyBtn" onclick="modify_go();"
							class="btn btn-warning col-sm-4 text-center">수정하기</button>
						<div class="col-sm-4"></div>
						<button type="button" id="cancelBtn" onclick="history.go(-1);"
							class="btn btn-default pull-right col-sm-4 text-center">취
							소</button>
					</div>
				</div>
			</div>
		</form>
	</section>
	<!-- /.content -->
</div>



<script>
function modify_go(){
	let form = document.forms.modify;
	for(let element of form ){
		switch(element.name){
			case "pwd":case "email":case "phone":case "name":
			if(!element.value){
				alert(element.name+"은 필수입니다.");					
				if(element.name=="picture"){
					element.click();
				}else{
					element.focus();
				}					
				return;
			}
			
			if(element.name=="phone" && element.value ){
				let regExp = /[0-9]{10,11}$/g;
				if(!element.value.match(regExp)){
					alert("전화번호 형식이 올바르지 않습니다.");
					element.focus();
					return;
				}
			}	
		}
	}
	
	
	form.action="modify";
	form.method="post";
	form.submit();
}

</script>
<script>
	MemberPictureBackground("<%=request.getContextPath()%>");
</script>    

</body>    
    
    
    
    