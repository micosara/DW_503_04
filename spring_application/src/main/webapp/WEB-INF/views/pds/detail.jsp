<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div class="wrapper">
	 <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>자료실</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>자료실</a></li>
			        <li class="breadcrumb-item active">상세보기</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>


  <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
						<div class="card-tools">
							<button type="button" id="modifyBtn" class="btn btn-warning" onclick="modify();">Modify</button>						
					    	<button type="button" id="removeBtn" class="btn btn-danger" onclick="remove();">REMOVE</button>
					   		<button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">CLOSE </button>
						</div>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label>
							<input type="text" class="form-control" id="title" 
								value="${pds.title }" readonly />							
						</div>	
						<div class="col-sm-12 row">
							<div class="form-group col-sm-4" >
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" 
									 value="${pds.writer }" readonly />
							</div>		
							
							<div class="form-group col-sm-4" >
								<label for="regDate">작성일</label>
								<input type="text" class="form-control" id="regDate" 
									value="<fmt:formatDate pattern="yyyy-MM-dd" value="${pds.regDate }" />" readonly />
							</div>	
							<div class="form-group col-sm-4" >
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" value="${pds.viewcnt }" readonly />
							</div>	
						</div>	
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div >${pds.content }</div>	
						</div>
						<div class="form-group col-sm-12">
							<div class="card card-outline card-success">
								<div class="card-header">
									<h3>첨부파일</h3>
								</div>
											
								<div class="card-footer">
									<div class="row">
										<!-- attaches -->
																	
									</div>
								</div>				
							</div>
						</div>
												
					</div>
					<div class="card-footer">
						
							
					</div>									
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row  -->		
		
    </section>
</div>


<script>
function modify(){
	//alert("click modify btn");
	location.href="modify?pno=${pds.pno}";
}
function remove(){
	//alert("click remove btn");
	let answer = confirm("정말 삭제하시겠습니다.");
	if(!answer) return;
	
	location.href="remove?pno=${pds.pno}";
}

</script>
</body>







