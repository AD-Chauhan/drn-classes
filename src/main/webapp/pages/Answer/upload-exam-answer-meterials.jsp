<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


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
<script type="text/javascript">

var loggedUser = '<%=(String)session.getAttribute("loggedUser") %>';
$(function(){
	  
    $("#loggedUser").text(loggedUser);

});
</script>
<style type="text/css">


.text-danger{

font-size: 20px;
    text-align: justify;
    text-transform: uppercase;
    font-weight: 600;
    color: #84858f;

}
.fileinput.input-group {
    display: flex;
}
.fileinput {
    display: inline-block;
    margin-bottom: 9px;
    color: rgba(244,244,245,0.901961);
    font-family: Open Sans,sans-serif;
}
.input-group {
    position: relative;
    display: flex;
    flex-wrap: wrap;
    align-items: stretch;
    width: 100%;
}
.input-group>.form-control, .input-group>.form-control-plaintext, .input-group>.custom-select, .input-group>.custom-file {
    position: relative;
    flex: 1 1 auto;
    width: 1%;
    min-width: 0;
    margin-bottom: 0;
}
.form-control {
    transition: border-color 0.15s ease-in-out,background-color 0.15s ease-in-out;
}
.form-control {
    background-color: #040620;
    border: none;
    color: rgba(244,244,245,0.701961);
    box-shadow: none;
}
.form-control {
    display: block;
    width: 100%;
    height: calc(1.55em + .75rem + 2px);
    padding: .375rem .75rem;
    font-size: 1rem;
    font-weight: 300;
    line-height: 1.55;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #c1ccd3;
    border-radius: .3rem;
    box-shadow: inset 0 1px 1px rgb(0 0 0 / 8%);
    transition: border-color 0.15s ease-in-out,box-shadow 0.15s ease-in-out;
}
.fileinput-new.input-group .btn-file, .fileinput-new .input-group .btn-file {
    border-radius: 0 .3rem .3rem 0;
}
.fileinput-new.input-group .btn-file, .fileinput-new .input-group .btn-file {
    border-radius: 0 4px 4px 0;
}
.fileinput.input-group>.btn-file {
    z-index: 1;
}
.btn:not(:disabled):not(.disabled) {
    cursor: pointer;
}
.fileinput .input-group-addon {
    padding: .375rem .75rem;
}
.input-group-addon:not(:first-child) {
    border-left: 0;
}
.fileinput.input-group>* {
    position: relative;
    z-index: 2;
}
.fileinput .btn {
    vertical-align: middle;
}
.btn:not(.active), .btn-inverse:not(.active), .btn-gray:not(.active) {
    box-shadow: none !important;
}
button:not(:disabled), [type="button"]:not(:disabled), [type="reset"]:not(:disabled), [type="submit"]:not(:disabled) {
    cursor: pointer;
}
.btn {
    transition: background-color 0.15s ease-in-out,border-color 0.15s ease-in-out;
}
.btn-default {
    color: rgba(244,244,245,0.901961);
    background-color: #474d84;
    border-color: #353a63;
}
.btn-file {
    position: relative;
    overflow: hidden;
    vertical-align: middle;
}
.btn-default {
    color: #fff;
    background-color: #3a3e6b;
    border-color: #353a63;
}
.btn {
    display: inline-block;
    font-weight: 400;
    color: #495057;
    text-align: center;
    vertical-align: middle;
    user-select: none;
    background-color: transparent;
    border: 1px solid transparent;
    padding: .375rem .75rem;
    font-size: 1rem;
    line-height: 1.55;
    border-radius: .3rem;
    transition: color 0.15s ease-in-out,background-color 0.15s ease-in-out,border-color 0.15s ease-in-out,box-shadow 0.15s ease-in-out;
}
button, [type="button"], [type="reset"], [type="submit"] {
    -webkit-appearance: button;
}
button, select {
    text-transform: none;
}
button, input {
    overflow: visible;
}
input, button, select, optgroup, textarea {
    margin: 0;
    font-family: inherit;
    font-size: inherit;
    line-height: inherit;
}
.btn-primary:hover {
  background-color: #e63f17;
  border-color: rgba(255, 255, 255, 0.6);
}
.btn-lg, .btn-group-lg > .btn {
    padding: 19px 34px;
    font-size: 20px;
    line-height: 1.3333333;
    border-radius: 0;
}
.btn-primary {
    color: #ffffff;
    background-color: #e63f17;
    border-color: #e63f17;
}
.btn {
    display: inline-block;
    font-weight: 700;
    cursor: pointer;
    border: 1px solid transparent;
    padding: 19px 23px;
    font-size: 14px;
    line-height: 19px;
    border-radius: 0;
    -moz-transition: 0.2s all ease;
    -webkit-transition: 0.2s all ease;
    -o-transition: 0.2s all ease;
    transition: 0.2s all ease;
    font-family: 'Trebuchet MS', sans-serif;
}
.parallax1 small + * {
    margin-top: 21px;
}
</style>
<%-- <span class="pdf-icon"></span> --%>

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

