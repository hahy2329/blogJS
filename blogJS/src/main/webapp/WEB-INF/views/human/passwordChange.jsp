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
	
	var pattern1 = /[0-9]/;

    var pattern2 = /[a-zA-Z]/;

    var pattern3 = /[~!@\#$%<>^&*]/;
	
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
				if($("#changePasswd").val() == $("#confirmPasswd").val()){
					if(!pattern1.test($("#changePasswd").val())||!pattern2.test($("#changePasswd").val())||!pattern3.test($("#changePasswd").val())||$("#changePasswd").val().length<8||$("#changePasswd").val().length>50){
						
						alert("영문+숫자+특수기호를 포함하여 8자리 이상으로 구성하여야 합니다.");
						return false;
					}
					
					else{
						return true;
						
					}
				}
				else{
					alert("변경하실 비밀번호를 다시 확인해주세요.");
					return false;
				}
				
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
                    <h2>비밀번호 변경</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">비밀번호 변경</a>
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
                    <form class="row contact_form" action="${contextPath }/human/passwordChange" method="post" enctype="multipart/form-data">
                        <div class="col-md-6">
                             <div class="form-group">
                                <input type="text" class="form-control" minlength="5" maxlength="15" id="humanId" name="humanId" placeholder="아이디를 입력해주세요." value="${humanDTO.humanId }" readonly="readonly">
                                <input type="password" class="form-control" id="passwd" name="passwd" placeholder="현재 사용중인 비밀번호를 입력해주세요." required="required">
                            <div class="reply-btn" align="right">
                                <input type="button" id="btnOverlappedPasswd" class="btn-reply text-uppercase" value="인증"> 
                            </div>
                            <p class="answer"></p>
                            <div>
                            	<br>
                            </div>
                            <div>
                            	<input type="password" class="form-control" id="changePasswd" name="changePasswd" placeholder="변경하실 비밀번호를 입력해주세요." required="required">
                            	<input type="password" class="form-control" id="confirmPasswd" placeholder="변경하실 비밀번호를 한 번더 입력 부탁드립니다." required="required">
                            </div>
		                        <div class="col-md-12 text-right">
		                            <button type="submit" value="submit" class="primary_btn">
		                                <span>비밀번호 변경</span>
		                            </button>
		                        </div>
                       	 	</div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!--================Contact Area =================-->
	
	



</body>
</html>