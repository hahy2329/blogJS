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
	
	
	
	
	<!--================ Start Header Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="${contextPath }/"><img src="${contextPath }/resources/satner-master/img/logo.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav justify-content-end">
							<li class="nav-item active"><a class="nav-link" href="${contextPath }/">Home</a></li>
							<c:if test="${sessionScope.humanId ne null or sessionScope.userId ne null }">
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">경력 관리</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="${contextPath }/career/careerManagement">나의 경력</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/career/careerWrite">글쓰기</a></li>
								</ul>
							</li>
							<li class="nav-item"><a class="nav-link" href="${contextPath }/api/apiList">REST API서비스(연습)</a></li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">포트폴리오 관리</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="${contextPath }/portfolio/portfolioTopic">나의 포트폴리오</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/portfolio/portfolioWrite">글쓰기</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">Blog</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="${contextPath }/blog/blogStudy">개발공부</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/blog/blogDayTime">소소한 일상</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath}/blog/blogTodayKeyword">오늘의 키워드</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/blog/blogTravel">여행</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/blog/blogWrite">블로그 작성</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">개인정보</a>
								 <ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="${contextPath }/human/informationUpdate?humanId=${sessionScope.humanId}">개인정보수정</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/human/passwordChange?humanId=${sessionScope.humanId}">비밀번호변경</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/human/humanDelete?humanId=${sessionScope.humanId}">회원탈퇴</a></li>
								</ul>
							</li>
							</c:if>
							<c:if test="${sessionScope.humanId eq null and sessionScope.userId eq null}">
								<li class="nav-item"><a class="nav-link" href="${contextPath }/human/login">login</a></li>
								<li class="nav-item"><a class="nav-link" href="${contextPath }/human/register">register</a></li>
							</c:if>
								<c:if test="${sessionScope.humanId ne null }">
									<li class="nav-item"><a class="nav-link">${sessionScope.humanId }님 로그인</a></li>
									<li class="nav-item"><a class="nav-link" href="${contextPath }/human/logout">로그아웃</a></li>
								</c:if>
								<c:if test="${sessionScope.userId ne null }">
									<li class="nav-item"><a class="nav-link">${sessionScope.userId }님 로그인</a></li>
									<li class="nav-item"><a class="nav-link" href="http://localhost:8080/blogJS/logout">로그아웃</a></li>
								</c:if>	
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Area =================-->
	
	
</body>
</html>