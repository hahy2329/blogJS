<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	var isValid = false;
	
	$().ready(function(){
		
		$("#btnOverlappedPasswd").click(function(){
			$(".answer").empty();
			
			var humanId = $("#humanId").val();
			var passwd = $("#passwd").val();
			
			if(passwd == ''){
				alert("비밀번호를 입력해주세요.");
				return;
			}
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/human/checkDuplicatedPasswd?passwd="+passwd+"&humanId="+humanId,
				success : function(data){
					
					if(data=="duplicate"){
						
						alert("확인되었습니다.");
						isValid = true;
						$("#btnOverlappedPasswd").remove();
						$(".answer").append("<p style='color: green;'>" + "확인되었습니다." +"</p>");
					}
					else{
						alert("비밀번호를 확인해주세요.");
						isValid = false;
						$(".answer").append("<p style='color: red;'>" +"비밀번호를 다시 확인해주세요." + "</p>");
						
					}
					
					
				}
				
			});
			
			
		});
		
		
			$("form").submit(function(){
			
				if(isValid == false){
				
					alert("비밀번호를 다시 확인해주세요.");
					return false;
				}
				if(isValid == true){
				
					return true;
				}
			
			});
		
		
	});



</script>
</head>
<body>

	    <section class="contact_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <form class="row contact_form" action="${contextPath }/blogReply/blogWriteReply" method="post" enctype="multipart/form-data">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" minlength="5" maxlength="15" id="humanId" name="humanId" placeholder="아이디를 입력해주세요." value="${sessionScope.humanId }" readonly="readonly">
                                <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력" required="required">
                            <div class="reply-btn" align="right">
                                <input type="button" id="btnOverlappedPasswd" class="btn-reply text-uppercase" value="인증"> 
                            </div>
                            <p class="answer"></p>
                            <div>
                            	<br><br>
                            </div>
                            	<input type="file" class="form-control" name="image" value="파일 선택">
                            	<input type="text" class="form-control" placeholder="자신을 표현 할 이미지를 선택해주세요." readonly="readonly">
                            <div>
                            	<br>
                            </div>
                                <textarea class="form-control" name="content" rows="1" placeholder="내용을 입력해주세요." required="required"></textarea>
                                <script>CKEDITOR.replace("content")</script>
                        </div>
                        		<input type="hidden" name="blogId" value="${blogId }">
                        <div class="col-md-12 text-right">
                            <button type="submit" value="submit" class="primary_btn">
                                <span>등록</span>
                            </button>
                      	</div>
                       </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

</body>
</html>