<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="com.application.dto.MemberVO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@ include file="/WEB-INF/views/module/header.jsp" %>
<head>
    
<style>
	table th,td{
		text-align:center;
		padding:5px;
	}
</style>

</head>    

<!-- Content Wrapper. Contains page content -->    

<!-- Main content -->
<section class="content-header">
  	<div class="container-fluid">
  		<div class="row md-2">
  			<div class="col-sm-6">
  				<h1>회원목록</h1>  				
  			</div>
  			<div class="col-sm-6">
  				<ol class="breadcrumb float-sm-right">
		        <li class="breadcrumb-item">
		        	<a href="list.do">
			        	<i class="fa fa-dashboard"></i>회원관리
			        </a>
		        </li>
		        <li class="breadcrumb-item active">
		        	목록
		        </li>		        
    	  </ol>
  			</div>
  		</div>
  	</div>
</section>
 
 
  	<section class="content">
  		<div class="card">
  			<div class="card-header with-border">
  				<button type="button" class="btn btn-primary" onclick="OpenWindow('regist','회원등록',700,900);" >회원등록</button>   				
			<div id="keyword" class="card-tools" style="width:550px;">
				 <div class="input-group row">
				 	<!-- search bar -->
				 	<!-- sort num -->
	  	<select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="">					  		  		
	  							  		
	  	</select>
	  	
	  	<!-- search bar -->
	 	<select class="form-control col-md-3" name="searchType" id="searchType">
	 							 				 									
		</select>
		<!-- keyword -->
				 	<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value=""/>
		<span class="input-group-append">
			<button class="btn btn-primary" type="button" onclick="search_list(1);" id="searchBtn" data-card-widget="search" >
				<i class="fa fa-fw fa-search"></i>
			</button>
		</span>
	<!-- end : search bar -->		 
				 </div>
			</div>   			
		</div>
		<div class="card-body" >    		
  		<table class="table table-bordered table-striped" id="memberTable">
  			
   			<tr>
	   			<th style="width:10%;">사진</th>
               	<th style="width:15%;">아이디</th>
               	<th style="width:15%;">패스워드</th>
               	<th style="width:15%;">이 름</th>
               	<th style="width:15%;">이메일</th>
               	<th style="width:15%;">전화번호</th>
               	<th>등록날짜</th> <!-- yyyy-MM-dd  -->
 	       </tr>
           
           <c:if test="${empty memberList }">
	           <tr>
	           		<th colspan="7" class="text-center">해당 데이터가 존재하지 않습니다.</th>
	           </tr>	
           </c:if>		
       
 		   <c:if test="${not empty memberList }">
 		   	<c:forEach var="member" items="${memberList }" >
 		   		<fmt:formatDate pattern="yyyy-MM-dd" var="regDate" 
 		   						value="${member.regDate}"/>
	 		   	<tr>
	 		   		<td></td>
	           		<td>${member.id }</td>
	           		<td>${member.pwd }</td>
	           		<td>${member.name }</td>
	           		<td>${member.email }</td>
	           		<td>${member.phone }</td>
	           		<td>${regDate } </td>
	 		   	</tr>
	 		   	</c:forEach>
 		   	</c:if>
 		
          </table>
		    
		</div> <!-- card-body -->
		<div class="card-footer">
			
		</div>
  </div>
</section>


<%@ include file="/WEB-INF/views/module/footer.jsp" %>

<script>


</script>

</body>
</html>