<c:if test="${!empty questionlist}">
						<c:forEach items="${questionlist}" varStatus="index" var="record">
	<section class="well " style="padding-bottom: 20px !important;
    padding-top: 20px !important;">
		<div class="container">
			<div class="row">

				<div class="col-md-12 col-sm-12">


					<section class="event">
						<h5 class="event-heading">
							<a href="#">${record.meterialTitle}</a>
						</h5>
						<footer>
							<div class="clearfix">
								<ul class="post-links mt-sm float-left">
									
									<li><a href="#"><span class="text-danger"> ${record.meterialName}</span></a></li>
									
								</ul>

								
							</div>
							<ul class="post-comments mt-sm">
								<li class="border-0"><a href="<%=request.getContextPath()%>/downloadSheets?folderId=${record.questionFolderId}&action=QUESTION"><span title="Please Click To Download Question Sheet"
									class="thumb-xs avatar float-left mr-sm pdf-icon">
								</span></a>
								
									<div class="comment-body">
										
										<p style="font-size: 15px;
    text-align: justify;
    text-transform: uppercase;
    font-weight: 600;
    word-break: break-all;
    flex-wrap: wrap;
    color: white;
">${record.description}</p>
									</div></li>
								<li class="border-0">
									<div class="comment-body">
									
									<c:choose>
											<c:when test="${record.answerGiven ne true}">
											<form:form class="form-horizontal" action="exam-answer-metrials" modelAttribute="metrialsAnswerForm" autocomplete="off"  enctype="multipart/form-data" method="post" id="metrialsAnswerForm~${index.index}">
									
										<div class="fileinput input-group fileinput-new">
										<form:hidden path="userId"
																 name="userId" id="userId~${index.index}"/>
															<form:hidden path="emailId"
																 name="emailId" id="emailId~${index.index}" />
														    <form:hidden path="questionAnswerId"
																 name="questionId" id="questionAnswerId~${index.index}" value="${record.questionAnswerId}"/>		 
													
															<form:input type="file" placeholder="Upload Answer Sheet" path="answerFileName" 
																 name="answerFileName"  id="answerFileName~${index.index}" cssClass="form-control" cssStyle="color: #e63f17;
    font-size: 15px;
    text-align: center;
    text-transform: uppercase;
    font-weight: 600;" />	
											
											
											<button onclick="validateForm(${index.index})" class="input-group-addon btn btn-default btn-file" type="button" style="width: 200px !important;
    background: #e63f17;
    color: white;
    font-size: 15px;
    text-align: center;
    text-transform: uppercase;">
												Upload
											</button>
											
										</div>
										<div class="top-info" id="errorMessage~${index.index}" style="border: none !important; display: none;">
												<span class="entry-author" style="color: #e63f17 !important;font-size: 15px !important; font-weight: 600 !important;">Please Choose answer sheet to upload. This field is required.
												</span> 
											</div>
										</form:form>
											
											</c:when>
											<c:otherwise>
										<div style="color: #fff;
    background-image: linear-gradient(to right, #e63f17 0%, #004471 100%) !important;
    padding: 2px 0px 0px 30px;
    width: 100%;
    height: 34px;
    border: 1px solid #ddd;
    -webkit-border-radius: 5px;
    box-shadow: 0 5px 5px -5px rgb(0 0 0 / 9%);
    font-size: 17px;
    text-transform: uppercase;" class="fileinput input-group fileinput-new">
										
										Note: Answer Sheet Has Been Submitted Successfully
										</div>
										</c:otherwise>
											</c:choose>
									</div>
								</li>
							</ul>
						</footer>
					</section>



				</div>

			</div>
		</div>
	</section>

</c:forEach>
					</c:if>	



</main>


