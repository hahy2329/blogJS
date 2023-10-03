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
                    <h2>나의 경력</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">나의 경력</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->


<!--================ Start Features Area =================-->
	<section class="features_area section_gap_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 text-center">
                    <div class="main_title">
                        <h2>경력사항 </h2>
                        <p>실무 경험이 있는 날짜 순으로 나열하였습니다.</p>
                    </div>
                </div>
            </div>
            <div class="row feature_inner">
            	<c:forEach var="careerDTO" items="${careerList }">
                 <div class="col-lg-3 col-md-6">
                    <div class="feature_item">
                        <img src="img/services/s1.png" alt="">
                        <h4>${careerDTO.humanId }</h4>
                        	<ul class="list">
	                        	<li><span><strong>회사 이름</strong></span>: ${careerDTO.companyName }</li>
	                            <li><span><strong>직무</strong></span>: ${careerDTO.department }</li>	
	                            <li><span><strong>근무 기간</strong></span>: ${careerDTO.period }</li>
	                            <li><span><strong>사용 스킬</strong></span>: ${careerDTO.skill }</li>
	                            <li><span><strong>입사 날짜</strong></span>: <fmt:formatDate value="${careerDTO.joinDate }" pattern="yyyy-MM-dd" /></li>
	                            <li><span><strong>퇴사 날짜</strong></span>: <fmt:formatDate value="${careerDTO.resignationDate }" pattern="yyyy-MM-dd" /></li>
                            </ul>
                    </div>
                    <div class="short_info">
						<a href="${contextPath }/career/careerUpdate?careerId=${careerDTO.careerId}" class="primary_btn"><span>수정하기</span></a>
						<br><br>
                        <a href="${contextPath }/career/careerDelete?careerId=${careerDTO.careerId}" class="primary_btn"><span>삭제하기</span></a>
					</div>
                 </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <!--================ End Features Area =================-->

	<!--================ Start Testimonial Area =================-->
	<div class="testimonial_area section_gap_bottom">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 text-center">
                    <div class="main_title">
                        <h2>client say about me</h2>
                        <p>Is give may shall likeness made yielding spirit a itself togeth created after sea is in beast <br>
                                beginning signs open god you're gathering ithe</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--================ End Testimonial Area =================-->
    
    
</body>
</html>