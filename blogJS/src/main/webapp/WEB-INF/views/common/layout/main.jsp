<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<h2>블로그 </h2>
					</div>
				</div>
			</div>
			<div class="row feature_inner">
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<a href="${contextPath }/blog/blogStudy"><img src="${contextPath }/resources/satner-master/img/services/shapoo.png" alt=""></a>
						<h4>개발공부</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<a href="${contextPath }/blog/dayTime"><img src="${contextPath }/resources/satner-master/img/services/today.png" alt=""></a>
						<h4>소소한 일상</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<a href="${contextPath }/blog/travel"><img src="${contextPath }/resources/satner-master/img/services/travel.png" alt=""></a>
						<h4>여행</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="feature_item">
						<a href="${contextPath}/blog/todayKeyword"><img src="${contextPath }/resources/satner-master/img/services/keyword.png" alt=""></a>
						<h4>오늘의 키워드</h4>
						<p>Creeping for female light years that lesser can't evening heaven isn't bearing tree</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ End Features Area =================-->
	<section class="portfolio_area section_gap_top" id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="main_title text-left">
                        <h2>나의 포트폴리오</h2>
                    </div>
                </div>
            </div>
            <div class="filters portfolio-filter">
                <ul>
                    <a href="${contextPath }/portfolio/portfolioTopic"><li class="active" data-filter="*">all</li></a>
                    <a href="${contextPath }/portfolio/webPortfolio"><li data-filter=".popular">web</li></a>
                    <a href="${contextPath }/portfolio/appPortfolio"><li data-filter=".latest"> app</li></a>
                </ul>
            </div>
    
            <div class="filters-content">
				<div class="row portfolio-grid justify-content-center">
					<c:choose>
					<c:when test="${portfolioList ne null }">
					<c:forEach var="portfolioDTO" items="${portfolioList }">
						<div class="col-lg-4 col-md-6 all latest">
							<div class="portfolio_box">
								<div class="single_portfolio">
									<img class="img-fluid w-100" src="${contextPath }/portfolio/portfolioImage?image=${portfolioDTO.image}" width="375" height="325" alt="포트폴리오 사진">
									<div class="overlay"></div>
									<a href="${contextPath }/portfolio/portfolioDetail" class="img-gal">
										<div class="icon">
											<span class="lnr lnr-cross"></span>
										</div>
									</a>
								</div>
								<div class="short_info">
									<h4><a href="portfolio-details.html">${portfolioDTO.subject }</a></h4>
									<p>${portfolioDTO.humanId }, <fmt:formatDate value="${portfolioDTO.makeDt }" pattern="yyyy-MM-dd"/></p>
								</div>
							</div>
						</div>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<strong><h3>조회된 내역이 없습니다.</h3></strong>
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
    </section>
	
	
	

</body>
</html>