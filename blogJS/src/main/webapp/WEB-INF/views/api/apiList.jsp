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
	
	<!--================ Start Banner Area =================-->
    <section class="banner_area">
        <div class="banner_inner d-flex align-items-center">
            <div class="container">
                <div class="banner_content text-center">
                    <h2>API 리스트</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="portfolio.html">API 리스트</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->
    
    <!--================Start Portfolio Area =================-->
	<section class="portfolio_area section_gap_top" id="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="main_title text-left">
                        <h2>공공데이터를 활용한 API 리스트 목록 </h2>
                    </div>
                </div>
            </div>
            <div class="filters-content">
				<div class="row portfolio-grid justify-content-center">
					<div class="col-lg-4 col-md-6 all latest">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p1.jpg" alt="">
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIPharmacyTest01">건강보험심사평가원_약국정보(XML)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all popular">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p2.jpg" alt="">
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIPharmacyTest02">건강보험심사평가원_약국정보(파싱)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all latest">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p3.jpg" alt="">
								<div class="overlay"></div>
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIMidFcstTest01">기상청_중기예보(전국_XML)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all latest">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p3.jpg" alt="">
								<div class="overlay"></div>
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIMidFcstTest02">기상청_전국중기예보(전국_파싱)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all latest">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p3.jpg" alt="">
								<div class="overlay"></div>
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIPrecipitationTest01">기상청_강수확률 및 날씨예보(서울,경기,인천_XML)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all latest">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p3.jpg" alt="">
								<div class="overlay"></div>
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIDailynecessity01">한국소비자원_생필품가격정보(XML)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all latest">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p3.jpg" alt="">
								<div class="overlay"></div>
							</div>
							<div class="short_info">
								<h4><a href="${contextPath }/api/openAPIDailynecessity02">한국소비자원_생필품가격정보(파싱)</a></h4>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all following">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p8.jpg" alt="">
								<div class="overlay"></div>
								<a href="img/portfolio/p8.jpg" class="img-gal">
									<div class="icon">
										<span class="lnr lnr-cross"></span>
									</div>
								</a>
							</div>
							<div class="short_info">
								<h4>fly male</h4>
								<p>Animated, portfolio</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 all upcoming">
						<div class="portfolio_box">
							<div class="single_portfolio">
								<img class="img-fluid w-100" src="img/portfolio/p9.jpg" alt="">
								<div class="overlay"></div>
								<a href="img/portfolio/p9.jpg" class="img-gal">
									<div class="icon">
										<span class="lnr lnr-cross"></span>
									</div>
								</a>
							</div>
							<div class="short_info">
								<h4><a href="portfolio-details.html">season face</a></h4>
								<p>Animated, portfolio</p>
							</div>
						</div>
					</div>
				</div>
			</div>
        </div>
    </section>
    <!--================End Portfolio Area =================-->
	

</body>
</html>