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
		var passwd  = $("#passwd").val();
		
		if(passwd ==''){
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
			$("[name='joinDate']").val($("#joinY").val() + "-" + $("#joinM").val() + "-" + $("#joinD").val());
			$("[name='resignationDate']").val($("#resignationY").val() + "-" + $("#resignationM").val() + "-" + $("#resignationD").val());
			return true;
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
                    <h2>경력 작성</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">경력 작성</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->
	<section class="contact_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <form class="row contact_form" action="${contextPath }/career/careerWrite" method="post" enctype="multipart/form-data">
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
                            	<input type="text" id="companyName" name="companyName" class="form-control" placeholder="회사명을 입력해주세요." required="required">
                            <div>
                            	<br>
                            </div>
                            	<input type="text" id="department" name="department" class="form-control" placeholder="부서명을 입력해주세요." required="required">
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" placeholder="근무 기간(숫자+개월,년)을 입력해주세요." readonly="readonly">
                             	<input type="text" class="form-control" name="period" required="required">&nbsp;
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" placeholder="입사 날짜를 선택해주세요." readonly="readonly">
                           <div> 	
                          	<div>
                            	<select id="joinY" class="form-control" required="required">
                            		<c:forEach var="i" begin="0" end="2023">
                            			<option>${2023-i }</option>
                            		</c:forEach>
                            	</select>
                            </div>	
                            <div>
                            	<select id="joinM" class="form-control" required="required">
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
                            	<select id="joinD" class="form-control" required="required">
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
                            <input type="hidden" name="joinDate"/>
                            </div>
                            <div>
                            	<br>
                            </div>
                            	<input type="text" class="form-control" placeholder="퇴사 날짜를 선택해주세요." readonly="readonly">
                            <div> 	
                          	<div>
                            	<select id="resignationY" class="form-control" required="required">
                            		<c:forEach var="i" begin="0" end="2023">
                            			<option>${2023-i }</option>
                            		</c:forEach>
                            	</select>
                            </div>	
                            <div>
                            	<select id="resignationM" class="form-control" required="required">
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
                            	<select id="resignationD" class="form-control" required="required">
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
                            <input type="hidden" name="resignationDate"/>
                            </div>
                            <div>
                            	<br>
                            </div>
                             	<input type="text" class="form-control" placeholder="회사에서 사용한 기술을 입력해주세요." readonly="readonly">
                             	<input type="text" class="form-control" id="skill" name="skill" required="required">
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