<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	var validHumanId = false;
	var validEmail = false;
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	var pattern1 = /[0-9]/; 
	var pattern2 = /[a-zA-Z]/;
	var pattern3 = /[~!@\#$%<>^&*]/
	
	$().ready(function(){
		
		$("#btnOverlappedId").click(function(){
			
			var humanId = $("#humanId").val();
			
			if(humanId == ''){
				alert("ID를 입력하세요.");
				return;
			}
			
			
			if(humanId.search(/\s/) != -1){
				
				alert("공백은 허용할 수 없습니다.");
				return false;
			}//공백 체크
			if(special_pattern.test(humanId) == true) {
				alert("특수문자는 허용할 수 없습니다.");
				return false;
			}//특수문자 체크
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/human/overlappedId?humanId="+humanId,
				success : function(isOverlapped){
					
					if(isOverlapped == "NO"){
						alert("사용 할 수 있는 ID입니다.");
						validHumanId = true;
					}
					else{
						alert("사용 할 수 없는 ID입니다.");
						validHumanId = false;
					}
				}
			});
		});
		
		$("#btnOverlappedEamil").click(function(){
			
			var email = $("#email").val();
			
			if(email == ''){
				alert("이메일을 입력해주세요.");
				return;
				
			}	
			
			$.ajax({
				
				type:"get",
				url : "${contextPath}/human/overlappedEmail?email="+email,
				success : function(data){
					
					if(data=="true"){
						alert("사용 할 수 있는 이메일입니다.");
						validEmail = true;
					}
					else{
						alert("이미 사용중인 이메일입니다.");
						validEmail = false;
						
					}
				}
			});
			
		});
		$("form").submit(function(){
			
			if(validHumanId == false){
				alert("아이디를 확인해주세요.");
				return false;
			}
			
			if(validEmail == false){
				alert("이메일을 확인해주세요.");
				return false;
				
			}
			
			if($("#passwd").val()==''){
				alert("비밀번호를 입력해주세요.");
				return false;
			}
			
			if(validHumanId == true && validEmail == true){
				if($("#passwd").val() == $("#confirmPasswd").val()){
					if(!pattern1.test($("#passwd").val())||!pattern2.test($("#passwd").val())||!pattern3.test($("#passwd").val())||$("#passwd").val().length<8||$("#passwd").val().length>50){
						
						alert("영문+숫자+특수기호를 포함한 8자리 이상으로 구성하여야 합니다.");
						return false;
					}
					else{
						
						$("[name='birthDt']").val($("#birthY").val() + "-" + $("#birthM").val()+"-" + $("#birthD").val());
						return true;
						alert("회원가입을 요청중 입니다.");
					}
					
					
					
				}
				
				else{
					
					alert("비밀번호를 다시 확인해주세요.");
					return false;
					
				}
				
				
			}
			
			
		});
		
		
		
	});


</script>

</head>
<body>
	
	    <!--================Contact Area =================-->
    <section class="contact_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <form class="row contact_form" action="${contextPath }/human/register" method="post" enctype="multipart/form-data">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" minlength="5" maxlength="15" id="humanId" name="humanId" placeholder="아이디를 입력해주세요." required="required">
                            <div class="reply-btn" align="right">
                                        <input type="button" id="btnOverlappedId" class="btn-reply text-uppercase" value="중복확인"> 
                            </div> <!-- 아이디 중복확인 -->
                                <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력" required="required">
                                <input type="password"  id="confirmPasswd" class="form-control" placeholder="비밀번호 재입력" required="required">
                        	<div><!-- 비밀번호 -->
                        		<br>
                            </div>
                            	<input type="text" id="humanNm" name="humanNm" class="form-control" placeholder="이름을 입력해주세요." required="required">
                            <div>
                            	<br>
                            </div>
                         	
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" placeholder="이미지 파일을 선택해주세요." readonly="readonly">
                            	<input type="file" class="form-control" name="profile" value="파일 선택" required="required">	
                            	
                            <div>
                            	<br>
                            </div>
                                <textarea class="form-control" name="content" rows="1" placeholder="가입인사를 적어주세요." required="required"></textarea>
                            <div>
                            	<br>
                            </div>  
                            	<input type="email" name="email" id="email" class="form-control" placeholder="이메일을 입력해주세요." required="required"> 
                                
                            </div>
                            <div class="reply-btn" align="right">
                                        <input type="button" id="btnOverlappedEamil" class="btn-reply text-uppercase" value="중복확인"> 
                            </div>
                            <div>
                            	<br>
                            </div>
                            
                               	<input type="text" class="form-control" value="생년월일을 선택해주세요." readonly="readonly">
                           <div> 	
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
                                <span>회원가입</span>
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