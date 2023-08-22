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
	
	<!--================ Start Banner Area =================-->
    <section class="banner_area">
        <div class="banner_inner d-flex align-items-center">
            <div class="container">
                <div class="banner_content text-center">
                    <h2>포트폴리오(전체)</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">포트폴리오(전체)</a>
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
                        <h2>나의 포트폴리오</h2>
                    </div>
                </div>
            </div>
            <div class="filters portfolio-filter">
                <ul>
                    <a href="${contextPath }/portfolio/portfolioTopic"><li class="active" data-filter="*">all</li></a>
                    <a href="${contextPath }/portfolio/webPortfolio"><li data-filter=".popular">web</li></a>
                    <li data-filter=".latest"> app</li>
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
    <!--================End Portfolio Area =================-->
    
	
	
</body>
</html>