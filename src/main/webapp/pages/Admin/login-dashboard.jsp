<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
   prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>

<style type="text/css">
.post-prev-img {
	margin-bottom: 23px;
	position: relative;
}

.round {
	-webkit-border-radius: 2px !important;
	-moz-border-radius: 2px !important;
	border-radius: 2px !important;
}

.section-text {
	font-size: 15px;
	font-weight: 400;
	color: #777;
	line-height: 1.7;
}

.img-lazy {
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgb(0 0 0/ 8%);
	box-shadow: inset 0 1px 1px rgb(0 0 0/ 8%);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	height: 82px;
	max-width: 98% !important;
	margin-top: 10px !important;
	margin-left: 2px !important;
}

.post-prev-img img {
	width: 100%;
}

.mt-10 {
	margin-top: 10px;
}

.error {
	color: #b70202;
	font-weight: 600;
	font-size: 12px;
	letter-spacing: 1px;
	text-transform: uppercase;
	display:none;
}

.footer-refresh-links {
	font-size: 14px;
}

.footer-refresh-links a {
	width: 42px;
	height: 28px;
	line-height: 27px !important;
	position: relative;
	margin: 0px 148px;
	text-align: center;
	display: inline-block;
	color: #111;
	background-color: #fff !important;
}

.sr-only {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.alert{
  margin: -46px 151px 16px -152px;
    padding: 14px 20px; 
    color: #6a1a21;
    font-weight: 700;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    
    border: 1px solid #ddd;
    font-size: 13px;
    letter-spacing: 1px;
    text-transform: uppercase;
    
    
    -webkit-border-radius: 0;
    -moz-border-radius: 0;
    border-radius: 0;
    
}

</style>
<script type="text/javascript">
var pageContext='${pageContext.request.contextPath}';
   
  $(function(){
	  
	      $("#captchaAnswer_error").hide();
		  $("#userName_error").hide();
		  $("#userPassword_error").hide();
	  
	  
	  
  });
   
   function validateFielData(id){
   	  
   	  var val = $("#"+id).val();
   	  if(val==null || val==''){
   		  $("#"+id+"_error").show();  
   		  return true;
   	  }
   	  else{
   		  return false;
   	  }
   }
   	
   	 function validateUser(obj){
   		  $("#captchaAnswer_error").hide();
   		  $("#userName_error").hide();
   		  $("#userPassword_error").hide();
   		  var userName = validateFielData('userName');
   		  var password =validateFielData('userPassword');
   		  var captchaAnswer =validateFielData('captchaAnswer');
   		  
   		  if(userName!=true && password!=true && captchaAnswer !=true){
   			
     	     
   			  obj.disabled = true;
   			  obj.value = "Please Wait..! ";
   			  document.forms["loginForm"].submit();
   			  
   		  }
   		  
   	  }
   	 function refreshCaptcha() {
   		     $("#captchaAnswer").val('');
   		     $("#img_Capatcha").attr("src","");
   	         $("#img_Capatcha").attr("src", pageContext+"/admin/imgCaptcha");
   	         $("#img_Capatcha").slideDown("fast");
   		 
   		 
   	}
   	 
   	
     
</script>
<div class="wrapper">
	<div class="m-account-w" style="background-size: cover !important;
    background-position: 0 0;
    background-image: -webkit-linear-gradient(left, #84858f 0%, #c7ad83 100%) !important;
    background-repeat: repeat-x !important;">
		<div class="m-account" style="width: 100% !important;
	max-width: 1002px !important;">
			<div class="row no-gutters">
			<c:if
								test="${ not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}">
								<div class="col-lg-12 offset-lg-1 col-xl-12 offset-xl-2">

									<div class="alert alert-danger alert-dismissible">
										<i class="fa fa-comments" aria-hidden="true"></i> Your login
										attempt was not successful, try again.<br /> Caused :
										${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}


									</div>
								</div>
							</c:if>
				<div class="col-md-6">
					<div class="m-account--content-w" style="background-color: #004471 !important;">
						<div class="logo" >
								
	     <div class="jumbotron text-center" style="margin-top: 18px;color: #ffffff;text-align: center;
    height: 100%;">
            <p style="margin: 0;">
            <img style="height: 159px !important;
    width: 225px !important;
    margin-top: -31px !important;"
									src="<%=request.getContextPath()%>/resources/Users/images/logo-white.png"alt=""/>
              <label style="text-transform: none;
    font-size: 25px;
    display: block;
    color: #021827;
    margin-top: -41px !important;
    font-weight: 900 !important;" >Prayagraj</label> 
              <small style="text-transform: uppercase;
    font-size: 16px !important;
    margin-top: 30px;
    display: block;
    color: #e64018;
    height: 131px;
    text-align: center;
    word-break: break-all;
    font-weight: 900 !important;">
                DRN Classes Are Educational Institutions Operating With The Exclusive Objective Of Preparing Students For Class 9, 10, 11, 12 Examinations
              </small>
            </p>
           
          </div>								

						</div>
						
					</div>

				</div>
				<div class="col-md-6">
					<div class="m-account--form-w">
						<div class="m-account--form" style="max-width: 378px !important;">
							
							<form:form action="login" method="post"
								modelAttribute="loginForm" id="loginForm">
								<form:hidden path="${_csrf.parameterName}"
									value="${_csrf.token}" htmlEscape="true" />
								<label class="m-account--title" style="color: #458bb9 !important;
    font-size: 17px !important;
    text-transform: uppercase !important;
    font-weight: 700 !important;">Login to your account</label>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<i class="fas fa-user"></i>
										</div>
										<form:input path="userName" id="userName"
											placeholder="User Name" autocomplete="on" htmlEscape="true" maxlength="20"
											cssClass="input-md round form-control" />
										
									</div>
									<div class="error" id="userName_error">
											<spring:message code="Error.Required" />
										</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-prepend">
											<i class="fas fa-key"></i>
										</div>
										<form:password path="password" id="userPassword"  placeholder="Password" maxlength="20"
                              autocomplete="off" htmlEscape="true" cssClass="input-md round form-control"/>
                           
									</div>
									<div class="error" id="userPassword_error">
                              <spring:message code="Error.Required" />
                           </div>
								</div>

								<div class="row">
									<div class="col-sm-12">
										<div class="row grid-sm-row">
											<div
												class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-0 "
												style="padding-right: 0px !important; padding-left: 0px !important;">
												<div class="post-prev-img input-md round "
													style="padding-left: 14px !important; padding-right: 10px !important;">
													<img class="img-lazy "
														src="<%=request.getContextPath()%>/admin/imgCaptcha"
														id="img_Capatcha" alt="">
												</div>
											</div>
											<div
												class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-0 mt-10"
												style="padding-left: 3px !important;">
												<div class="form-group">
													 <form:input  id="captchaAnswer" maxlength="6" path="captchaAnswer" placeholder="Captcha Answer"  htmlEscape="true" autocomplete="off" cssClass="input-md round form-control"/>
                                     
													<div class="error" id="captchaAnswer_error">
                                          <spring:message code="Error.Required" />
                                       </div>

												</div>
												<div class="form-group">
													<div class="m-account--actions"
														style="padding-left: 134px !important; margin-top: 19px !important;">
														<a href="#" onclick="javascript:refreshCaptcha()" class="btn-link">Refresh</a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="m-account--actions">
									
									<button type="button" style="color: #fff !important;
    background-color: #004471 !important;
    border-color: #004471 !important;" onclick="validateUser(this)" id="submitBtn" class="btn btn-rounded btn-info">Login</button>
								</div>

								<div class="m-account--footer">
									<p>&copy; 2021 D.R.N. CLASSES</p>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>