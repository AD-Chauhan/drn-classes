<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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
                
              </div>  
            </div>
          </div>
        </div>
      </div></section>

<!-- Tabs -->
      <section class="well well2">
        <div class="container">
          
         

          <div class="resp-tabs-welcome">
            
            <div class="resp-tabs-container--welcome">
              <div>
                <div class="row">
                  <div class="col-sm-6 col-xs-12">
                    <div class="thumbnail">
                      <a class="thumb" data-fancybox-group='1' href="<%=request.getContextPath()%>/resources/Users/images/page-1_img2_original.jpg">
                          <img src="<%=request.getContextPath()%>/resources/Users/images/page-1_img2.jpg" alt=""/>
                          <span class="thumb_overlay"></span>
                      </a>
                      <div class="caption text-right">
                                             
                        <h4>
                          GALLARY-1
                        </h4>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-xs-12">
                    <div class="thumbnail">
                      <a class="thumb" data-fancybox-group='1' href="<%=request.getContextPath()%>/resources/Users/images/page-1_img3_original.jpg">
                          <img src="<%=request.getContextPath()%>/resources/Users/images/page-1_img3.jpg" alt=""/>
                          <span class="thumb_overlay"></span>
                      </a>
                      <div class="caption text-right">
                                              
                        <h4>
                          GALLARY-2
                        </h4>
                        
                      </div>
                    </div>
                  </div>
                </div>

                <div class="row">
                  <div class="col-sm-6 col-xs-12">
                    <div class="thumbnail">
                      <a class="thumb" data-fancybox-group='1' href="<%=request.getContextPath()%>/resources/Users/images/page-1_img4_original.jpg">
                          <img src="<%=request.getContextPath()%>/resources/Users/images/page-1_img4.jpg" alt=""/>
                          <span class="thumb_overlay"></span>
                      </a>
                      <div class="caption text-right">
                                             
                        <h4>
                         GALLARY-3 
                        </h4>
                        
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-xs-12">
                    <div class="thumbnail">
                      <a class="thumb" data-fancybox-group='1' href="<%=request.getContextPath()%>/resources/Users/images/page-1_img5_original.jpg">
                          <img src="<%=request.getContextPath()%>/resources/Users/images/page-1_img5.jpg" alt=""/>
                          <span class="thumb_overlay"></span>
                      </a>
                      <div class="caption text-right">
                                            
                        <h4>
                          GALLARY-4
                        </h4>
                        
                      </div>
                    </div>
                  </div>
                </div>
              </div>


              
            </div>
          </div>

        </div>
      </section>
<!-- End Tabs -->
      
      <section class="well well3 bg-secondary2 wow fadeIn" data-wow-duration='3s'>
        <div class="container">
          <div class="jumbotron text-center">
            <p>
              
              <small>
                DRN Classes Are Educational Institutions Operating With The Exclusive Objective Of Preparing Students For Class 9, 10, 11, 12 Examinations
              </small>
            </p>
            <a href="#" class="btn btn-primary btn-lg">JOIN DRN CLASSES</a>
          </div>
        </div>
      </section>

      <section class="well well4 bg-info text-center">
        <div class="container">
          <h2>
            Browse Our Top Courses
          </h2>
       <div class="row">
          <c:if test="${!empty finalList}">
          <c:forEach items="${finalList}" var="thumblist" varStatus="count" >	
          
          
          <div class="col-md-4 col-sm-12 col-xs-12 wow fadeInLeft" data-wow-duration='3s'>
              <div class="thumbnail-1">
                <div class="caption">
                  <h3>
                  ${thumblist.videoTitle}<br />
                    <small>
                     ${thumblist.videoName}
                    </small>
                  </h3>  
                </div>
                <div class="img-bl">
                  <img src="<%=request.getContextPath()%>${thumblist.thumbnailPath}${thumblist.thumbnailFileName}" alt="">
                </div>  
                <a href="<%=request.getContextPath()%>/play-video?v=${thumblist.encryptdata}" class="btn btn-default">view all</a>
              </div>
            </div>  
          
          
          </c:forEach>	
																				
		</c:if>
            
               
                         
          </div>
        </div>
      </section>
      
      <section class="bg-secondary3" style="padding: 25px;background-size: cover !important;
    background-position: 0 0;
    background-image: -webkit-linear-gradient(left, #84858f 0%, #c7ad83 100%) !important;
    background-repeat: repeat-x !important;">
		<div class="container">
			<div class="wrap">
				<div class="cnt" style="margin-top: 20px !important;">
					<h5>${record[0].blogTitle}</h5>
					<p>${record[0].blogTitle}</p>
					<a href="<%=request.getContextPath()%>/blog-details"
						class="btn-link-1">show more</a>
				</div>
				<div class=" wow fadeInRight" data-wow-duration='2s' style="margin-top: 20px !important;width: 574px !important;
    margin-left: 11px; !important">
					<img style="height: 381px !important;"
						src="<%=request.getContextPath()%>${record[0].originalPath}${record[0].originalFileName}"
						alt="">
				</div>
				<div class=" wow fadeInLeft" data-wow-duration='2s' style="margin-top: 20px !important;">
					<img style="height: 381px !important;"
						src="<%=request.getContextPath()%>${record[1].originalPath}${record[1].originalFileName}"
						alt="">
				</div>
				<div class="cnt" style="margin-top: 20px !important;width: 574px !important;
    margin-left: 11px; !important">
					<h5>${record[1].blogTitle}</h5>
					<p>${record[1].blogTitle}</p>
					<a href="<%=request.getContextPath()%>/blog-details"
						class="btn-link-1">show more</a>
				</div>


			</div>
			<div class="wrap">
				<div class="cnt" style="margin-top: 20px !important;">
					<h5>${record[2].blogTitle}</h5>
					<p>${record[2].blogTitle}</p>
					<a href="<%=request.getContextPath()%>/blog-details"
						class="btn-link-1">show more</a>
				</div>
				<div class=" wow fadeInRight" data-wow-duration='2s' style="margin-top: 20px !important;width: 574px !important;
    margin-left: 11px; !important">
					<img style="height: 381px !important;"
						src="<%=request.getContextPath()%>${record[2].originalPath}${record[2].originalFileName}"
						alt="">
				</div>
				<div class=" wow fadeInLeft" data-wow-duration='2s' style="margin-top: 20px !important;">
					<img style="height: 381px !important;"
						src="<%=request.getContextPath()%>${record[3].originalPath}${record[3].originalFileName}"
						alt="">
				</div>
				<div class="cnt" style="margin-top: 20px !important;width: 574px !important;
    margin-left: 11px; !important">
					<h5>${record[3].blogTitle}</h5>
					<p>${record[3].blogTitle}</p>
					<a href="<%=request.getContextPath()%>/blog-details"
						class="btn-link-1">show more</a>
				</div>


			</div>
		</div>
	</section>

      <section class="well well5 parallax parallax1" data-url="<%=request.getContextPath()%>/resources/Users/images/parallax2.jpg" data-mobile="true">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-md-offset-1 col-sm-12 text-right center991">
              <img src="<%=request.getContextPath()%>/resources/Users/images/page-1_img12.png" alt="">
            </div>
            <div class="col-md-8 col-sm-12 center991">
              <div class="wrap">
                <p>
                  EXAMINATION MATERIALS
                </p>
                
                <a href="<%=request.getContextPath()%>/exam-answer-metrials" class="btn btn-default">VIEW more</a>
              </div>  
            </div>
          </div> 
        </div>
      </section>
    </main>
	
	
