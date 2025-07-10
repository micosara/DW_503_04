<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ include file="/WEB-INF/views/module/header.jsp" %>    
<div class="">

  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>권한수정</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">회원관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	권한/수정
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
	<!-- Main content -->
	<section class="content">
		<div class="">
			<div class="login-logo">
    			<a href=""><b>권한 수정</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="card-body">
					<form role="form" class="form-horizontal" action="modify" method="post" >						
						
						  <div class="form-group row">
							 <label for="id" class="col-sm-3" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*</span>아이디</label>	
							 <div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" class="form-control"  value ="${member.id }" readonly/>						
							</div>								
						</div>
						
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>이 름</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="name" type="text" class="form-control" value="${member.name }" readonly />
							</div>
							
						</div>		
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size:0.9em;" >직책권한</label>
							<div class="col-sm-9 row">
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" type="checkbox" 
										 ${member.authorities.contains('ROLE_USER') ? 'checked':'' }
										 id="role1" name="authorities" value="01">
										<label for="role1" class="custom-control-label">사용자</label>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" 
										${member.authorities.contains('ROLE_MANAGER') ? 'checked':'' }
										type="checkbox" id="role2" name="authorities" value="02">
										<label for="role2" class="custom-control-label">운영자</label>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" 
										${member.authorities.contains('ROLE_ADMIN') ? 'checked':'' }
										type="checkbox" id="role3" name="authorities" value="03">
										<label for="role3" class="custom-control-label">관리자</label>
									</div>
								</div>
							</div>
							
						</div>
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size:0.9em;" >회원관리권한</label>
							<div class="col-sm-9 row">
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" 
										${member.authorities.contains('MEMBER_CREATE') ? 'checked':'' }
										type="checkbox" id="user1" name="authorities" value="11">
										<label for="user1" class="custom-control-label">등록</label>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input"
										${member.authorities.contains('MEMBER_UPDATE') ? 'checked':'' }
										type="checkbox" id="user2" name="authorities" value="13">
										<label for="user2" class="custom-control-label">수정</label>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" 
										${member.authorities.contains('MEMBER_DELETE') ? 'checked':'' }
										type="checkbox" id="user3" name="authorities" value="14">
										<label for="user3" class="custom-control-label">삭제</label>
									</div>
								</div>
							</div>
						</div>		
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size:0.9em;" >공지관리권한</label>
							<div class="col-sm-9 row">
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" 
										${member.authorities.contains('NOTICE_CREATE') ? 'checked':'' }
										type="checkbox" id="notice1" name="authorities" value="21">
										<label for="notice1" class="custom-control-label">등록</label>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input" 
										${member.authorities.contains('NOTICE_UPDATE') ? 'checked':'' }
										type="checkbox" id="notice2" name="authorities" value="23">
										<label for="notice2" class="custom-control-label">수정</label>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="custom-control custom-checkbox">
										<input class="custom-control-input"
										${member.authorities.contains('NOTICE_DELETE') ? 'checked':'' }
										type="checkbox" id="notice3" name="authorities" value="24">
										<label for="notice3" class="custom-control-label">삭제</label>
									</div>
								</div>
							</div>
						</div>									
						
						<div class="card-footer">
							<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="modify_go();" class="btn btn-info">수&nbsp;&nbsp;정</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow();"
										class="btn btn-default float-right">취 &nbsp;&nbsp;소</button>
								</div>
							
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>
		</div>
	</section>		<!-- /.content -->
</div>

<%@ include file="/WEB-INF/views/module/footer.jsp" %>   

<script>
function modify_go(){
	let isRole = $('#role1').prop("checked") 
			    || $('#role2').prop("checked") 
			    || $('#role3').prop("checked"); 
	if(!isRole) {
		alert("직책은 최소 1개 이상이어야 합니다.");
		return;
	}
	
	$('form[role="form"]').submit();
}
</script>


</body>
</html>





