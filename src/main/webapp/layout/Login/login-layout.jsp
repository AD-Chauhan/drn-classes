<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control","no-cache");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", -1);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="java.util.Calendar" %>
 
<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
  
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
 <c:set var="lang" scope="request" value="${requestScope.locale.language}"/> 
 
 
 <html xmlns="http://www.w3.org/1999/xhtml"> 
 
 
     <head>
     
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>Dashboard - DAdmin</title>
      <meta name="author" content="">
      <meta name="description" content="">
      <meta name="keywords" content="">
 
  
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700%7CMontserrat:400,500">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/fontawesome-all.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/jquery-ui.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/perfect-scrollbar.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/morris.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/select2.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/jquery-jvectormap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/horizontal-timeline.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/weather-icons.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/dropzone.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/ion.rangeSlider.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/ion.rangeSlider.skinFlat.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/datatables.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/fullcalendar.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/Admin/assets/css/style.css"/>">
<script src="<c:url value="/resources/Admin/assets/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/jquery-ui.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/bootstrap.bundle.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/perfect-scrollbar.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/jquery.sparkline.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/raphael.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/morris.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/select2.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/jquery-jvectormap.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/jquery-jvectormap-world-mill.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/horizontal-timeline.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/jquery.validate.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/jquery.steps.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/dropzone.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/ion.rangeSlider.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/datatables.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/assets/js/main.js"/>"></script>
	
	<script src="<c:url value="/resources/Admin/js/notify.min.js"/>"></script>
	<script src="<c:url value="/resources/Admin/js/notify.js"/>"></script>
 	
 	</head>
<body >

				
		<tiles:insertAttribute name="body"/>
				
				
</body>
 
 </html>
 
