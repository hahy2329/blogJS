<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="${contextPath }/resources/satner-master/img/favicon.png" type="image/png">
	<title><tiles:insertAttribute name="title"/></title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/css/bootstrap.css">
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/vendors/linericon/style.css">
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/css/font-awesome.min.css">
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/vendors/owl-carousel/owl.carousel.min.css">
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/css/magnific-popup.css">
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/vendors/nice-select/css/nice-select.css">
	<!-- main css -->
	<link rel="stylesheet" href="${contextPath }/resources/satner-master/css/style.css">
</head>

<body>
	
	
    <!-- Header Section Begin -->
    	<tiles:insertAttribute name="header" />
     <!-- Header Section End -->
     
     <!-- Body Section Begin -->	
     	<tiles:insertAttribute name="body" />
     <!-- Body Section End -->	
     
     <!-- Footer Section Begin -->
     	<tiles:insertAttribute name="footer" />
     <!-- Footer Section End -->




<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="${contextPath }/resources/satner-master/js/jquery-3.2.1.min.js"></script>
	<script src="${contextPath }/resources/satner-master/js/popper.js"></script>
	<script src="${contextPath }/resources/satner-master/js/bootstrap.min.js"></script>
	<script src="${contextPath }/resources/satner-master/js/stellar.js"></script>
	<script src="${contextPath }/resources/satner-master/js/jquery.magnific-popup.min.js"></script>
	<script src="${contextPath }/resources/satner-master/vendors/nice-select/js/jquery.nice-select.min.js"></script>
	<script src="${contextPath }/resources/satner-master/vendors/isotope/imagesloaded.pkgd.min.js"></script>
	<script src="${contextPath }/resources/satner-master/vendors/isotope/isotope-min.js"></script>
	<script src="${contextPath }/resources/satner-master/vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="${contextPath }/resources/satner-master/js/jquery.ajaxchimp.min.js"></script>
	<script src="${contextPath }/resources/satner-master/js/mail-script.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="${contextPath }/resources/satner-master/js/gmaps.min.js"></script>
	<script src="${contextPath }/resources/satner-master/js/theme.js"></script>
</body>
</html>