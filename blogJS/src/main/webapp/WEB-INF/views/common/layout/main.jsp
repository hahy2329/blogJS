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

<!--================ Start Home Banner Area =================-->
	<section class="home_banner_area">
		<div class="banner_inner">
			<div class="container">
				<div class="row">
					<div class="col-lg-7">
						<div class="banner_content">
							<h3 class="text-uppercase">Hell0</h3>
							<h1 class="text-uppercase">I am HanJuseok</h1>
							<h5 class="text-uppercase">Beginner developer</h5>
							<div class="d-flex align-items-center">
								<a class="primary_btn" href="#"><span>Hire Me</span></a>
								<a class="primary_btn tr-bg" href="#"><span>Get CV</span></a>
							</div>
						</div>
					</div>
					<div class="col-lg-5">
						<div class="home_right_img">
							<img class="" src="${contextPath }/resources/satner-master/img/banner/home-right.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
<!--================ End Home Banner Area =================-->
<!--================ Start About Us Area =================-->
	<section class="about_area section_gap">
		<div class="container">
			<div class="row justify-content-start align-items-center">
				<div class="col-lg-5">
					<div class="about_img">
						<img class="" src="${contextPath }/resources/satner-master/img/about-us.png" alt="">
					</div>
				</div>

				<div class="offset-lg-1 col-lg-5">
					<div class="main_title text-left">
						<h2>나의 소개</h2>
						<p>
							안녕하세요. 저의 블로그에 방문해 주셔서 감사합니다. 저는 서울에 거주하고 있는 백엔드 개발자 입문중인 한주석이라고 합니다.  
						</p>
						<p>
							개발을 하면서 주로 사용하는 스킬은 HTML5, CSS3, Javascript, Jquery, Java, JSP, Spring Framework, Mybatis등이 있으며, 계속해서 스프링을 활용한 여러 프로젝트를 개발중입니다. 글을 읽어주셔서 감사합니다.
						</p>
						<a class="primary_btn" href="#"><span>Download CV</span></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ End About Us Area =================-->
	
<!--================ Start Features Area =================-->
	<section class="features_area">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 text-center">
					<div class="main_title">
						<h2>카테고리 </h2>
					</div>
				</div>
			</div>
			<div class="row feature_inner">
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<img src="${contextPath }/resources/satner-master/img/services/shapoo.png" alt="">
						<h4>오늘의 공부</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<img src="${contextPath }/resources/satner-master/img/services/today.png" alt="">
						<h4>소소한 일상</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<img src="${contextPath }/resources/satner-master/img/services/travel.png" alt="">
						<h4>여행</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<img src="${contextPath }/resources/satner-master/img/services/keyword.png" alt="">
						<h4>오늘의 핵심단어</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ End Features Area =================-->

	
	
	

</body>
</html>