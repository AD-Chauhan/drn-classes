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
					<h2 class="bread-title">The Blogs</h2>

				</div>
			</div>
		</div>
	</section>
	<section id="main-container"
		class="main-content home-page-default container inner">


		<div class="row">
			<div id="main-content" class="col-sm-12 col-md-9 col-sm-12 col-xs-12">
				<div id="main" class="site-main layout-blog" role="main">

					<div class="layout-blog">
						<div class="row">
						
						<c:if test="${!empty finalList}">
						<c:forEach items="${finalList}" varStatus="index" var="record">
							<div class="col-sm-12 col-xs-12   col-xs-12">
								<article
									class="post post-layout post-grid-v1 post-4440 type-post status-publish format-standard has-post-thumbnail hentry category-engineering tag-beginner tag-photoshop tag-sketch tag-ux-ui">
									<div class="top-info-detail">
										<div class="top-image">
											<figure class="entry-thumb">
												<div class="post-thumbnail">
													<div class="image-wrapper">
														<img width="1200" height="611"
															src="data:image/svg+xml;charset=utf-8,%3Csvg xmlns%3D&#039;http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg&#039; viewBox%3D&#039;0 0 1200 611&#039;%2F%3E"
															class="attachment-1200x611x1x1 size-1200x611x1x1 unveil-image"
															alt=""
															data-src="<%=request.getContextPath()%>${record.originalPath}${record.originalFileName}" />
													</div>
												</div>
											</figure>
										</div>
										<div class="entry-date-time">
											<a href="#"> <span class="day">${record.executionTime} </span> 
											</a>
										</div>
									</div>
									<div class="list-categories">
										<i class="fa fa-folder-open-o"></i> <a href="#"
											class="categories-name">${record.blogTitle}</a>
									</div>
									<h4 class="entry-title-detail">
										<a
											href="#">${record.blogName}</a>
									</h4>
									<div class="description">${record.description}</div>
								</article>
							</div>

</c:forEach>
					</c:if>

						</div>
					</div>

				</div>
			</div>

		</div>
	</section>
</div>