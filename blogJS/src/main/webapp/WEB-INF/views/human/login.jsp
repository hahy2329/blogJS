<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  	
  	<section class="contact_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <form class="row contact_form" action="${contextPath }/human/login" method="post">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" minlength="5" maxlength="15" id="humanId" name="humanId" placeholder="아이디를 입력해주세요." required="required">
  								<input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력" required="required">
  							</div>
  							<div class="col-md-12 text-right">
                            	<button type="submit" value="submit" class="primary_btn">
                                	<span>로그인</span>
                            	</button>
                            	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=9291681c4b5f1c251ec456e619d7f1ed&redirect_uri=http://localhost:8080/blogJS/login">
                            		<img src="${contextPath }/resources/satner-master/img/kakao_login.png">
                            	</a>
                        	</div>
  						</div>
  					</form>
  				</div>
  			</div>
  		</div>
  	</section>
  					
  	
</body>
</html>