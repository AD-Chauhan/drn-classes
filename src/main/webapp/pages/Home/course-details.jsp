<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
  <script type="text/javascript">

var loggedUser = '<%=(String)session.getAttribute("loggedUser") %>';
$(function(){
	  
    $("#loggedUser").text(loggedUser);

});
</script>
<main>
<section class="well  parallax parallax1" >
<div class="parallax_cnt" style="padding-top: 0px;
    padding-bottom: 17px;
    margin-top: -52px !important;
    background-size: cover !important;
    background-position: 0 0;
    background-image: -webkit-linear-gradient(left, #84858f 0%, #c7ad83 100%) !important;
    background-repeat: repeat-x !important;
    text-transform: uppercase;
    text-align: left;">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-md-offset-1 col-sm-12 text-right center991">
              <img src="<%=request.getContextPath()%>/resources/Users/images/logo-white.png" alt="">
              <label style="text-transform: none;
    font-size: 25px;
    display: block;
    color: #021827;
    margin-top: -51px !important;
    font-weight: 900 !important;
    margin-left: -76px;" >Prayagraj</label>
            </div>
            <div class="col-md-8 col-sm-12 center991">
              <div class="wrap">
               
                <small style="font-size: 26px !important;
    margin-top: 39px;
    color: #121312;
    font-weight: 500;">
                DRN Classes Are Educational Institutions Operating With The Exclusive Objective Of Preparing Students For Class 9, 10, 11, 12 Examinations
                </small>
    <p style="display: inline-flex !important;
    font-size: 20px !important;color: #f3ba31;"  class="btn btn-primary btn-lg">Logged Student:&nbsp; <span id="loggedUser" style="color: #ffffff !important; text-transform: uppercase !important;">
   </span></p>
              </div>  
            </div>
          </div>
        </div>
      </div></section>
      <section class="well well2" style="margin-top: -148px !important;">
        <div class="container">
           <c:if test="${!empty finalList}">
																			
																			<c:forEach items="${finalList}" var="oblist" varStatus="count" >
          <div class="resp-tabs">
            <ul class="resp-tabs-list text-center" style="font-size: 30px;margin-top: 74px">
            	
																		
																		
																		 <c:set var="courseKey" value="${oblist.key}" />
			                                                              <c:set var="courseValue" value="${oblist.value}" />
			                                                              <li class="btn btn-success">${courseKey}</li>
             
             
              
              
              
            </ul>
           
            <div class="resp-tabs-container">
<!-- 1 tab -->
              <div>
               
              
                <div class="row">
                <c:forEach items="${courseValue}" var="thumblist" >
                  <div class="col-sm-6 col-xs-12" style="margin-top: 30px !important;">
                    <div class="thumbnail">
                      <a class="thumb"  href="<%=request.getContextPath()%>/play-video?v=${thumblist.encryptdata}">
                          <img style="width: 572px !important;" src="<%=request.getContextPath()%>${thumblist.thumbnailPath}${thumblist.thumbnailFileName}" alt=""/>
                          <span class="thumb_overlay"></span>
                      </a>
                     <div class="caption text-right">

										<h4>${thumblist.videoTitle}</h4>
										
					 </div>
                    </div>
                  </div>
                 </c:forEach>
                </div>   

                

                

                

              </div>


            </div>
            
          </div>
          
          </c:forEach>
             </c:if>
             
        </div>
      </section>

    </main>
	
	
