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
                    <h2>포트폴리오 상세정보</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">포트폴리오 상세정보</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->

	<!--================Start Portfolio Details Area =================-->
	<section class="portfolio_details_area section_gap">
        <div class="container">
            <div class="portfolio_details_inner">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="left_img">
                            <img class="img-fluid" src="${contextPath }/portfolio/portfolioDetailImg?image=${portfolioDTO.image}" width="570" height="520" alt="">
                        </div>
                    </div>
                    <div class="offset-lg-1 col-lg-5">
                        <div class="portfolio_right_text mt-30">
                            <h4 class="text-uppercase">${portfolioDTO.subject }</h4>
                            <ul class="list">
                            	<c:if test="${portfolioDTO.complete eq 1 }">
                                <li><span>만족도</span>: <i class="fa fa-star"></i></li>
                                </c:if>
                                <c:if test="${portfolioDTO.complete eq 2 }">
                                <li><span>만족도</span>: <i class="fa fa-star"></i><i class="fa fa-star"></i></li>
                                </c:if>        
                                <c:if test="${portfolioDTO.complete eq 3 }">
                                <li><span>만족도</span>: <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></li>
                                </c:if>        
                                <c:if test="${portfolioDTO.complete eq 4 }">
                                <li><span>만족도</span>: <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></li>
                                </c:if>        
                                <c:if test="${portfolioDTO.complete eq 5 }">
                                <li><span>만족도</span>: <i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star">
                                </i></li>
                                </c:if>        
                                <li><span>만든이</span>: ${portfolioDTO.madePeople }</li>
                                <li><span>투입 인원</span>: ${portfolioDTO.numberPeople }</li>
                                <li><span>분류</span>: ${portfolioDTO.sort }</li>
                                <li><span>만든 날짜</span>: <fmt:formatDate value="${portfolioDTO.makeDt }"/></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <p>${portfolioDTO.content }</p>
            </div>
        </div>
    </section>
    <!--================End Portfolio Details Area =================-->
	
</body>
</html>