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
                    <h2>오늘의 키워드(상세정보)</h2>
                    <div class="page_link">
                        <a href="${contextPath }/">Home</a>
                        <a href="#">오늘의 키워드(상세정보)</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End Banner Area =================-->



		<!--================Blog Area =================-->
    <section class="blog_area single-post-area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 posts-list">
                    <div class="single-post row">
                       <c:if test="${blogDTO.picture1 ne null }">
	                        <div class="col-lg-12">
	                            <div class="feature-img">
	                                <img class="img-fluid" src="${contextPath }/blog/blogDetailPicture1?picture1=${blogDTO.picture1}" width="750" height="350" alt="메인사진">
	                            </div>									
	                        </div>
	                     </c:if>
                        <div class="col-lg-3  col-md-3">
                            <div class="blog_info text-right">
                                <div class="post_tag">
                                    <a href="#">${blogDTO.sort }</a>
                                </div>
                                <ul class="blog_meta list">
                                    <li><a href="#">${blogDTO.humanId }<i class="lnr lnr-user"></i></a></li>
                                    <li><a href="#"><fmt:formatDate value="${blogDTO.enrollDt }" pattern="yyyy-MM-dd"/><i class="lnr lnr-calendar-full"></i></a></li>
                                    <li><a href="#">${blogDTO.readCnt }<i class="lnr lnr-eye"></i></a></li>
                                    <li><a href="#">${allBlogReplyCnt }<i class="lnr lnr-bubble"></i></a></li>
                                </ul>
                                <ul class="social-links">
                                    <li><a href="https://ko-kr.facebook.com/"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="http://twitter.com/"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="https://github.com/hahy2329"><i class="fa fa-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-9 col-md-9 blog_details">
                            <h2>${blogDTO.subject }</h2>
                            <p class="excert">
                                ${blogDTO.content }
                            </p>
                        </div>
                        <div class="col-lg-12">
                            <div class="row">
                            	<c:if test="${blogDTO.picture2 ne null }">
	                                <div class="col-6">
	                                    <img class="img-fluid" src="${contextPath }/blog/blogKeywordPicture2?picture2=${blogDTO.picture2}" width="360" height="350" alt="서브사진">
	                                </div>
	                             </c:if>
	                            <c:if test="${blogDTO.picture3 ne null }">
                                	<div class="col-6">
                                    	<img class="img-fluid" src="${contextPath }/blog/blogKeywordPicture3?picture3=${blogDTO.picture3}" width="360" height="350" alt="서브사진">
                                	</div>
                                </c:if>								
                            </div>
                        </div>
                    </div>
                    <div class="comments-area">
                        <h4>${allBlogReplyCnt }개의 댓글이 있습니다.</h4>
                        <c:forEach var="blogReplyDTO" items="${blogReplyList }">
                        <div class="comment-list">
                            <div class="single-comment justify-content-between d-flex">
                                <div class="user justify-content-between d-flex">
                                    <div class="thumb">
                                        <img src="${contextPath }/human/thumbnails2?profile2=${humanDTO.profile}"  width="60" height="60" alt="프로필 이미지">
                                    </div>
                                    <div class="desc">
                                        <h5><a href="#">${blogReplyDTO.humanId }</a></h5>
                                        <p class="date"><fmt:formatDate value="${blogReplyDTO.enrollDt }" pattern="yyyy-MM-dd,hh:mm"/></p>
                                        <p class="comment">
                                            ${blogReplyDTO.content }
                                        </p>
                                    </div>
                                </div>
                                <div class="reply-btn">
                                	<c:if test="${sessionScope.humanId eq blogReplyDTO.humanId }">
                                        <a href="${contextPath }/blogReply/blogReplyUpdate?replyId=${blogReplyDTO.replyId}" class="btn-reply text-uppercase">댓글 수정</a> 
                                        <a href="${contextPath }/blogReply/blogReplyRemove?replyId=${blogReplyDTO.replyId}" class="btn-reply text-uppercase">댓글 삭제</a> 
                                	</c:if>
                                </div>
                            </div>
                        </div>
                        </c:forEach>	                           				
                    </div>
                    <div class="comment-form">
                        <a href="${contextPath }/blogReply/blogReplyWrite?blogId=${blogDTO.blogId}" class="primary-btn primary_btn"><span>댓글 작성</span></a>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="blog_right_sidebar">
                        <aside class="single_sidebar_widget search_widget">
                            <div class="br"></div>
                        </aside>
                        <aside class="single_sidebar_widget author_widget">
                            <img class="author_img rounded-circle" src="${contextPath }/human/thumbnails?profile=${humanDTO.profile}" width="120" height="120" alt="프로필 이미지">
                            <h4>${humanDTO.humanId }</h4>
                            <p>백엔드 개발자</p>
                            <div class="social_icon">
                                <a href="https://ko-kr.facebook.com/"><i class="fa fa-facebook"></i></a>
                                <a href="http://twitter.com/"><i class="fa fa-twitter"></i></a>
                                <a href="https://github.com/hahy2329"><i class="fa fa-github"></i></a>
                            </div>
                            <p>${humanDTO.content }</p>
                            <div class="br"></div>
                        </aside>
                        <!-- 밑에 부분은 각 블로그 종류 별 최근 순으로 하나 씩만 가져올 예정 -->
                        <aside class="single_sidebar_widget post_category_widget">
                            <h4 class="widget_title">blog Catgories</h4>
                            <ul class="list cat-list">
                            <!-- 밑에는 각 블로그 종류 별 작성 수를 기재할 것임 -->
                                <li>
                                    <a href="#" class="d-flex justify-content-between">
                                        <p>개발 공부</p>
                                        <p>37</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex justify-content-between">
                                        <p>소소한 일상</p>
                                        <p>24</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex justify-content-between">
                                        <p>오늘의 핵심 키워드</p>
                                        <p>59</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex justify-content-between">
                                        <p>여행</p>
                                        <p>59</p>
                                    </a>
                                </li>															
                            </ul>
                            <div class="br"></div>
                        </aside>
                        <aside class="single-sidebar-widget newsletter_widget">
                            <h4 class="widget_title">Newsletter</h4>
                            <p>
                            Here, I focus on a range of items and features that we use in life without
                            giving them a second thought.
                            </p>
                            <p class="text-bottom">You can unsubscribe at any time</p>	
                            <div class="br"></div>							
                        </aside>
                        <aside class="single-sidebar-widget tag_cloud_widget">
                            <h4 class="widget_title">Tag Clouds</h4>
                            <ul class="list">
                                <li><a href="#">HTML5</a></li>
                                <li><a href="#">CSS3</a></li>
                                <li><a href="#">JavaScript</a></li>
                                <li><a href="#">Jquery</a></li>
                                <li><a href="#">Java</a></li>
                                <li><a href="#">JSP</a></li>
                                <li><a href="#">Spring Framework</a></li>
                                <li><a href="#">Mybatis</a></li>
                                <li><a href="#">JPA</a></li>
                                <li><a href="#">REST API</a></li>
                                <li><a href="#">API</a></li>
                                <li><a href="#">Web Socket</a></li>
                            </ul>
                        </aside>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================Blog Area =================-->
</body>
</html>