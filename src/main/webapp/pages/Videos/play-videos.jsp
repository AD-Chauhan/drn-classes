<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/resources/player/css/plyr.css'>

<style>
/* This is purely for the demo */
.plyr {
	border-radius: 0px;
	margin-bottom: 15px;
	height: 600px !important;
}
</style>


<div id="apus-main-content">
	<section id="apus-breadscrumb"
		class="breadcrumb-page apus-breadscrumb has_bg"
		style="background-image: url('./resources/img/bg_1.jpg')">
		<div class="container">
			<div class="wrapper-breads">
				<div class="wrapper-breads-inner">
					<h2 class="bread-title">${finalList.videoName}</h2>

				</div>
			</div>
		</div>
	</section>
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
														<h2 class="title">${finalList.videoTitle}<br>${finalList.videoName}</h2>
													</div>

												</div>
											</div>
											<div class="course-video">
												<div style="width: 640px;" class="wp-video">
													<%-- <video controls crossorigin playsinline poster="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.jpg" id="player">
                <!-- Video files -->
                <source src="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-576p.mp4" type="video/mp4" size="576">
                <source src="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-720p.mp4" type="video/mp4" size="720">
                <source src="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-1080p.mp4" type="video/mp4" size="1080">
                <source src="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-1440p.mp4" type="video/mp4" size="1440">

                <!-- Caption files -->
                <track kind="captions" label="English" srclang="en" src="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.en.vtt"
                    default>
                <track kind="captions" label="Français" srclang="fr" src="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-HD.fr.vtt">
                <a href="https://cdn.plyr.io/static/demo/View_From_A_Blue_Moon_Trailer-576p.mp4" download>Download</a>
            </video>
  
  <div class="actions">
    <button type="button" class="btn js-play">Play</button>
    <button type="button" class="btn js-pause">Pause</button>
    <button type="button" class="btn js-stop">Stop</button>
    <button type="button" class="btn js-rewind">Rewind</button>
    <button type="button" class="btn js-forward">Forward</button>
  </div> --%>
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
									<div class="course-rating clearfix">
										<h3 class="widget-title">
											<span>Reviews</span>
										</h3>
										<div class="box-inner">
											<div class="detailed-rating">
												<div class="rating-box">
													<div class="detailed-rating-inner">
														<div class="skill">
															<div class="key">5 stars</div>
															<div class="progress">
																<div class="progress-bar progress-bar-success"
																	style="width: 0%"></div>
															</div>
															<div class="value">0</div>
														</div>
														<div class="skill">
															<div class="key">4 stars</div>
															<div class="progress">
																<div class="progress-bar progress-bar-success"
																	style="width: 0%"></div>
															</div>
															<div class="value">0</div>
														</div>
														<div class="skill">
															<div class="key">3 stars</div>
															<div class="progress">
																<div class="progress-bar progress-bar-success"
																	style="width: 50%"></div>
															</div>
															<div class="value">1</div>
														</div>
														<div class="skill">
															<div class="key">2 stars</div>
															<div class="progress">
																<div class="progress-bar progress-bar-success"
																	style="width: 50%"></div>
															</div>
															<div class="value">1</div>
														</div>
														<div class="skill">
															<div class="key">1 stars</div>
															<div class="progress">
																<div class="progress-bar progress-bar-success"
																	style="width: 0%"></div>
															</div>
															<div class="value">0</div>
														</div>
													</div>
												</div>
											</div>
											<div class="average-rating pull-right">
												<div class="rating-box">
													<div class="average-value">2.5</div>
													<div class="review-star">
														<div class="review-stars-rated-wrapper">
															<div class="review-stars-rated">
																<ul class="review-stars">
																	<li><span class="fa fa-star-o"></span></li>
																	<li><span class="fa fa-star-o"></span></li>
																	<li><span class="fa fa-star-o"></span></li>
																	<li><span class="fa fa-star-o"></span></li>
																	<li><span class="fa fa-star-o"></span></li>
																</ul>
																<ul class="review-stars filled" style="width: 50%">
																	<li><span class="fa fa-star"></span></li>
																	<li><span class="fa fa-star"></span></li>
																	<li><span class="fa fa-star"></span></li>
																	<li><span class="fa fa-star"></span></li>
																	<li><span class="fa fa-star"></span></li>
																</ul>
															</div>
														</div>
													</div>
													<div class="review-amount">2 ratings</div>
												</div>
											</div>
										</div>
									</div>
									<div id="comments">
										<ol class="comment-list">
											<li
												class="comment byuser comment-author-admin bypostauthor even thread-even depth-1"
												id="li-comment-40">
												<div id="comment-40" class="the-comment media">
													<div class="avatar media-left">
														<img alt="Admin bar avatar"
															src="https://demoapus.com/edumy/wp-content/uploads/learn-press-profile/1/2c96295e8d5ff3d84ab22427a45721ae.png"
															class="avatar avatar-80 photo" height="80" width="80">
													</div>
													<div class="comment-box media-body">
														<div class="meta">
															<h3 class="title-author">admin</h3>
															<div class="info-meta">
																<span class="meta"> <time>May 29, 2019</time>
																</span>
															</div>
															<div class="star-rating clear pull-right"
																title="Rated 3 out of 5">
																<div class="review-stars-rated-wrapper">
																	<div class="review-stars-rated">
																		<ul class="review-stars">
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																		</ul>
																		<ul class="review-stars filled" style="width: 60%">
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																		</ul>
																	</div>
																</div>
															</div>
														</div>
														<div itemprop="description" class="comment-text">
															<p>Amet tellus cras adipiscing enim eu turpis egestas
																pretium. Amet mauris commodo quis imperdiet massa
																tincidunt nunc pulvinar. Viverra justo nec ultrices dui
																sapien eget mi proin. Velit dignissim sodales ut eu sem
																integer vitae justo eget.</p>
														</div>
														<div id="comment-reply-wrapper-40">
															<a rel="nofollow" class="comment-reply-link"
																href="/edumy/courses/the-complete-shopify-aliexpress-dropship/?replytocom=40#respond"
																data-commentid="40" data-postid="655"
																data-belowelement="comment-reply-wrapper-40"
																data-respondelement="respond"
																aria-label="Reply to admin">Reply</a>
														</div>
													</div>
												</div>
											</li>
											<ul class="children">
												<li
													class="comment byuser comment-author-admin bypostauthor odd alt depth-2"
													id="li-comment-79">
													<div id="comment-79" class="the-comment media">
														<div class="avatar media-left">
															<img alt="Admin bar avatar"
																src="https://demoapus.com/edumy/wp-content/uploads/learn-press-profile/1/2c96295e8d5ff3d84ab22427a45721ae.png"
																class="avatar avatar-80 photo" height="80" width="80">
														</div>
														<div class="comment-box media-body">
															<div class="meta">
																<h3 class="title-author">Afell Liberia</h3>
																<div class="info-meta">
																	<span class="meta"> <time>July 11, 2019</time>
																	</span>
																</div>
																<div class="star-rating clear pull-right"
																	title="Rated 0 out of 5">
																	<div class="review-stars-rated-wrapper">
																		<div class="review-stars-rated">
																			<ul class="review-stars">
																				<li><span class="fa fa-star-o"></span></li>
																				<li><span class="fa fa-star-o"></span></li>
																				<li><span class="fa fa-star-o"></span></li>
																				<li><span class="fa fa-star-o"></span></li>
																				<li><span class="fa fa-star-o"></span></li>
																			</ul>
																			<ul class="review-stars filled" style="width: 0%">
																				<li><span class="fa fa-star"></span></li>
																				<li><span class="fa fa-star"></span></li>
																				<li><span class="fa fa-star"></span></li>
																				<li><span class="fa fa-star"></span></li>
																				<li><span class="fa fa-star"></span></li>
																			</ul>
																		</div>
																	</div>
																</div>
															</div>
															<div itemprop="description" class="comment-text">
																<p>
																	This is the second Photoshop course I have completed
																	with Cristian. Worth every penny and recommend it
																	highly. To get the most out of this course, its best to
																	to take the Beginner to Advanced course first.<br>
																	The sound and video quality is of a good standard.
																	Thank you Cristian.
																</p>
															</div>
															<div id="comment-reply-wrapper-79">
																<a rel="nofollow" class="comment-reply-link"
																	href="/edumy/courses/the-complete-shopify-aliexpress-dropship/?replytocom=79#respond"
																	data-commentid="79" data-postid="655"
																	data-belowelement="comment-reply-wrapper-79"
																	data-respondelement="respond"
																	aria-label="Reply to Afell Liberia">Reply</a>
															</div>
															<div id="respond" class="comment-respond">
																<h3 id="reply-title" class="comment-reply-title">
																	Reply comment <small><a rel="nofollow"
																		id="cancel-comment-reply-link"
																		href="/edumy/courses/the-complete-shopify-aliexpress-dropship/#respond"
																		style="">Cancel reply</a></small>
																</h3>
																<form
																	action="https://demoapus.com/edumy/wp-comments-post.php"
																	method="post" id="commentform" class="comment-form"
																	novalidate="">
																	<div class="row">
																		<div class="col-xs-12 col-sm-12">
																			<div class="form-group">
																				<label>Name</label><input id="author"
																					class="form-control" placeholder="Your Name"
																					name="author" type="text" value="" size="30"
																					aria-required="true">
																			</div>
																		</div>
																		<div class="col-xs-12 col-sm-12">
																			<div class="form-group">
																				<label>Email</label><input id="email"
																					placeholder="your@mail.com" class="form-control"
																					name="email" type="text" value="" size="30"
																					aria-required="true">
																			</div>
																		</div>
																		<div class="col-xs-12 col-sm-12">
																			<div class="form-group">
																				<label>Website</label> <input id="url" name="url"
																					placeholder="Your Website" class="form-control"
																					type="text" value="">
																			</div>
																		</div>
																	</div>
																	<p class="comment-form-cookies-consent">
																		<input id="wp-comment-cookies-consent"
																			name="wp-comment-cookies-consent" type="checkbox"
																			value="yes"><label
																			for="wp-comment-cookies-consent">Save my
																			name, email, and website in this browser for the next
																			time I comment.</label>
																	</p>
																	<div class="form-group">
																		<textarea placeholder="Write Comment" id="comment"
																			class="form-control" name="comment" cols="45"
																			rows="5" aria-required="true"></textarea>
																	</div>
																	<p class="form-submit">
																		<input name="submit" type="submit" id="submit"
																			class="btn btn-theme " value="Submit"> <input
																			type="hidden" name="comment_post_ID" value="655"
																			id="comment_post_ID"> <input type="hidden"
																			name="comment_parent" id="comment_parent" value="79">
																	</p>
																	<input type="hidden" name="comment-post-item-course"
																		value="655">
																</form>
															</div>
														</div>
													</div>
												</li>
											</ul>

											<li
												class="comment byuser comment-author-admin bypostauthor even thread-odd thread-alt depth-1"
												id="li-comment-41">
												<div id="comment-41" class="the-comment media">
													<div class="avatar media-left">
														<img alt="Admin bar avatar"
															src="https://demoapus.com/edumy/wp-content/uploads/learn-press-profile/1/2c96295e8d5ff3d84ab22427a45721ae.png"
															class="avatar avatar-80 photo" height="80" width="80">
													</div>
													<div class="comment-box media-body">
														<div class="meta">
															<h3 class="title-author">admin</h3>
															<div class="info-meta">
																<span class="meta"> <time>May 29, 2019</time>
																</span>
															</div>
															<div class="star-rating clear pull-right"
																title="Rated 2 out of 5">
																<div class="review-stars-rated-wrapper">
																	<div class="review-stars-rated">
																		<ul class="review-stars">
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																			<li><span class="fa fa-star-o"></span></li>
																		</ul>
																		<ul class="review-stars filled" style="width: 40%">
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																			<li><span class="fa fa-star"></span></li>
																		</ul>
																	</div>
																</div>
															</div>
														</div>
														<div itemprop="description" class="comment-text">
															<p>Amet tellus cras adipiscing enim eu turpis egestas
																pretium. Amet mauris commodo quis imperdiet massa
																tincidunt nunc pulvinar. Viverra justo nec ultrices dui
																sapien eget mi proin. Velit dignissim sodales ut eu sem
																integer vitae justo eget.</p>
														</div>
														<div id="comment-reply-wrapper-41">
															<a rel="nofollow" class="comment-reply-link"
																href="/edumy/courses/the-complete-shopify-aliexpress-dropship/?replytocom=41#respond"
																data-commentid="41" data-postid="655"
																data-belowelement="comment-reply-wrapper-41"
																data-respondelement="respond"
																aria-label="Reply to admin">Reply</a>
														</div>
													</div>
												</div>
											</li>
										</ol>
									</div>
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
														<h3 id="reply-title" class="comment-reply-title">
															Add a review <small><a rel="nofollow"
																id="cancel-comment-reply-link"
																href="/edumy/courses/the-complete-shopify-aliexpress-dropship/#respond"
																style="display: none;">Cancel reply</a></small>
														</h3>
														<form
															action="https://demoapus.com/edumy/wp-comments-post.php"
															method="post" id="commentform" class="comment-form"
															novalidate="">
															<div class="row">
																<div class="col-xs-12 col-sm-12">
																	<div class="form-group">
																		<label>Name</label><input id="author"
																			placeholder="Your Name" class="form-control"
																			name="author" type="text" value="" size="30"
																			aria-required="true">
																	</div>
																</div>
																<div class="col-xs-12 col-sm-12">
																	<div class="form-group">
																		<label>Email</label><input id="email"
																			placeholder="your@mail.com" class="form-control"
																			name="email" type="text" value="" size="30"
																			aria-required="true">
																	</div>
																</div>
																<div class="col-xs-12 col-sm-12">
																	<div class="form-group">
																		<label>Website</label> <input id="url"
																			placeholder="Your Website" name="url"
																			class="form-control" type="text" value="">
																	</div>
																</div>
															</div>
															<p class="comment-form-cookies-consent">
																<input id="wp-comment-cookies-consent"
																	name="wp-comment-cookies-consent" type="checkbox"
																	value="yes"><label
																	for="wp-comment-cookies-consent">Save my name,
																	email, and website in this browser for the next time I
																	comment.</label>
															</p>
															<div class="choose-rating clearfix">
																<div class="choose-rating-inner">
																	<div class="form-group yourview">
																		<div class="comment-form-rating">
																			<label for="rating">What is it like to
																				Course?</label>
																			<div class="review-stars-wrap">
																				<ul class="review-stars">
																					<li><span class="fa fa-star-o"></span></li>
																					<li><span class="fa fa-star-o"></span></li>
																					<li><span class="fa fa-star-o"></span></li>
																					<li><span class="fa fa-star-o"></span></li>
																					<li><span class="fa fa-star-o"></span></li>
																				</ul>
																				<ul class="review-stars filled">
																					<li><span class="fa fa-star"></span></li>
																					<li><span class="fa fa-star"></span></li>
																					<li><span class="fa fa-star"></span></li>
																					<li><span class="fa fa-star"></span></li>
																					<li><span class="fa fa-star"></span></li>
																				</ul>
																			</div>
																			<input type="hidden" value="5" name="rating"
																				id="apus_input_rating">
																		</div>
																	</div>
																</div>
															</div>
															<div class="form-group">
																<label>Review</label>
																<textarea id="comment" class="form-control"
																	placeholder="Write Review" name="comment" cols="45"
																	rows="5" aria-required="true"></textarea>
															</div>
															<p class="form-submit">
																<input name="submit" type="submit" id="submit"
																	class="btn btn-theme " value="Submit Review"> <input
																	type="hidden" name="comment_post_ID" value="655"
																	id="comment_post_ID"> <input type="hidden"
																	name="comment_parent" id="comment_parent" value="0">
															</p>
															<input type="hidden" name="comment-post-item-course"
																value="655">
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