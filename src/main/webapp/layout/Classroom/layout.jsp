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
 	
 	</head>
<body >
<div class="wrapper">
         <header class="navbar navbar-fixed">
            <div class="navbar--header"> <a href="index.html" class="logo"> <img src="assets/img/logo.png" alt=""> </a> 
            <a href="#" class="navbar--btn" data-toggle="sidebar" title="Toggle Sidebar"> <i class="fa fa-bars"></i> </a> </div>
            
            
            <div class="navbar--nav ml-auto">
               <ul class="nav">
                  
                  <li class="nav-item dropdown nav--user online">
                     <a href="#" class="nav-link" data-toggle="dropdown"> <img src="<%=request.getContextPath()%>/resources/Admin/assets/img/01_80x80.png" alt="" class="rounded-circle"> <span>Henry Foster</span> <i class="fa fa-angle-down"></i> </a> 
                     
                  </li>
               </ul>
            </div>
         </header>
         <aside class="sidebar" data-trigger="scrollbar">
            
            <div class="sidebar--nav">
               <ul>
                  <li>
                     <ul>
                        <li class="active"> <a href="index.html"> <i class="fa fa-home"></i> <span>Dashboard</span> </a> </li>
                        
                     </ul>
                  </li>
                 
                  <li>
                    
                     <ul>
                       
                        <li> <a href="<%=request.getContextPath()%>/register-page"> <i class="far fa-calendar-alt"></i> <span>Register Students</span> </a> </li>
                        <li> <a href="<%=request.getContextPath()%>/upload-video"> <i class="far fa-comments"></i> <span>Upload Videos</span> </a> </li>
                        <li> <a href="#"> <i class="far fa-address-book"></i> <span>View Videos</span> </a> </li>
                        <li> <a href="#"> <i class="far fa-sticky-note"></i> <span>Edit Videos</span> </a> </li>
                        <li> <a href="<%=request.getContextPath()%>/video-conferencing"> <i class="far fa-sticky-note"></i> <span>Class Rooms</span> </a> </li>
                       
                     </ul>
                  </li>
                
               </ul>
            </div>
            
         </aside>  
         <main class="main--container">
				
		<tiles:insertAttribute name="body"/>
				
				 </main>
      </div>	
</body>
 
 </html>
 
