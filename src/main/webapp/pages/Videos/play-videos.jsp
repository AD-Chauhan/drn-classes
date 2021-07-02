<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/resources/player/css/plyr.css'>
<link rel="stylesheet" href="<c:url value="/resources/Users/css/template.css"/>">
<style>
/* This is purely for the demo */
.plyr {
	border-radius: 0px;
	margin-bottom: 15px;
	height: 600px !important;
}
</style>

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
<div id="apus-main-content">
	
	<section id="main-container" class="main-content container inner">
		<div class="row">
			<div id="main-content" class="col-xs-12">
				<div id="primary" class="content-area">
					<div id="content" class="site-content detail-course" role="main">
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12 ">
								<div id="lp-single-course" class="lp-single-course">
									<div id="learn-press-course" class="course-summary">
										<div class="course-landing-summary">
											<div class="course-meta">
												<div class="course-header">

													<div class="course-header-middle">
														<h2 class="title" style="text-transform: uppercase !important;
    color: #e63f17;margin-top: 36px;">${finalList.videoTitle}</h2>
													</div>

												</div>
											</div>
											<div class="course-video">
												<div style="width: 640px;" class="wp-video">
													
													<video controls crossorigin playsinline
														data-poster="<%=request.getContextPath()%>${finalList.thumbnailPath}${finalList.thumbnailFileName}"
														class="js-player">
														<!-- Video files -->
														<source
															src="<%=request.getContextPath()%>${finalList.originalPath}${finalList.originalFileName}"
															type="video/mp4" size="576" />
														<source
															src="<%=request.getContextPath()%>${finalList.originalPath}${finalList.originalFileName}"
															type="video/mp4" size="720" />
														<source
															src="<%=request.getContextPath()%>${finalList.originalPath}${finalList.originalFileName}"
															type="video/mp4" size="1080" />



													</video>
												</div>
											</div>
											<div class="course-tab-panel-overview course-section-panel"
												id="tab-overview">
												<h3 class="section-title">Overview</h3>
												<div class="course-description"
													id="learn-press-course-description">
													<p class="space-bottom-30">${finalList.description}</p>

												</div>
											</div>


										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12 ">

								<div id="reviews">
									<c:forEach var="cm" items="${commentMap}">
									<div id="comments">
										<ol class="comment-list" style="border: 2px solid #004471;">
										
											<li
												class="comment byuser comment-author-admin bypostauthor even thread-even depth-1"
												id="li-comment-40">
												<div id="comment-40" class="the-comment media" style="border: 2px solid #004471;
    padding: 10px;background-size: cover !important;
    background-position: 0 0;
    background-image: -webkit-linear-gradient(left, #84858f 0%, #c7ad83 100%) !important;
    background-repeat: repeat-x !important;
    text-transform: uppercase;">
													
													<div class="comment-box media-body">
														<div class="meta">
															<h3 class="title-author">${cm.key.createdby}</h3>
															<div class="info-meta">
																<span class="meta"> ${cm.key.createdDate}
																</span>
															</div>
														
														</div>
														<div itemprop="description" class="comment-text">
															<p>${cm.key.commnent}</p>
														</div>
														
													</div>
												</div>
												<c:if test="${empty cm.value}">
											
											
											<div id="respond" class="comment-respond" style="margin-left: 100px !important;">
																
														<form action="video-reply" method="post" id="replyform" class="comment-form" >			
																	
																	<div class="form-group">
																		<textarea style="color: #004471 !important;
    font-size: 20px;
    word-break: break-all;
    font-weight: 600;border-color: #004471 !important;" placeholder="Write Comment" id="author"
																			class="form-control" style="color: #004471;
    font-size: 20px;
    word-break: break-all;" name="reply" cols="45"
																			rows="5" aria-required="true"></textarea>
																	</div>
																	<p class="form-submit">
																		<input name="submit" type="submit" id="submit"
																			class="btn btn-theme " value="REPLY">
																	</p>
																	<input type="hidden" value="${finalList.folderId}" name="folderId"> 
																					<input type="hidden" value="${cm.key.cId}" name="commentId">
																</form>
															</div>
											            </c:if>
											</li>
											
											
											
											<c:forEach var="cr" items="${cm.value}" varStatus="loop">
											<ul class="children">
											
											<form action="video-reply" method="post" id="replyform" class="comment-form" >
												<li
													class="comment byuser comment-author-admin bypostauthor odd alt depth-2"
													id="li-comment-79">
													<div id="comment-79" class="the-comment media" style="border: 2px solid #004471;
    padding: 10px;background-size: cover !important;
    background-position: 0 0;
    background-image: -webkit-linear-gradient(left, #84858f 0%, #c7ad83 100%) !important;
    background-repeat: repeat-x !important;
    text-transform: uppercase;">
														
														<div class="comment-box media-body">
															<div class="meta">
																<h3 class="title-author">${cr.createdby}</h3>
																<div class="info-meta">
																	<span class="meta"> <time>${cr.createdDate}</time>
																	</span>
																</div>
																
															</div>
															<div itemprop="description" class="comment-text">
																<p>
																	${cr.commnent}
																</p>
															</div>
															
															
														</div>
													</div>
													<c:if test="${loop.last}">
															
															<div id="respond" class="comment-respond">
																
																	
																	
																	<div class="form-group">
																		<textarea style="color: #004471 !important;
    font-size: 20px;
    word-break: break-all;
    font-weight: 600;border-color: #004471 !important;" placeholder="Write Comment" id="author"
																			class="form-control" style="color: #004471;
    font-size: 20px;
    word-break: break-all;" name="reply" cols="45"
																			rows="5" aria-required="true"></textarea>
																	</div>
																	<p class="form-submit">
																		<input name="submit" type="submit" id="submit"
																			class="btn btn-theme " value="REPLY">
																	</p>
																	<input type="hidden" value="${finalList.folderId}" name="folderId"> 
																					<input type="hidden" value="${cm.key.cId}" name="commentId">
																
															</div>
															</c:if>
												</li>
												</form>
											</ul>
</c:forEach>
											<!-- end Reply -->
											
											
											
										</ol>
									</div>
									 </c:forEach>
									<div id="review_form_wrapper" class="commentform">
										<div class="reply_comment_form hidden">
											<div class="commentform reset-button-default">
												<div class="clearfix">
													<div id="wp-temp-form-div" style="display: none;"></div>
												</div>
											</div>
										</div>
										<div id="review_form">
											<div class="commentform reset-button-default">
												<div class="clearfix">
													<div id="respond" class="comment-respond">
														
														<form
																	action="video-comment"
																	method="post" id="commentform" class="comment-form"
																	>
															
															
															
															<div class="form-group">
																<label style="font-size: 18px;
    font-weight: 600;">Review</label>
																<textarea style="color: #004471 !important;
    font-size: 20px;
    word-break: break-all;
    font-weight: 600;border-color: #004471 !important;" id="comment" class="form-control"
																	placeholder="Write Review" name="comment" cols="45"
																	rows="5" aria-required="true"></textarea>
																	<input type="hidden" value="${finalList.folderId}" name="folderId">
															</div>
															<p class="form-submit">
																<input name="submit" type="submit" id="submit"
																	class="btn btn-theme " value="COMMENT">
																	
															</p>
															
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
</main>
<script
	src="<%=request.getContextPath()%>/resources/player/js/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>

<script src='<%=request.getContextPath()%>/resources/player/js/plyr.js'></script>
<script id="rendered-js" type="text/javascript">

document.addEventListener('DOMContentLoaded', () => {
   

    var controls = [
        'play-large', 
        'restart', 
        'rewind',
        'play', 
        'fast-forward', 
        'progress', 
        'current-time',
        'mute',
        'volume', 
        'captions', 
        'settings', 
        'pip', 
        'airplay', 
        'fullscreen' 
    ];

    var player = Plyr.setup('.js-player', { controls });

});
</script>