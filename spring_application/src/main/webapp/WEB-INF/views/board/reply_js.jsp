<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Modal -->
<div id="modifyModal" class="modal modal-default fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" style="display:none;"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="replytext" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn" onclick="replyModify_go();">Modify</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn" onclick="replyRemove_go();">DELETE</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>  
    
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.8/handlebars.min.js"></script>
<script type="text/x-handlebars-template"  id="reply-list-template" >
{{#each .}}  
<div class="replyLi" >
   <div class="user-block">
      <img src="<%=request.getContextPath()%>/member/getPicture?id={{replyer}}" class="img-circle img-bordered-sm"/>
    </div>   
   <div class="timeline-item" >
        <span class="time">
          <i class="fa fa-clock"></i>{{prettifyDate regdate}}
          <a class="btn btn-primary btn-xs {{rno}}-a" id="modifyReplyBtn" data-rno={{rno}} onclick="replyModifyModal_go('{{rno}}');"            
            
             data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">Modify</a>
        </span>
   
        <h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
        <div class="timeline-body" id="{{rno}}-replytext">{{replytext}} </div>
   </div>
</div>

{{/each}}
</script>

<script type="text/x-handlebars-template"  id="reply-pagination-template" >
   <li class="page-item">
      <a class="page-link" href="{{goPage 1}}">
         <i class="fas fa-angle-double-left"></i>
      </a>
   </li>
   <li class="page-item">
      <a class="page-link" href="{{#if prev}}{{goPage prevPageNum}}{{else}}{{goPage 1}}{{/if}}">
         <i class="fas fa-angle-left"></i>
      </a>                  
   </li>
   {{#each pageNum}}
      <li class="paginate_button page-item {{signActive this}} ">
         <a href="{{goPage this}}" aria-controls="example2" data-dt-idx="1" tabindex="0" class="page-link">{{this}}</a>
      </li>
   {{/each}}
   <li class="page-item">
      <a class="page-link" href="{{#if next}}{{goPage nextPageNum}}{{else}}{{goPage realEndPage}}{{/if}}">
         <i class="fas fa-angle-right"></i>
      </a>                  
   </li>
   <li class="page-item">
      <a class="page-link" href="{{goPage realEndPage}}">
         <i class="fas fa-angle-double-right"></i>
      </a>
   </li>
</script>
<script>

Handlebars.registerHelper({
	 "prettifyDate":function(timeValue){ 
		 var dateObj=new Date(timeValue);
         var year=dateObj.getFullYear();
         var month=dateObj.getMonth()+1;
         var date=dateObj.getDate();
         return year+"/"+month+"/"+date;
	 },
     "goPage":function(pageNum){
          return 'javascript:getPage('+pageNum+');';
      },
      "signActive":function(pageNum){
          if(pageNum == currentPage) return 'active';
      }
});

var reply_list_func = Handlebars.compile($("#reply-list-template").html());
var pagination_func = Handlebars.compile($("#reply-pagination-template").html());	

</script>

<script>
getPage(1);

var currentPage = 1;

function getPage(page){
	
	$.ajax({
		url:"<%=request.getContextPath()%>/reply/list?page="+page+"&bno=${board.bno}",
		method:"get",
		success:function(data){
			//console.log(data);
			let reply_html = reply_list_func(data.replyList);
			$('.replyLi').remove();
		    $('#repliesDiv').after(reply_html);
		    
   			if(page) currentPage = page;
		    
		    let pageMaker = data.pageMaker;
		    
		    let pageNumArray = new Array(pageMaker.endPage-pageMaker.startPage+1);
		    
		    for(let i=pageMaker.startPage;i<pageMaker.endPage+1;i++){
		       pageNumArray[i-pageMaker.startPage]=i;
		    }   
		     
		    pageMaker.pageNum=pageNumArray;  
		    pageMaker.prevPageNum=pageMaker.startPage-1;
		    pageMaker.nextPageNum=pageMaker.endPage+1;
		    
		    let pagination_html = pagination_func(pageMaker);
		    $("#pagination").html(pagination_html);  
		}
	});
}
</script>
<script>
function replyRegist_go(){
	let replytext=$('#newReplyText').val();
	//alert(replytext);
	
	 var data={
         "bno":"${board.bno}",
         "replyer":"mama", // "${loginUser.id}"
         "replytext":replytext         
   		 }
	 
	 $.ajax({
	      url:"<%=request.getContextPath()%>/reply/regist",
	      method:"post",
	      data:JSON.stringify(data),      
	      contentType:'application/json',
	      success:function(data){
	    	  currentPage=data; //페이지이동
	    	  getPage(data);
	    	  $('#newReplyText').val("");   
	      },
	      error:function(error){
			alert("댓글 등록이 불가합니다.");
		  }
  }); 
}
</script>

<script>
function replyModifyModal_go(rno){
	//alert(rno);
	//alert($("div#"+rno+"-replytext").text());
	$('#replytext').val($('div#'+rno+'-replytext').text());
	$('h4.modal-title').text(rno);
}

function replyModify_go(){
	//alert("click reply modify btn");
	let rno=$('h4.modal-title').text();
	let replytext=$('#replytext').val();
	
    let sendData={
         "rno":rno,
         "replytext":replytext
    }
    $.ajax({
	      url:"<%=request.getContextPath()%>/reply/modify",
	      method:"PUT",
	      data:JSON.stringify(sendData),
	      contentType:"application/json",
	      headers:{         
	         "X-HTTP-Method-Override":"PUT"
	      },
	      success:function(result){
	         alert("수정되었습니다.");         
	         getPage(currentPage);
	      },
	      error:function(error){
				alert("댓글 수정이 불가합니다.");
		  },
	      complete:function(){
	          $('button[data-dismiss="modal"]').click();
	       }
 	});
    
    
	   
}

function replyRemove_go(){
	//alert("click reply remove");
	let rno=$('h4.modal-title').text();
	
	$.ajax({
	      url:"<%=request.getContextPath()%>/reply/remove?rno="+rno+"&page="+currentPage+"&bno=${board.bno}",
	      type:"delete",
	      headers:{"X-HTTP-Method-Override":"DELETE"},
	      success:function(page){
	    	  alert("삭제되었습니다.");
	          currentPage=page;
	          getPage(page);
	      },
	      error:function(error){
			alert("현재 댓글 삭제가 불가합니다.");
		  },
	      complete:function(){
	    	  $('button[data-dismiss="modal"]').click();
	       }
		});
}
</script>



