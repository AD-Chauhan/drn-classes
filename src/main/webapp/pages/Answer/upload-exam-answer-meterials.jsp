<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<script type='text/javascript' src="<c:url value="/resources/pdf/pdfobject.js"/>"></script>
	
<script type="text/javascript">
											
									function validateForm(index){
										
										document.getElementById("errorMessage~"+index).style.display= 'none';
												var filelength = document.getElementById("answerFileName~"+index).files.length;
												if(filelength!=0){
													 document.forms["metrialsAnswerForm~"+index].submit();
													
												}else{
													document.getElementById("errorMessage~"+index).style.display= 'block';
													 return false;
													
												}
												 
											 }
											
											</script>
<div id="apus-main-content">
	<section id="apus-breadscrumb"
		class="breadcrumb-page apus-breadscrumb has_bg"
		style="background-image: url('https://demoapus.com/edumy/wp-content/uploads/2019/05/breadcrumb-bkg.jpg')">
		<div class="container">
			<div class="wrapper-breads">
				<div class="wrapper-breads-inner">
					<h2 class="bread-title">The Examination Materials</h2>
					<div class="breadscrumb-inner">
						<ol class="breadcrumb">
							
							<li><span class="active">The Examination Materials</span></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="main-container"
		class="main-content home-page-default container inner">
		<c:if test="${!empty questionlist}">
						<c:forEach items="${questionlist}" varStatus="index" var="record">
		<div class="row">
			<div id="main-content" class="col-sm-12 col-md-12 col-sm-12 col-xs-12">
				
				
						
				<div id="main" class="site-main layout-blog" role="main" style="background-image: linear-gradient(to right, #24e772 0%, #1f25e8 100%) !important;">
					
					
					<div class="layout-posts-list">
					
						<article
							class="post post-layout post-list-item post-4440 type-post status-publish format-standard has-post-thumbnail hentry category-engineering tag-beginner tag-photoshop tag-sketch tag-ux-ui">
							<div class="list-inner" style="height: 423px !important;padding: 10px !important;">
								<div class="row flex-top">
									<div class="image col-xs-5">
										<div class="top-info-detail">
											<div class="top-image" id="embeded_${record.questionAnswerId}" style="height:400px;">
												<script>
												var options = {
													    height: "400px"
													    
													};
												var path='';
												path='<%=request.getContextPath()%>${record.questionFolderPath}${record.questionFolderId}.${record.questionFileExt}';
												var pathId='';
												pathId="#embeded_"+${record.questionAnswerId};
												PDFObject.embed(path, pathId,options);</script>
													
											</div>
											<div class="list-categories" style="top: 63px !important;">
												<i class="fa fa-folder-open-o" style="color: #b70d0f !important;
    font-size: 23px !important;
    font-weight: 600 !important;"></i> <a style="color: #b70d0f !important;
    font-size: 23px !important;
    font-weight: 600 !important;"
													href="https://demoapus.com/edumy/category/engineering/"
													class="categories-name">${record.meterialTitle}</a>
											</div>
											<div class="entry-date-time">
												<a
													href="https://demoapus.com/edumy/business-fundamentals-copy/">
													<span class="day" style="color: #b70d0f !important; font-size: 30px !important;"><fmt:formatDate value="${record.questionCreatedDate}" pattern="yy-MMM-dd"/></span> 
												</a>
											</div>
										</div>
									</div>
									<div class="col-xs-7">
										<div class="post-list-item-content">
											<h4 class="entry-title-detail">
												<a
													href="https://demoapus.com/edumy/business-fundamentals-copy/">${record.meterialName}</a>
											</h4>
											<div class="top-info">
												<span class="entry-author" style="color: #fff;"> <i
													class="flaticon-profile"></i> ${record.batch}
												</span> <span class="comments" style="color: #fff;"> <i
													class="flaticon-consulting-message"></i>${record.courseCategory}
												</span>
											</div>
											<div class="description" style="color: #fff;">${record.description}</div>
											
											<aside class="widget widget_search" style="margin-top: 61px !important;">
												<div class="widget-search">
													
													<c:choose>
											<c:when test="${record.answerGiven ne true}">
											<form:form class="form-horizontal" action="exam-answer-metrials" modelAttribute="metrialsAnswerForm" autocomplete="off"  enctype="multipart/form-data" method="post" id="metrialsAnswerForm~${index.index}">

														<div class="input-group" style="background-image: linear-gradient(to right, #b70d0f 0%, #1fe8cc 100%) !important;">
															
															
															<form:hidden path="userId"
																 name="userId" id="userId~${index.index}"/>
															<form:hidden path="emailId"
																 name="emailId" id="emailId~${index.index}" />
														    <form:hidden path="questionAnswerId"
																 name="questionId" id="questionAnswerId~${index.index}" value="${record.questionAnswerId}"/>		 
													
															<form:input type="file" placeholder="Upload Answer Sheet" path="answerFileName" 
																 name="answerFileName"  id="answerFileName~${index.index}" cssClass="form-control input-sm" /> <span
																class="input-group-btn">
																<button onclick="validateForm(${index.index})" type="button" style="font-size: 20px;
    color: #fff;" class="btn btn-sm btn-search">
																	Upload Answer Sheet
																</button>
															</span> 
																</div>
										      <div class="top-info" id="errorMessage~${index.index}" style="border: none !important; display: none;">
												<span class="entry-author" style="color: #b70d0f !important;font-size: 22px !important; font-weight: 600 !important;">Please Choose answer sheet to upload. This field is required.
												</span> 
											</div>
													</form:form>
											
											</c:when>
											<c:otherwise>
											
											
											
											<div  style="color: #fff;
    background-image: linear-gradient(to right, #b70d0f 0%, #1fe8cc 100%) !important;
    padding: 5px 0px 0px 18px;
    width: 100%;
    height: 50px;
    border: 1px solid #ddd;
    -webkit-border-radius: 5px;
    box-shadow: 0 5px 5px -5px rgb(0 0 0 / 9%);
    font-size: 20px;
    text-transform: uppercase;">Note: Answer Sheet Has Been Submitted Successfully</div>
											
											</c:otherwise>
											</c:choose>	
													
												</div>
											</aside>
										</div>
									</div>
								</div>
							</div>
						</article>


				

					</div>
					
				</div>
				
				
			</div>

		</div>
		</c:forEach>
					</c:if>	
		<c:if test="${empty questionlist}">			
		<div class="wrapper-breads">
				<div class="wrapper-breads-inner">
					<h2 class="bread-title" style="text-align: center !important;
    text-transform: uppercase !important;
    font-size: 24px !important;">No Examination Materials Are Available</h2>
					
				</div>
			</div>
			</c:if>	
	</section>
</div>