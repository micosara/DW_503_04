<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

 
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>공지사항</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>공지사항</a></li>
			        <li class="breadcrumb-item active">리스트</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" id="registBtn" onclick="OpenWindow('regist','공지등록',700,800);">공지등록</button>
				<div id="keyword" class="card-tools" style="width:450px;">	
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum">
					  		<option value="10" ${pageMaker.perPageNum==10 ? 'selected':'' } >정렬개수</option>
					  		<option value="20" ${pageMaker.perPageNum==20 ? 'selected':'' }>20개씩</option>
					  		<option value="30" ${pageMaker.perPageNum==30 ? 'selected':'' }>30개씩</option>
					  		<option value="50" ${pageMaker.perPageNum==50 ? 'selected':'' }>50개씩</option>
					  		
					  	</select>		
						<select class="form-control col-md-3" name="searchType" id="searchType">
							<option value="tcw" ${pageMaker.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
							<option value="t"   ${pageMaker.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w"   ${pageMaker.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="c"   ${pageMaker.searchType eq 'c' ? 'selected':'' }>내 용</option>
							<option value="tc"  ${pageMaker.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
							<option value="cw"  ${pageMaker.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>		
						</select>				
						<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." 
								value="${pageMaker.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search" onclick="search_list(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>						
				</div>			
			</div>
			<div class="card-body">
				<table class="table table-bordered table-striped text-center"  id="noticeTable" >
					<thead>
					<tr style="font-size:0.95em;">
						<th style="width:10%;">번 호</th>
						<th style="width:40%;">제 목</th>
						
						<th style="width:15%;">작성자</th>
						<th>등록일</th>
						<th style="width:10%;">조회수</th>
					</tr>	
					</thead>
					<tbody>
					<c:if test="${empty noticeList}">
						<td colspan="6">해당내용이 없습니다.</td>
					</c:if>
					<c:if test="${not empty noticeList}">
						<c:forEach items="${noticeList }" var="notice">
						  <tr onclick="OpenWindow('detail?nno=${notice.nno}','공지 상세',700,800);" style="cursor:pointer;">
							<td>${notice.nno }</td>
							<td style="text-align:left;max-width: 100px; overflow: hidden;
										 white-space: nowrap; text-overflow: ellipsis;">${notice.title }</td>
							<td>
								<div class="row">
									<div class="col-sm-2"></div>
									<div class="col-sm-4" >
										<span class="person-info" data-id="${notice.writer }"></span>
									</div>
									<div class="col-sm-4 text-left">${notice.writer }</div>
									<div class="col-sm-2"></div>
								</div>
							</td>
							<td><fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd"/></td>
							<td><span class="badge bg-red">${notice.viewcnt }</span></td>
						  </tr>
						</c:forEach>
					</c:if>
					</tbody>	
				</table>
			</div>
			<div class="card-footer">
			<!-- pagination.jsp -->
				<div style="display:${not empty noticeList ? 'visible':'none' };">
					<%@ include file="/WEB-INF/views/module/pagination.jsp" %>	
				</div>	    			
	    	</div>			
		</div>
	</section>
  </div>






<script>
MemberPictureBackground("<%=request.getContextPath() %>");
</script>

<script>
$(".person-info").css({
	"display":"block",
	"width":"30px",
	"height":"30px",
	"border-radius":"10px"
});
$('#noticeTable td').css({
							"padding":"5px",
							"line-height":"40px"
						});
</script>

</body>




