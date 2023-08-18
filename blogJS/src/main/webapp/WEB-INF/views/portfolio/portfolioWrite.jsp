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
				
				if(data =="duplicate"){
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
			$("[name='makeDt']").val($("#makeY").val() + "-" + $("#makeM").val() + "-" + $("#makeD").val());
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
                    <form class="row contact_form" action="${contextPath }/portfolio/portfolioWrite" method="post" enctype="multipart/form-data">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" minlength="5" maxlength="15" id="humanId" name="humanId" placeholder="아이디를 입력해주세요." value="${sessionScope.humanId }" readonly="readonly">
                                <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력" required="required">
                            <div class="reply-btn" align="right">
                                        <input type="button" id="btnOverlappedPasswd" class="btn-reply text-uppercase" value="인증"> 
                            </div>
                            <p class="answer"></p>
                        	<div>
                        		<br>
                            </div>
                            	<input type="text" id="subject" name="subject" class="form-control" placeholder="제목을 입력해주세요." required="required">
                            <div>
                            	<br>
                            </div>
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" value="포트폴리오 사진을 올려주세요." readonly="readonly">
                            	<input type="file" class="form-control" name="image" value="파일 선택">
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" value="포트폴리오 관련 간단하게 설명 부탁드립니다." readonly="readonly">
                                <textarea class="form-control" name="content" rows="1" placeholder="내용을 입력해주세요." required="required"></textarea>
                                <script>CKEDITOR.replace("content")</script>
                            <div>
                            	<br>
                            </div>
                            <div>
                            	<br>
                            </div>
                           		  	<input type="text" class="form-control" value="프로젝트 완성날짜를 선택해주세요." readonly="readonly">
                           <div> 	
                          	<div>
                            	<select id="makeY" class="form-control" required="required">
                            		<c:forEach var="i" begin="0" end="2023">
                            			<option>${2023-i }</option>
                            		</c:forEach>
                            	</select>
                            </div>	
                            <div>
                            	<select id="makeM" class="form-control" required="required">
                            		<c:forEach var="i" begin="1" end="12">
                            			<c:choose>
                            				<c:when test="${i<10 }">
                            					<option>0${i }</option>
                            				</c:when>
                            				<c:otherwise>
                            					<option>${i }</option>
                            				</c:otherwise>
                            			</c:choose>
                            		</c:forEach>
                            	</select>
                            </div>
                            <div>
                            	<select id="makeD" class="form-control" required="required">
                            		<c:forEach var="i" begin="1" end="31">
                            			<c:choose>
                            				<c:when test="${i<10 }">
                            					<option>0${i }</option>
                            				</c:when>
                            				<c:otherwise>
                            					<option>${i }</option>
                            				</c:otherwise>
                            			</c:choose>
                            		</c:forEach>
                            	</select>
                            </div>
                            <input type="hidden" name="makeDt"/>
                            </div>
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" value="프로젝트의 유형을 선택해주세요." readonly="readonly">
                            	<input type="radio" id="sort" name="sort" value="web">웹
                               	<input type="radio" id="sort" name="sort" value="app">앱
                             <div>
                             	<br> 
                             </div>
                             	<input type="text" class="form-control" value="프로젝트의 인원을 숫자로 입력해주세요." readonly="readonly">
                             	<input type="text" class="form-control" name="numberPeople" required="required">&nbsp;
                             	<input type="text" class="form-control" value="프로젝트 만든이를 입력해주세요." readonly="readonly">
                             	<input type="text" class="form-control" name="madePeople" required="required">
                             <div>
                             	<br>
                             </div>
                             	<input type="text" class="form-control" value="프로젝트의 완성도를 1~5까지 입력해주세요." readonly="readonly">
                             	<select id="complete" name="complete" class="form-control" required="required">
                             		<c:forEach var="i" begin="1" end="5">
                             			<option>${i }</option>
                             		</c:forEach>
                             	</select>
                        </div>
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