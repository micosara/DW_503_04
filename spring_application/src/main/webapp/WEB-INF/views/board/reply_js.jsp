<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
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
            style="display:{{VisibleByLoginCheck replyer}};"
             data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">Modify</a>
        </span>
   
        <h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
        <div class="timeline-body" id="{{rno}}-replytext">{{replytext}} </div>
   </div>
</div>

{{/each}}
</script>


<script>

	$.ajax({
		url:"<%=request.getContextPath()%>/reply/list?page=1&bno=22543",
		method:"get",
		success:function(data){
			console.log(data);
		}
	});
</script







>