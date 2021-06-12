<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link rel='stylesheet' href='<%=request.getContextPath()%>/resources/player/css/plyr.css'>
  
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
				<video 
       controls
            crossorigin
            playsinline
            data-poster="<%=request.getContextPath()%>${finalList.thumbnailPath}${finalList.thumbnailFileName}" class="js-player">
  <!-- Video files -->
            <source
              src="<%=request.getContextPath()%>${finalList.originalPath}${finalList.originalFileName}"
              type="video/mp4"
              size="576"
            />
            <source
              src="<%=request.getContextPath()%>${finalList.originalPath}${finalList.originalFileName}"
              type="video/mp4"
              size="720"
            />
            <source
              src="<%=request.getContextPath()%>${finalList.originalPath}${finalList.originalFileName}"
              type="video/mp4"
              size="1080"
            />

    

</video>								</div>
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
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<script src="<%=request.getContextPath()%>/resources/player/js/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>

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