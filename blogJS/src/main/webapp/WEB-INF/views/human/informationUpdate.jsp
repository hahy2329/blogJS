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
				
				return true;
				
			}
			else{
				alert("비밀번호를 다시 확인해주세요.");
				return false;
				
			}
			
		});
		
	});


</script>

</head>
<body>


	<!--================ Start Banner Area =================-->
    <section class="banner_area">
        <div class="banner_inner d-flex align-items-center">
            <div class="container">
                <div class="banner_content text-center">
                    <h2>개인정보수정</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">개인정보수정</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->
	
	    <!--================Contact Area =================-->
    <section class="contact_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <form class="row contact_form" action="${contextPath }/human/informationUpdate" method="post" enctype="multipart/form-data">
                        <div class="col-md-6">
                             <div class="form-group">
                                <input type="text" class="form-control" minlength="5" maxlength="15" id="humanId" name="humanId" placeholder="아이디를 입력해주세요." value="${humanDTO.humanId }" readonly="readonly">
                                <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력" required="required">
                            <div class="reply-btn" align="right">
                                        <input type="button" id="btnOverlappedPasswd" class="btn-reply text-uppercase" value="인증"> 
                            </div>
                            <p class="answer"></p>
                        	<div><!-- 비밀번호 -->
                        		<br>
                            </div>
                            	<input type="text" id="humanNm" name="humanNm" class="form-control" placeholder="이름을 입력해주세요." value="${humanDTO.humanNm }" required="required">
                            <div>
                            	<br>
                            </div>
                         	
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" placeholder="이미지 파일을 선택해주세요." readonly="readonly" value="${humanDTO.profile }">
                            	<input type="file" class="form-control" name="profile" value="파일 선택" required="required">	
                            	
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" placeholder="자기소개를 간단하게 부탁드립니다." readonly="readonly">
                                <textarea class="form-control" name="content" rows="1" required="required">${humanDTO.content }</textarea>
                            <div>
                            	<br>
                            </div>  
                            	<input type="email" name="email" id="email" class="form-control" placeholder="이메일을 입력해주세요." required="required" value="${humanDTO.email }">
                            </div>
                            <div>
                            	<br>
                            </div>
                           <div> 	
                               	<input type="text" class="form-control" value="생년월일을 선택해주세요." readonly="readonly">
                          	<div>
                            	<select id="birthY" class="form-control" required="required">
                            		<c:forEach var="i" begin="0" end="2023">
                            			<option>${2023-i }</option>
                            		</c:forEach>
                            	</select>
                            </div>	
                            <div>
                            	<select id="birthM" class="form-control" required="required">
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
                            	<select id="birthD" class="form-control" required="required">
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
                            <input type="hidden" name="birthDt"/>
                            </div>
                        </div>
                        <div class="col-md-12 text-right">
                            <button type="submit" value="submit" class="primary_btn">
                                <span>개인정보수정</span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!--================Contact Area =================-->
	
	



</body>
</html>