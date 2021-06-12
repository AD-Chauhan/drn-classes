
<%
	request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", -1);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Calendar"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>drnclasses &#8211; Online Education Course &amp; School
	&#8211; Just another WordPress site</title>

<link rel='stylesheet'
	href="<c:url value="/resources/css/style.min.css?ver=5.2.10"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/theme.min.css?ver=5.2.10"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/style.css?ver=3.6.5"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/styles.css?ver=5.1.3"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/settings.css?ver=5.4.8.1"/>"
	type='text/css' media='all' />

<style id='woocommerce-inline-inline-css' type='text/css'>
.woocommerce form .form-row .required {
	visibility: visible;
}
</style>
<link rel='stylesheet'
	href="<c:url value="/resources/css/select2.css?ver=3.6.5"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/elementor-icons.min.css?ver=5.3.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/animations.min.css?ver=2.6.2"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/frontend.min.css?ver=2.6.2"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/font-awesome.min.css?ver=4.7.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/post-288.css?ver=1563446103"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="https://fonts.googleapis.com/css?family=Nunito:400,400i,600,600i,700,700i|Open+Sans:400,400i,600,600i,700,700i|Montserrat:400,600,700,800&#038;subset=latin%2Clatin-ext"
	type='text/css' media='all' />

<link rel='stylesheet'
	href="<c:url value="/resources/css/flaticon.css?ver=1.0.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/animate.css?ver=3.6.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/bootstrap.css?ver=3.2.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/slick.css?ver=1.8.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/magnific-popup.css?ver=1.1.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/perfect-scrollbar.css?ver=0.6.12"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/template.css?ver=1.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/style.css?ver=1.0"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/learnpress.css?nocache=1620735358.8174&#038;ver=3.2.5.6"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/css/jquery.scrollbar.css?nocache=1620735358.8174&#038;ver=3.2.5.6"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="<c:url value="/resources/contact-form-7/styles.css?ver=5.1.3"/>"
	type='text/css' media='all' />
<link rel='stylesheet'
	href="https://fonts.googleapis.com/css?family=Nunito%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic%7COpen+Sans%3A100%2C100italic%2C200%2C200italic%2C300%2C300italic%2C400%2C400italic%2C500%2C500italic%2C600%2C600italic%2C700%2C700italic%2C800%2C800italic%2C900%2C900italic&#038;ver=5.2.11"
	type='text/css' media='all' />
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.js?ver=1.12.4-wp"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery-migrate.min.js?ver=1.4.1"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.themepunch.tools.min.js?ver=5.4.8.1"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.themepunch.revolution.min.js?ver=5.4.8.1"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.alert.js?nocache=1620735358.8174&#038;ver=3.2.5.6"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/circle-bar.js?nocache=1620735358.8174&#038;ver=3.2.5.6"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.scrollbar.js?nocache=1620735358.8174&#038;ver=3.2.5.6"/>"></script>
<script type='text/javascript'
	src="<c:url value="/resources/js/jquery.scrollTo.js?nocache=1620735358.8174&#038;ver=3.2.5.6"/>"></script>


<noscript>
	<style>
.woocommerce-product-gallery {
	opacity: 1 !important;
}
</style>
</noscript>
<style type="text/css">
.recentcomments a {
	display: inline !important;
	padding: 0 !important;
	margin: 0 !important;
}
</style>

<link rel="icon"
	href="<%=request.getContextPath()%>/resources/img/cropped-favicon-1-32x32.png"
	sizes="32x32" />
<link rel="icon"
	href="<%=request.getContextPath()%>/resources/img/cropped-favicon-1-192x192.png"
	sizes="192x192" />
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/resources/img/cropped-favicon-1-180x180.png" />
<meta name="msapplication-TileImage"
	content="<%=request.getContextPath()%>/resources/img/cropped-favicon-1-270x270.png" />
