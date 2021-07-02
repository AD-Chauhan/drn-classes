<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<script type='text/javascript'>

$(document).ready(function(){
	$('#blogsForms').validate(
			{
				errorElement : 'div',
				errorClass : 'help-block',
				onfocusout : false,
				onblur : false,
				rules : {
					blogName : {
						required : true

					},
					blogTitle : {
						required : true

					},
					executionTime : {
						required : true

					},
					description : {
						required : true

					},
					
					chapterFileName  : {
						required : true
					},
					
					

				},
				highlight : function(e) {
					$(e).closest('.form-group').removeClass('has-info').addClass(
							'has-error');
				},
				success : function(e) {
					$(e).closest('.form-group').removeClass('has-error');
					$(e).remove();
				},
				errorPlacement : function(error, element) {

					if (element.is('input[type=checkbox]')
							|| element.is('input[type=radio]')) {
						var controls = element.closest('div[class*="col-"]');
						if (controls.find(':checkbox,:radio').length > 1)
							controls.append(error);
						else
							error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
					} else if (element.is('.select2')) {
						error.insertAfter(element
								.siblings('[class*="select2-container"]:eq(0)'));
					} else if (element.is('.chosen-select')) {
						error.insertAfter(element
								.siblings('[class*="chosen-container"]:eq(0)'));
					} else
						error.insertAfter(element.parent());
					
				},
				submitHandler : function(form) {
					form.submit();
				}
			});

});

</script>
<style>
.help-block{
    color: #bd1212;
    margin-left: 19%;
}
#chapterFileName-error{

color: #bd1212 !important;
    margin-left: 0% !important;
}
[data-notify="container"][class*="alert-pastel-"] {
	background-color: rgb(255, 255, 238);
	border-width: 0px;
	border-left: 15px solid rgb(255, 240, 106);
	border-radius: 0px;
	box-shadow: 0px 0px 5px rgba(51, 51, 51, 0.3);
	font-family: 'Old Standard TT', serif;
	letter-spacing: 1px;
}
[data-notify="container"].alert-pastel-info {
	border-left-color: rgb(255, 179, 40);
}
[data-notify="container"].alert-pastel-danger {
	border-left-color: rgb(255, 103, 76);
}
[data-notify="container"][class*="alert-pastel-"] > [data-notify="title"] {
	color: rgb(80, 80, 57);
	display: block;
	font-weight: 700;
	margin-bottom: 5px;
}
[data-notify="container"][class*="alert-pastel-"] > [data-notify="message"] {
	font-weight: 400;
}

.alert-info  {
   
    right: 566px !important;
    top: 10px !important;
    right: 290px !important;
    min-width: 52% !important;
}

.alert-success  {
   
    right: 566px !important;
    top: 10px !important;
    right: 290px !important;
    min-width: 52% !important;
}
.alert-danger {
   
    right: 566px !important;
    top: 10px !important;
    right: 290px !important;
    min-width: 52% !important;
}
span.message {
    margin-left: 10px;
}

</style>	
<script src="<c:url value="/resources/js/Upload-Video/uploadvideo.js"/>"></script>

<div class="wrapper">
<c:if test="${not empty SUCCESS}">
								<script type="text/javascript">
								$( document ).ready(function() {
									$.notify({
										title: 'Message:',
										message: '${SUCCESS}',
									},{
										// settings
										element: 'body',
										position: null,
										type: "success",
										allow_dismiss: true,
										newest_on_top: false,
										showProgressbar: false,
										placement: {
											from: "top",
											align: "right"
										},
										offset: 20,
										spacing: 10,
										z_index: 1031,
										delay: 5000,
										timer: 1000,
										url_target: '_blank',
										mouse_over: null,
										animate: {
											enter: 'animated fadeInDown',
											exit: 'animated fadeOutUp'
										},
										onShow: null,
										onShown: null,
										onClose: null,
										onClosed: null,
										icon_type: 'class',
										template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
											'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
											'<i class="far fa-comments"></i> ' +
											
											'<span data-notify="message">{2}</span>' +
											'<div class="progress" data-notify="progressbar">' +
												'<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>' +
											'</div>' +
											
										'</div>' 
									});
								});
								</script>
               </c:if>
               
               <c:if test="${not empty ERROR}">
								<script type="text/javascript">
								$( document ).ready(function() {
									$.notify({
										title: 'Message:',
										message: '${ERROR}',
									},{
										// settings
										element: 'body',
										position: null,
										type: "danger",
										allow_dismiss: true,
										newest_on_top: false,
										showProgressbar: false,
										placement: {
											from: "top",
											align: "right"
										},
										offset: 20,
										spacing: 10,
										z_index: 1031,
										delay: 5000,
										timer: 1000,
										url_target: '_blank',
										mouse_over: null,
										animate: {
											enter: 'animated fadeInDown',
											exit: 'animated fadeOutUp'
										},
										onShow: null,
										onShown: null,
										onClose: null,
										onClosed: null,
										icon_type: 'class',
										template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
											'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>' +
											'<i class="far fa-comments"></i> ' +
											
											'<span data-notify="message">{2}</span>' +
											'<div class="progress" data-notify="progressbar">' +
												'<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>' +
											'</div>' +
											
										'</div>' 
									});
								});
								</script>
               </c:if>	
	<div class="m-account-w"
		data-bg-img="<%=request.getContextPath()%>/resources/Admin/assets/img/bg-par2.jpg">
		<div class="m-account">
			<div class="row no-gutters flex-row-reverse">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Blog Videos</h3>
						</div>
						<div class="panel-content">

<form:form class="form-horizontal" action="upload-blogs" modelAttribute="blogsForms" autocomplete="off"  enctype="multipart/form-data" method="post" id="blogsForms">
							<form:hidden path="${_csrf.parameterName}"   value="${_csrf.token}" htmlEscape="true"/>
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Blog Title
								</span>
								<div class="col-md-10">
									<form:input type="text" path="blogTitle" id="blogTitle" name="blogTitle" maxlength="30" class="form-control"/> 
								</div>
								
							</div>
							<hr>
							
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Blog Name</span>
								<div class="col-md-10">
									<form:input type="text" path="blogName" id="blogName"  name="blogName" maxlength="35" class="form-control "/>
								</div>
							</div>
							<hr>
							
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Scheduled Date</span>
								<div class="col-md-10">
									<form:input type="text" path="executionTime" id="executionTime"  name="executionTime" class="form-control "/>
								</div>
							</div>
							<hr>
							
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Description</span>
								<div class="col-md-10">
									
									<form:textarea path="description" id="description"  name="description" class="form-control"
										placeholder="PLease input description" spellcheck="false"></form:textarea>
								</div>
							</div>
							<hr>


							


							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Blog File
									Upload(image file)</span>
								<div class="col-md-10">
									<label class="custom-file"> <form:input type="file"  path="chapterFileName" id="chapterFileName" name="chapterFileName"
										class="custom-file-input"/> <span
										class="custom-file-label">Choose File</span>
									</label>
								</div>
							</div>

							<hr>
							<div class="m-account--actions">
								<button type="submit"
									style="color: #fff !important; background-color: #e16123 !important;"
									class="btn btn-rounded btn-warning">Upload</button>
							</div>
</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>