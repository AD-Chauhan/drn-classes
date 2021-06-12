<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<div id="apus-main-content">
	<section id="apus-breadscrumb"
		class="breadcrumb-page apus-breadscrumb has_bg"
		style="background-image: url('./resources/img/bg_1.jpg')">
		<div class="container">
			<div class="wrapper-breads">
				<div class="wrapper-breads-inner">
					<h2 class="bread-title">Courses</h2>

				</div>
			</div>
		</div>
	</section>
	<section
											class="elementor-element elementor-element-3bb8e39 elementor-section-stretched elementor-section-boxed elementor-section-height-default elementor-section-height-default elementor-section elementor-top-section"
											data-id="3bb8e39" data-element_type="section"
											data-settings="{&quot;stretch_section&quot;:&quot;section-stretched&quot;}">
											<div
												class="elementor-container elementor-column-gap-extended">
												<div class="elementor-row">
													<div
														class="elementor-element elementor-element-3b29ec8 elementor-column elementor-col-100 elementor-top-column"
														data-id="3b29ec8" data-element_type="column">
														<div
															class="elementor-column-wrap  elementor-element-populated">
															<div class="elementor-widget-wrap">
																<div
																	class="elementor-element elementor-element-640dcf0 elementor-widget elementor-widget-drnclasses_heading"
																	data-id="640dcf0" data-element_type="widget"
																	data-widget_type="drnclasses_heading.default">
																	<div class="elementor-widget-container">
																		<h2 style="font-size: 19px;
    padding: 19px 7px;
    font-weight: 700;
    position: relative;
    text-transform: uppercase;
    color: #0a0a0a;
    background-color: transparent;
    font-family: nunito,Arial,sans-serif;
    display: inline-block;
    vertical-align: middle;
    -webkit-transition: all .2s ease-in-out;
    -moz-transition: all .2s ease-in-out;
    -ms-transition: all .2s ease-in-out;
    -o-transition: all .2s ease-in-out;
    transition: all .2s ease-in-out;" class="drnclasses-heading-title drnclasses-size-default">Browse
																			Our Top Courses</h2>
																		
																	</div>
																</div>
																<div
																	class="elementor-element elementor-element-a60d954 elementor-widget elementor-widget-drnclasses_learnpress_courses_tabs"
																	data-id="a60d954" data-element_type="widget"
																	data-widget_type="drnclasses_learnpress_courses_tabs.default">
																	<div class="elementor-widget-container">
																		<div class="widget widget-courses-tabs ">
																		
																		
																		
																		
																		
																		
																		
																		
																	 
																		
																		
																			<div class="widget-content grid">
																			
																			
																			<c:forEach items="${finalList}" var="oblist" varStatus="count" >	
																		
																		
																		 <c:set var="courseKey" value="${oblist.key}" />
			                                                              <c:set var="courseValue" value="${oblist.value}" />
																		
																			
																			
																			
																			
																			
																			
																				<div class="top-info">
																					<ul role="tablist" class="nav nav-tabs tabs-course">
																						<li class="active"><a href="#"
																							data-toggle="tab"> ${courseKey} </a></li>
																						
																					</ul>
																				</div>
																				<div class="tab-content">
																				
																				 
																					<div id="tab-hm6Sa-0"
																						class="tab-pane fade in active">
																						<div class="row">
																						 <c:forEach items="${courseValue}" var="thumblist" >
																							<div
																								class="col-lg-3 col-md-4 col-sm-6 ">
																								<div
																									class="course-grid post-655 lp_course type-lp_course status-publish has-post-thumbnail hentry course_category-2d course_category-best-practices course_category-graphics course_tag-beginner course_tag-photoshop course_tag-sketch course_tag-ux-ui course">
																									<div class="course-entry">

																										<div class="course-cover">
																											<div class="course-cover-thumb">
																												<a href="#"> <img width="614"
																													height="400" src="<%=request.getContextPath()%>${thumblist.thumbnailPath}${thumblist.thumbnailFileName}"
																													class="attachment-drnclasses-course-grid size-drnclasses-course-grid wp-post-image"
																													alt="The Complete Shopify Aliexpress Dropship" />
																												</a>
																												
																												<div class="course-cover-label">
																													<a href="<%=request.getContextPath()%>/play-video?v=${thumblist.encryptdata}"> Preview Course </a>
																												</div>
																											</div>
																										</div>
																										<div class="course-detail" style="height: 130px !important; ">
																											<div class="course-info-box">

																												<div class="course-teacher">
																													<a href="#">${thumblist.videoTitle}</a>
																												</div>

																												<a href="#">
																													<h3 class="course-title">${thumblist.videoName}</h3>
																												</a>

																											</div>

																										</div>
																									</div>
																								</div>
																							</div>
																							
																						</c:forEach>	
																							
																							
																						</div>
																					</div>
																					
																					
																					
																					
																				</div>
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																				
																					
																		</c:forEach>	
																				
																				
																				
																				
																				
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