<script type="text/javascript">function setREVStartSize(e){									
						try{ e.c=jQuery(e.c);var i=jQuery(window).width(),t=9999,r=0,n=0,l=0,f=0,s=0,h=0;
							if(e.responsiveLevels&&(jQuery.each(e.responsiveLevels,function(e,f){f>i&&(t=r=f,l=e),i>f&&f>r&&(r=f,n=e)}),t>r&&(l=n)),f=e.gridheight[l]||e.gridheight[0]||e.gridheight,s=e.gridwidth[l]||e.gridwidth[0]||e.gridwidth,h=i/s,h=h>1?1:h,f=Math.round(h*f),"fullscreen"==e.sliderLayout){var u=(e.c.width(),jQuery(window).height());if(void 0!=e.fullScreenOffsetContainer){var c=e.fullScreenOffsetContainer.split(",");if (c) jQuery.each(c,function(e,i){u=jQuery(i).length>0?u-jQuery(i).outerHeight(!0):u}),e.fullScreenOffset.split("%").length>1&&void 0!=e.fullScreenOffset&&e.fullScreenOffset.length>0?u-=jQuery(window).height()*parseInt(e.fullScreenOffset,0)/100:void 0!=e.fullScreenOffset&&e.fullScreenOffset.length>0&&(u-=parseInt(e.fullScreenOffset,0))}f=u}else void 0!=e.minHeight&&f<e.minHeight&&(f=e.minHeight);e.c.closest(".rev_slider_wrapper").css({height:f})					
						}catch(d){console.log("Failure at Presize of Slider:"+d)}						
					};</script>

