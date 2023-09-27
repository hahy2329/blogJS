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
                    <h2>개발 공부</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">개발 공부</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->

	
	 <!--================Blog Categorie Area =================-->
    <section class="blog_categorie_area section_gap_top">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="categories_post">
                        <img src="${contextPath }/resources/satner-master/img/blog/cat-post/cat-post-3.jpg" alt="post">
                        <div class="categories_details">
                            <div class="categories_text">
                                <a href="${contextPath }/blog/dayTime"><h5>소소한 일상</h5></a>
                                <div class="border_line"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="categories_post">
                        <img src="${contextPath }/resources/satner-master/img/blog/cat-post/cat-post-2.jpg" alt="post">
                        <div class="categories_details">
                            <div class="categories_text">
                                <a href="${contextPath}/blog/todayKeyword"><h5>오늘 하루 핵심 키워드</h5></a>
                                <div class="border_line"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="categories_post">
                        <img src="${contextPath }/resources/satner-master/img/blog/cat-post/cat-post-1.jpg" alt="post">
                        <div class="categories_details">
                            <div class="categories_text">
                                <a href="${contextPath }/blog/travel"><h5>여행</h5></a>
                                <div class="border_line"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Categorie Area =================-->
    <!--================Blog Area =================-->
    <section class="blog_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="blog_left_sidebar">
                      <c:forEach var="blogStudy" items="${blogStudy }">
                        <article class="row blog_item">
                            <div class="col-md-3">
                                <div class="blog_info text-right">
                                    <div class="post_tag">
                                        <a href="#">${blogStudy.sort }</a>
                                    </div>
                                    <ul class="blog_meta list">
                                        <li><a href="#">${blogStudy.humanId }<i class="lnr lnr-user"></i></a></li>
                                        <li><a href="#"><fmt:formatDate value="${blogStudy.enrollDt }" pattern="yyyy-MM-dd"/><i class="lnr lnr-calendar-full"></i></a></li>
                                        <li><a href="#">${blogStudy.readCnt }<i class="lnr lnr-eye"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="blog_post">
                                	<c:if test="${blogStudy.picture1 ne null }">
                                    	<img src="${contextPath }/blog/thumbnails?picture1=${blogStudy.picture1}" width="555" height="280" alt="메인사진">
                                    </c:if>
                                    <div class="blog_details">
                                        <a href="${contextPath }/blog/blogStudyDetail?blogId=${blogStudy.blogId}&humanId=${blogStudy.humanId}"><h2>${blogStudy.subject }</h2></a>
                                        <a href="${contextPath }/blog/blogStudyUpdate?blogId=${blogStudy.blogId}" class="primary_btn"><span>수정하기</span></a>
                                    	<a href="${contextPath }/blog/blogStudyDelete?blogId=${blogStudy.blogId}" class="primary_btn"><span>삭제하기</span></a>
                                    </div>
                                </div>
                            </div>
                        </article>
                      </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
	
	
	
</body>
</html>