<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="format-detection" content="telephone=no"/>
   
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <title>Home page</title>
    <link rel="stylesheet" href="<c:url value="/resources/Users/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/Users/css/camera.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/Users/css/owl-carousel.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/Users/css/jquery.fancybox.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/Users/css/search.css"/>">
    <script src="<c:url value="/resources/Users/js/jquery.js"/>"></script>
    <script src="<c:url value="/resources/Users/js/jquery-migrate-1.2.1.min.js"/>"></script>
    <script src="<c:url value="/resources/Users/js/device.min.js"/>"></script>
  </head>
  <body>
  <div class="page">
  <!--========================================================
                            HEADER
  =========================================================-->
    <header class="sec_sets">  
      <div id="stuck_container" class="stuck_container">
        
          <div class="container">             
            <nav class="navbar navbar-default navbar-static-top ">

            <div class="navbar-left">  
              <ul class="nav navbar-nav sf-menu index-menu" data-type="navbar">
              
                <li class="dropdown">
                  <a href="<%=request.getContextPath()%>/home-page">Home</a>
                 
                </li>

                <li>
                  <a href="<%=request.getContextPath()%>/course-details">Courses</a>                  
                </li>
                <li class="active">
                  <a href="<%=request.getContextPath()%>/blog-details">Blogs</a>
                </li>
                <li >
                  <a href="<%=request.getContextPath()%>/exam-answer-metrials">Eaxm Materials</a>
                </li>
                
                <li>
                  <a href="<%=request.getContextPath()%>/contact-details">Contact Us</a>
                </li>
                
                <li>
                  <a href="<%=request.getContextPath()%>/logout">Logout</a>
                </li>
                
              </ul>                           
            </div>
          </nav>
          </div>
        
      </div>  
      
     
    </header>
    
    
    <tiles:insertAttribute name="body" />
    
  <!--========================================================
                            FOOTER
  =========================================================-->
  <footer>
    
     <section>
      <div class="container" style="width: 99.8% !important;"> 
        <div class="row">
          <div class="col-sm-4 col-xs-12 center767">
            <p>
              &#169; <span id="copyright-year"></span>
              <a href="#"> <span class="rights">Privacy Policy</span></a><a href="#"> <span class="rights">TERMS & CONDITIONS</span></a><a href="#"> <span class="rights">ABOUT-US</span></a>
              <!-- {%FOOTER_LINK} -->
            </p>      
          </div>
          <div class="col-sm-4 col-xs-12 center767">
            <address>
              <p style="text-transform: uppercase !important;
    font-size: 21px !important;
    margin-top: -25px;
    display: block;
    color: #f3ba31;
    margin-left: 222px !important;
    line-height: 34px !important;">
                DRN CLASSES&nbsp;|&nbsp;PRAYAGRAJ
              </p>
              <p style="text-transform: lowercase !important;
    font-size: 21px !important;
    margin-top: -25px;
    display: block;
    color: #f3ba31;
    margin-left: 222px !important;
    line-height: 82px !important;">
                +919670469684&nbsp;|&nbsp;deepuyadav06071997@gmail.com
              </p>
              
              <p style="text-transform: uppercase !important;
    font-size: 21px !important;
    margin-top: -25px;
    display: block;
    margin-left: 224px !important;
    line-height: 34px !important;
    color: #f3ba31;
    text-align: left;">
               NEAR GEORGE TOWN POLICE STATION MALVIYA ROAD PRAYAGRAJ U.P.
              </p>
              
              
            </address>
          </div>
          <div class="col-sm-4 col-xs-12">
            <ul class="inline-list text-right center767">      
              <li><a href="#" class="fa fa-twitter">twitter</a></li>
              <li><a href="#" class="fa fa-facebook">facebook</a></li>
              <li><a href="#" class="fa  fa-google-plus">google-plus</a></li>
              <li><a href="#" class="fa  fa-rss">rss</a></li>
              <li><a href="#" class="fa fa-pinterest">pinterest</a></li>
            </ul>
          </div>
        </div>                
      </div> 
    </section>     
  </footer>
  </div>                     
                      
    <script src="<c:url value="/resources/Users/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/Users/js/tm-scripts.js"/>"></script>    
 

  </body></html>