<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/12.0.0-1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/12.0.0-1\/svg\/","svgExt":".svg","source":{"concatemoji":"resources\/js\/wp-emoji-release.min.js?ver=5.2.11"}};
			!function(e,a,t){var n,r,o,i=a.createElement("canvas"),p=i.getContext&&i.getContext("2d");function s(e,t){var a=String.fromCharCode;p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,e),0,0);e=i.toDataURL();return p.clearRect(0,0,i.width,i.height),p.fillText(a.apply(this,t),0,0),e===i.toDataURL()}function c(e){var t=a.createElement("script");t.src=e,t.defer=t.type="text/javascript",a.getElementsByTagName("head")[0].appendChild(t)}for(o=Array("flag","emoji"),t.supports={everything:!0,everythingExceptFlag:!0},r=0;r<o.length;r++)t.supports[o[r]]=function(e){if(!p||!p.fillText)return!1;switch(p.textBaseline="top",p.font="600 32px Arial",e){case"flag":return s([55356,56826,55356,56819],[55356,56826,8203,55356,56819])?!1:!s([55356,57332,56128,56423,56128,56418,56128,56421,56128,56430,56128,56423,56128,56447],[55356,57332,8203,56128,56423,8203,56128,56418,8203,56128,56421,8203,56128,56430,8203,56128,56423,8203,56128,56447]);case"emoji":return!s([55357,56424,55356,57342,8205,55358,56605,8205,55357,56424,55356,57340],[55357,56424,55356,57342,8203,55358,56605,8203,55357,56424,55356,57340])}return!1}(o[r]),t.supports.everything=t.supports.everything&&t.supports[o[r]],"flag"!==o[r]&&(t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&t.supports[o[r]]);t.supports.everythingExceptFlag=t.supports.everythingExceptFlag&&!t.supports.flag,t.DOMReady=!1,t.readyCallback=function(){t.DOMReady=!0},t.supports.everything||(n=function(){t.readyCallback()},a.addEventListener?(a.addEventListener("DOMContentLoaded",n,!1),e.addEventListener("load",n,!1)):(e.attachEvent("onload",n),a.attachEvent("onreadystatechange",function(){"complete"===a.readyState&&t.readyCallback()})),(n=t.source||{}).concatemoji?c(n.concatemoji):n.wpemoji&&n.twemoji&&(c(n.twemoji),c(n.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
<style type="text/css">
img.wp-smiley, img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}
</style>
<style>
.multicolor-bg {
	background-size: cover !important;
	background-position: 0 0;
	background-image: -webkit-linear-gradient(left, #2441e7 0%, #ff1053 100%)
		!important;
	background-image: -o-linear-gradient(left, #2441e7 0%, #ff1053 100%)
		!important;
	background-image: linear-gradient(to right, #24e772 0%, #1f25e8 100%)
		!important;
	background-repeat: repeat-x !important;
}
</style>
<style type="text/css" id="wp-custom-css">
.elementor-element.elementor-widget-image-carousel .elementor-slick-slider .slick-slide-inner:before
	{
	z-index: auto;
}

.main-sticky-header {
	-webkit-transition: all 0.4s ease-in-out 0s;
	-o-transition: all 0.4s ease-in-out 0s;
	transition: all 0.4s ease-in-out 0s;
}

@media ( min-width : 1200px) {
	.apus-footer .widget-contact-intro .menu li, .apus-footer .widget-nav-menu.dark .menu li,
		.apus-footer .widget-nav-menu.vertical .menu li {
		margin-bottom: 10px;
	}
	.apus-footer .widget-contact-intro .menu li:last-child, .apus-footer .widget-nav-menu.dark .menu li:last-child,
		.apus-footer .widget-nav-menu.vertical .menu li:last-child {
		margin-bottom: 0;
	}
}

.tp-bgimg {
	color: #fff;
	background: -webkit-linear-gradient(-70deg, #fa7c30 30%, rgba(0, 0, 0, 0)
		30%),
		url('<%=request.getContextPath()%>/resources/img/home1-slider-1-100x50.jpg');
	background: -o-linear-gradient(-70deg, #fa7c30 30%, rgba(0, 0, 0, 0) 30%),
		url('<%=request.getContextPath()%>/resources/img/home1-slider-1-100x50.jpg');
	background: -moz-linear-gradient(-70deg, #fa7c30 30%, rgba(0, 0, 0, 0)
		30%),
		url('<%=request.getContextPath()%>/resources/img/home1-slider-1-100x50.jpg');
	background: linear-gradient(-70deg, #fa7c30 30%, rgba(0, 0, 0, 0) 30%),
		url('<%=request.getContextPath()%>/resources/img/home1-slider-1-100x50.jpg');
	background-size: cover;
	background-position: 50% 21%;
	text-align: right;
}
</style>
</head>
<body
	class="home page-template-default page page-id-288 wp-embed-responsive woocommerce-no-js header_transparent apus-body-loading body-footer-mobile has-header-sticky elementor-default elementor-page elementor-page-288">

	<div id="wrapper-container" class="wrapper-container">


		<div id="apus-header "
			class="multicolor-bg  multicolor-bg apus-header hidden-xs hidden-md hidden-sm header-default-302">
			<div class="main-sticky-header-wrapper">
				<div class="main-sticky-header">
					<div data-elementor-type="post" data-elementor-id="302"
						class="elementor elementor-302" data-elementor-settings="[]">
						<div class="elementor-inner">
							<div class="elementor-section-wrap">
								<section
									class="elementor-element elementor-element-8a6d5c3 elementor-section-stretched elementor-section-full_width elementor-section-height-default elementor-section-height-default elementor-section elementor-top-section"
									data-id="8a6d5c3" data-element_type="section"
									data-settings="{&quot;stretch_section&quot;:&quot;section-stretched&quot;}">
								<div class="elementor-container elementor-column-gap-extended">
									<div class="elementor-row">
										<div
											class="elementor-element elementor-element-b8645e8 elementor-column elementor-col-50 elementor-top-column"
											data-id="b8645e8" data-element_type="column">
											<div
												class="elementor-column-wrap  elementor-element-populated">
												<div class="elementor-widget-wrap">
													<div
														class="elementor-element elementor-element-1aef04e elementor-widget__width-auto elementor-widget elementor-widget-drnclasses_logo"
														data-id="1aef04e" data-element_type="widget"
														data-widget_type="drnclasses_logo.default">
														<div class="elementor-widget-container">
															<div class="logo custom-logo">
																<a href="#"> <span class="logo-main"> <img
																		width="720" height="280"
																		src="<%=request.getContextPath()%>/resources/img/logo-blue.png"
																		class="attachment-full size-full" alt=""
																		srcset="<%=request.getContextPath()%>/resources/img/logo-blue.png 720w, <%=request.getContextPath()%>/resources/img/logo-blue-300x117.png 300w, <%=request.getContextPath()%>/resources/img/logo-blue-600x233.png 600w"
																		sizes="(max-width: 720px) 100vw, 720px" />
																</span> <span class="transparent-logo"> <img width="715"
																		height="280"
																		src="<%=request.getContextPath()%>/resources/img/logo-white.png"
																		class="attachment-full size-full" alt=""
																		srcset="<%=request.getContextPath()%>/resources/img/logo-white.png 715w, <%=request.getContextPath()%>/resources/img/logo-white-300x117.png 300w, <%=request.getContextPath()%>/resources/img/logo-white-600x235.png 600w"
																		sizes="(max-width: 715px) 100vw, 715px" />
																</span>
																</a>
															</div>
														</div>
													</div>
													<div
														class="elementor-element elementor-element-736be12 elementor-widget__width-auto elementor-widget elementor-widget-drnclasses_primary_menu"
														data-id="736be12" data-element_type="widget"
														data-widget_type="drnclasses_primary_menu.default">
														<div class="elementor-widget-container">
															<div class="main-menu  menu-border">
																<nav data-duration="400"
																	class="apus-megamenu slide animate navbar"
																	role="navigation">
																<div class="collapse navbar-collapse no-padding">
																	<ul id="primary-menu"
																		class="nav navbar-nav megamenu effect1">
																		<li class="dropdown active menu-item-312 aligned-left">
																			<a href="<%=request.getContextPath()%>/home-page">Home
																		</a>

																		</li>
																		<li class="menu-item-313 has-mega-menu aligned-left"><a
																			href="<%=request.getContextPath()%>/course-details">Courses
																		</a></li>

																		<li class="dropdown menu-item-310 aligned-left"><a
																			href="<%=request.getContextPath()%>/blog-details">Blog
																		</a></li>
																		<li class="menu-item-311 aligned-left"><a
																			href="<%=request.getContextPath()%>/contact-details">Contact
																				Us</a></li>
																				
																				
																	</ul>
																</div>
																</nav>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div
											class="elementor-element elementor-element-5a41ec2 elementor-column elementor-col-50 elementor-top-column"
											>
											<div
												class="elementor-column-wrap  elementor-element-populated">
												<div class="elementor-widget-wrap">
													<div
														class="elementor-element elementor-element-ddf1b2f elementor-widget__width-auto elementor-widget elementor-widget-edumy_user_info"
														>
														<div class="elementor-widget-container">
															<div class="account-login">
																<ul class="login-account white" style="color: #24e473; text-transform: uppercase;">
																	<li class="icon-log"><span
																		class="apus-user-login"><i
																			class="flaticon-user"></i></span></li>
																	<li><span
																		class="apus-user-login wel-user">Login User Name</span></li>
																	
																</ul>
																<ul class="login-account white" style="color: #24e473; text-transform: uppercase;">
																	<c:set var="today" value="<%=new Date()%>"/>	
																	<li><span
																		class="apus-user-login wel-user">LAST LOGIN TIME : <fmt:formatDate type="date" value="${today}" pattern="dd-MM-yyyy HH:mm:ss"/></span></li>	
																	
																</ul>
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
						</div>
					</div>
				</div>
			</div>
		</div>

		<tiles:insertAttribute name="body" />

		<div id="apus-footer"
			class="apus-footer footer-builder-wrapper footer-default">
			<div class="apus-footer-inner">
				<div data-elementor-type="post" data-elementor-id="375"
					class="elementor elementor-375" data-elementor-settings="[]">
					<div class="elementor-inner">
						<div class="elementor-section-wrap">

							<section
								class="multicolor-bg elementor-element elementor-element-15138da elementor-section-stretched elementor-section-boxed elementor-section-height-default elementor-section-height-default elementor-section elementor-top-section"
								data-id="15138da" data-element_type="section"
								data-settings="{&quot;stretch_section&quot;:&quot;section-stretched&quot;,&quot;background_background&quot;:&quot;classic&quot;}">
							<div class="elementor-container elementor-column-gap-extended">
								<div class="elementor-row">
									<div
										class="elementor-element elementor-element-b3a96e9 sm-center elementor-column elementor-col-50 elementor-top-column"
										data-id="b3a96e9" data-element_type="column">
										<div
											class="elementor-column-wrap  elementor-element-populated">
											<div class="elementor-widget-wrap">
												<div
													class="elementor-element elementor-element-0aa2e1d elementor-widget__width-auto elementor-widget elementor-widget-drnclasses_logo"
													data-id="0aa2e1d" data-element_type="widget"
													data-widget_type="drnclasses_logo.default">
													<div class="elementor-widget-container">
														<div class="logo custom-logo footer-logo">
															<a href="https://demoapus.com/drnclasses/"> <span
																class="logo-main"> <img width="715" height="280"
																	src="<%=request.getContextPath()%>/resources/img/logo-white.png"
																	class="attachment-full size-full" alt=""
																	srcset="<%=request.getContextPath()%>/resources/img/logo-white.png 715w, <%=request.getContextPath()%>/resources/img/logo-white-300x117.png 300w, <%=request.getContextPath()%>/resources/img/logo-white-600x235.png 600w"
																	sizes="(max-width: 715px) 100vw, 715px" />
															</span> <span class="transparent-logo"> <img width="715"
																	height="280"
																	src="<%=request.getContextPath()%>/resources/img/logo-white.png"
																	class="attachment-full size-full" alt=""
																	srcset="<%=request.getContextPath()%>/resources/img/logo-white.png 715w, <%=request.getContextPath()%>/resources/img/logo-white-300x117.png 300w, <%=request.getContextPath()%>/resources/img/logo-white-600x235.png 600w"
																	sizes="(max-width: 715px) 100vw, 715px" />
															</span>
															</a>
														</div>
													</div>
												</div>
												<div
													class="elementor-element elementor-element-d0d7db2 elementor-widget__width-auto elementor-widget elementor-widget-drnclasses_nav_menu"
													data-id="d0d7db2" data-element_type="widget"
													data-widget_type="drnclasses_nav_menu.default">
													<div class="elementor-widget-container">
														<div class="widget-nav-menu  horizontal_dark">
															<div class="widget-content">
																<div class="menu-footer-4-container">
																	<ul id="menu-footer-4" class="menu">
																		<li id="menu-item-427"
																			class="menu-item menu-item-type-post_type menu-item-object-page menu-item-home current-menu-item page_item page-item-288 current_page_item menu-item-427 active  active  active "><a
																			href="https://demoapus.com/drnclasses/"
																			aria-current="page">Home</a></li>
																		<li id="menu-item-428"
																			class="menu-item menu-item-type-custom menu-item-object-custom menu-item-428"><a
																			href="http://192.168.1.123/wordpress-work/drnclasses">Privacy</a></li>
																		<li id="menu-item-429"
																			class="menu-item menu-item-type-custom menu-item-object-custom menu-item-429"><a
																			href="http://192.168.1.123/wordpress-work/drnclasses">Terms</a></li>
																		<li id="menu-item-430"
																			class="menu-item menu-item-type-custom menu-item-object-custom menu-item-430"><a
																			href="http://192.168.1.123/wordpress-work/drnclasses">Sitemap</a></li>
																		<li id="menu-item-431"
																			class="menu-item menu-item-type-custom menu-item-object-custom menu-item-431"><a
																			href="http://192.168.1.123/wordpress-work/drnclasses">Purchase</a></li>
																	</ul>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div
										class="elementor-element elementor-element-df6986d sm-center elementor-column elementor-col-50 elementor-top-column"
										data-id="df6986d" data-element_type="column">
										<div
											class="elementor-column-wrap  elementor-element-populated">
											<div class="elementor-widget-wrap">
												<div
													class="elementor-element elementor-element-df08e7f elementor-widget elementor-widget-drnclasses_social_links"
													data-id="df08e7f" data-element_type="widget"
													data-widget_type="drnclasses_social_links.default">
													<div class="elementor-widget-container">
														<div class="widget-social  right dark">
															<ul class="social list-inline">
																<li><a href="https://www.facebook.com/"> <i
																		class="fa fa-facebook"></i>
																</a></li>
																<li><a href="https://twitter.com/"> <i
																		class="fa fa-twitter"></i>
																</a></li>
																<li><a href="https://www.pinterest.com/"> <i
																		class="fa fa-pinterest"></i>
																</a></li>
																<li><a href="https://accounts.google.com"> <i
																		class="fa fa-google"></i>
																</a></li>
																<li><a href="https://www.linkedin.com/"> <i
																		class="fa fa-linkedin"></i>
																</a></li>
																<li><a href="https://www.instagram.com/"> <i
																		class="fa fa-instagram"></i>
																</a></li>
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							</section>
							<section
								class="elementor-element elementor-element-32371c4 elementor-section-stretched elementor-section-boxed elementor-section-height-default elementor-section-height-default elementor-section elementor-top-section"
								data-id="32371c4" data-element_type="section"
								data-settings="{&quot;stretch_section&quot;:&quot;section-stretched&quot;,&quot;background_background&quot;:&quot;classic&quot;}">
							<div class="elementor-container elementor-column-gap-extended">
								<div class="elementor-row">
									<div
										class="elementor-element elementor-element-a5e6f9b elementor-column elementor-col-100 elementor-top-column"
										data-id="a5e6f9b" data-element_type="column">
										<div
											class="elementor-column-wrap  elementor-element-populated">
											<div class="elementor-widget-wrap">
												<div
													class="elementor-element elementor-element-2d5a20a elementor-widget__width-auto elementor-widget elementor-widget-text-editor"
													data-id="2d5a20a" data-element_type="widget"
													data-widget_type="text-editor.default">
													<div class="elementor-widget-container">
														<div class="elementor-text-editor elementor-clearfix">
															<div class="widget-copyright dark">
																Copyright <a
																	href="http://192.168.1.123/wordpress-work/drnclasses">D.R.N.
																	CLASSES</a> © 2021. All Rights Reserved
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
					</div>
				</div>
			</div>
		</div>
		<a href="#" id="back-to-top" class="add-fix-top"> <i
			class="flaticon-up-arrow-1" aria-hidden="true"></i>
		</a>
	</div>

	<link rel='stylesheet'
		href="<c:url value="/resources/css/post-2663.css?ver=1563247661"/>"
		type='text/css' media='all' />
	<link rel='stylesheet'
		href="<c:url value="/resources/css/post-2709.css?ver=1563247661"/>"
		type='text/css' media='all' />
	<link rel='stylesheet'
		href="<c:url value="/resources/css/post-302.css?ver=1571822342"/>"
		type='text/css' media='all' />
	<link rel='stylesheet'
		href="<c:url value="/resources/css/post-375.css?ver=1563334802"/>"
		type='text/css' media='all' />
	<script type='text/javascript'
		src="<c:url value="/resources/js/bootstrap.min.js?ver=20150330"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/slick.min.js?ver=1.8.0"/>"></script>

	<script type='text/javascript'
		src="<c:url value="/resources/js/jquery.magnific-popup.min.js?ver=1.1.0"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/jquery.unveil.js?ver=1.1.0"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/perfect-scrollbar.jquery.min.js?ver=0.6.12"/>"></script>

	<script type='text/javascript'
		src="<c:url value="/resources/js/functions.js?ver=20150330"/>"></script>
	<script type='text/javascript'>
(function(html){html.className = html.className.replace(/\bno-js\b/,'js')})(document.documentElement);
</script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/gmap3.js?ver=20131022"/>"></script>

	<script type='text/javascript'
		src="<c:url value="/resources/js/jquery.blockUI.min.js?ver=2.70"/>"></script>




	<script type='text/javascript'
		src="<c:url value="/resources/js/wp-embed.min.js?ver=5.2.10"/>"></script>


	<script type='text/javascript'
		src="<c:url value="/resources/js/frontend-modules.min.js?ver=2.6.2"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/position.min.js?ver=1.11.4"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/dialog.min.js?ver=4.7.1"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/waypoints.min.js?ver=4.0.2"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/swiper.min.js?ver=4.4.6"/>"></script>
	<script type='text/javascript'>
var elementorFrontendConfig = {"environmentMode":{"edit":false,"wpPreview":false},"is_rtl":"","breakpoints":{"xs":0,"sm":480,"md":768,"lg":1025,"xl":1440,"xxl":1600},"settings":{"page":[],"general":{"elementor_global_image_lightbox":"yes","elementor_enable_lightbox_in_editor":"yes"}},"post":{"id":288,"title":"Home","excerpt":""}};
</script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/frontend.min.js?ver=2.6.2"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/extensions/revolution.extension.slideanims.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/extensions/revolution.extension.layeranimation.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/extensions/revolution.extension.navigation.min.js"/>"></script>

	<script type='text/javascript'>
var mejsL10n = {"language":"en","strings":{"mejs.install-flash":"You are using a browser that does not have Flash player enabled or installed. Please turn on your Flash player plugin or download the latest version from https:\/\/get.adobe.com\/flashplayer\/","mejs.fullscreen-off":"Turn off Fullscreen","mejs.fullscreen-on":"Go Fullscreen","mejs.download-video":"Download Video","mejs.fullscreen":"Fullscreen","mejs.time-jump-forward":["Jump forward 1 second","Jump forward %1 seconds"],"mejs.loop":"Toggle Loop","mejs.play":"Play","mejs.pause":"Pause","mejs.close":"Close","mejs.time-slider":"Time Slider","mejs.time-help-text":"Use Left\/Right Arrow keys to advance one second, Up\/Down arrows to advance ten seconds.","mejs.time-skip-back":["Skip back 1 second","Skip back %1 seconds"],"mejs.captions-subtitles":"Captions\/Subtitles","mejs.captions-chapters":"Chapters","mejs.none":"None","mejs.mute-toggle":"Mute Toggle","mejs.volume-help-text":"Use Up\/Down Arrow keys to increase or decrease volume.","mejs.unmute":"Unmute","mejs.mute":"Mute","mejs.volume-slider":"Volume Slider","mejs.video-player":"Video Player","mejs.audio-player":"Audio Player","mejs.ad-skip":"Skip ad","mejs.ad-skip-info":["Skip in 1 second","Skip in %1 seconds"],"mejs.source-chooser":"Source Chooser","mejs.stop":"Stop","mejs.speed-rate":"Speed Rate","mejs.live-broadcast":"Live Broadcast","mejs.afrikaans":"Afrikaans","mejs.albanian":"Albanian","mejs.arabic":"Arabic","mejs.belarusian":"Belarusian","mejs.bulgarian":"Bulgarian","mejs.catalan":"Catalan","mejs.chinese":"Chinese","mejs.chinese-simplified":"Chinese (Simplified)","mejs.chinese-traditional":"Chinese (Traditional)","mejs.croatian":"Croatian","mejs.czech":"Czech","mejs.danish":"Danish","mejs.dutch":"Dutch","mejs.english":"English","mejs.estonian":"Estonian","mejs.filipino":"Filipino","mejs.finnish":"Finnish","mejs.french":"French","mejs.galician":"Galician","mejs.german":"German","mejs.greek":"Greek","mejs.haitian-creole":"Haitian Creole","mejs.hebrew":"Hebrew","mejs.hindi":"Hindi","mejs.hungarian":"Hungarian","mejs.icelandic":"Icelandic","mejs.indonesian":"Indonesian","mejs.irish":"Irish","mejs.italian":"Italian","mejs.japanese":"Japanese","mejs.korean":"Korean","mejs.latvian":"Latvian","mejs.lithuanian":"Lithuanian","mejs.macedonian":"Macedonian","mejs.malay":"Malay","mejs.maltese":"Maltese","mejs.norwegian":"Norwegian","mejs.persian":"Persian","mejs.polish":"Polish","mejs.portuguese":"Portuguese","mejs.romanian":"Romanian","mejs.russian":"Russian","mejs.serbian":"Serbian","mejs.slovak":"Slovak","mejs.slovenian":"Slovenian","mejs.spanish":"Spanish","mejs.swahili":"Swahili","mejs.swedish":"Swedish","mejs.tagalog":"Tagalog","mejs.thai":"Thai","mejs.turkish":"Turkish","mejs.ukrainian":"Ukrainian","mejs.vietnamese":"Vietnamese","mejs.welsh":"Welsh","mejs.yiddish":"Yiddish"}};
</script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/mediaelement-and-player.min.js?ver=4.2.6-78496d1"/>"></script>

	<script type='text/javascript'
		src="<c:url value="/resources/js/mediaelement-migrate.min.js?ver=5.2.11"/>"></script>
	<script type='text/javascript'>
/* <![CDATA[ */
var _wpmejsSettings = {"pluginPath":"\/js\/","classPrefix":"mejs-","stretching":"responsive"};
/* ]]> */
</script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/wp-mediaelement.min.js?ver=5.2.11"/>"></script>
	<script type='text/javascript'
		src="<c:url value="/resources/js/vimeo.min.js?ver=4.2.6-78496d1"/>"></script>


</body>
</html>