<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>allBoard</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <script src="/egovproject/webjars/jquery/3.6.0/jquery.min.js"></script>
  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">


<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
    $(document).ready(function(){
    	let allBoardCount = ${allBoardCount};
    	
    	for(var i = 0; i < allBoardCount; i++){
    		(function(i){
			$("#oneboardBTN" + i).on("click", function(){
				let oneboardId = $("#oneboardId" + i).val();
				
				$.ajax({
					type: "POST",
					url: "/egovproject/oneboard.do",
					dataType: "json",
					data: {
						'oneboardId' : oneboardId
					},
					
					success: function(res){
						let boardTitle = res.responseEntity.body.title; 
						let boardContents = res.responseEntity.body.contents;
						let boardJob = res.responseEntity.body.job;
					
						
						// responseEntity 응답형식 ( JSON.stringify(res)해서 확인 )
						// .headers/.body/.statusCode/.statusCodeValue
						
						console.log(res.responseEntity.statusCode);				
						console.log(res.responseEntity.statusCodeValue);				
				
						
						// 다시 click 시 제거 
						if($("#oneboardRes" + oneboardId).html() != ''){
							$("#oneboardRes" + oneboardId).html('');
							return false;
						}
						
						$("#oneboardRes" + oneboardId).html(boardTitle);
						$("#oneboardRes" + oneboardId).append('<br> 내용 : ' + boardContents);
						$("#oneboardRes" + oneboardId).append('<br><button type="button" id="editbtn' + oneboardId + '">수정하기</button>');

						// 동적 태그에 이벤트 생성
						$("#oneboardRes" + oneboardId).on("click", "button", function(){
							
							//create element (form)
							var newForm = $('<form></form>');
							
							//set attribute (form) 
							newForm.attr("method","post");
							newForm.attr("action","/egovproject/" + oneboardId + "/updateboard.do");
							
							// create element & set attribute (input) 
							newForm.append($('<input/>', {type: 'text', name: 'title', value:boardTitle }));
							newForm.append($('<input/>', {type: 'text', name: 'contents', value:boardContents }));
							newForm.append($('<input/>', {type: 'submit', value:'등록' }));

							// append form (to body) 
							newForm.appendTo("#oneboardEdit" + oneboardId);

							// submit form
							//newForm.submit();
	    				});
						
					} //success
				}) // ajax 
	    	}); // onclick  
    		})(i); // for function(i) 
  	 	} // for 
    }); // onload 
  </script>
</head>
<body>

<jsp:include page="/WEB-INF/views/navbar.jsp"/>

<c:forEach items="${allBoard }" var="eachboard" varStatus="vs">
<hr>
${eachboard.job } <br> 

	<div id="oneboardBTN${vs.index}" style="cursor:pointer; font-size:20px; color:orange;">${eachboard.title }</div>
		<input id="oneboardId${vs.index}" type="button" value= ${eachboard.id } style="display:none">
	<div id="oneboardRes${eachboard.id }"></div>

	<div id="oneboardEdit${eachboard.id }"></div>

<hr>
</c:forEach>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>