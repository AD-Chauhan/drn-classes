<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<style type="text/css">
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
.form-group.required .label-text:after {
  content:"*";
  color:#e16123;
}

.help-block{
    color: #bd1212;
    margin-left: 19%;
}
.notifyjs-bootstrap-error {
    color: #B94A48;
    background-color: #F2DEDE;
    border-color: #EED3D7;
    background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAtRJREFUeNqkVc1u00AQHq+dOD+0poIQfkIjalW0SEGqRMuRnHos3DjwAH0ArlyQeANOOSMeAA5VjyBxKBQhgSpVUKKQNGloFdw4cWw2jtfMOna6JOUArDTazXi/b3dm55socPqQhFka++aHBsI8GsopRJERNFlY88FCEk9Yiwf8RhgRyaHFQpPHCDmZG5oX2ui2yilkcTT1AcDsbYC1NMAyOi7zTX2Agx7A9luAl88BauiiQ/cJaZQfIpAlngDcvZZMrl8vFPK5+XktrWlx3/ehZ5r9+t6e+WVnp1pxnNIjgBe4/6dAysQc8dsmHwPcW9C0h3fW1hans1ltwJhy0GxK7XZbUlMp5Ww2eyan6+ft/f2FAqXGK4CvQk5HueFz7D6GOZtIrK+srupdx1GRBBqNBtzc2AiMr7nPplRdKhb1q6q6zjFhrklEFOUutoQ50xcX86ZlqaZpQrfbBdu2R6/G19zX6XSgh6RX5ubyHCM8nqSID6ICrGiZjGYYxojEsiw4PDwMSL5VKsC8Yf4VRYFzMzMaxwjlJSlCyAQ9l0CW44PBADzXhe7xMdi9HtTrdYjFYkDQL0cn4Xdq2/EAE+InCnvADTf2eah4Sx9vExQjkqXT6aAERICMewd/UAp/IeYANM2joxt+q5VI+ieq2i0Wg3l6DNzHwTERPgo1ko7XBXj3vdlsT2F+UuhIhYkp7u7CarkcrFOCtR3H5JiwbAIeImjT/YQKKBtGjRFCU5IUgFRe7fF4cCNVIPMYo3VKqxwjyNAXNepuopyqnld602qVsfRpEkkz+GFL1wPj6ySXBpJtWVa5xlhpcyhBNwpZHmtX8AGgfIExo0ZpzkWVTBGiXCSEaHh62/PoR0p/vHaczxXGnj4bSo+G78lELU80h1uogBwWLf5YlsPmgDEd4M236xjm+8nm4IuE/9u+/PH2JXZfbwz4zw1WbO+SQPpXfwG/BBgAhCNZiSb/pOQAAAAASUVORK5CYII=);
    height: 66px !important;
    margin: 0px -2px -29px -247px !important;
    position: absolute !important;
    width: 915px !important;
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
<script type="text/javascript">


$(document).ready(function(){
	$('#userRegistrationForm').validate(
			{
				errorElement : 'div',
				errorClass : 'help-block',
				onfocusout : false,
				onblur : false,
				rules : {
					firstName : {
						required : true

					},
					lastName : {
						required : true

					},
					email : {
						required : true

					},
					userPassword : {
						required : true

					},
					phone  : {
						required : true
					},
					batch  : {
						required : true
					},
					
					correspondanceAddress : {
						required : true

					},
					permanentAddress : {
						required : true

					},
					fatherName : {
						required : true

					},
					motherName : {
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
				 var isChecked=0;
				
				$("input.slectedCheckBox").each(function(index){
				
				
				var checkBoxId=$(this).attr('id');
 		        var splittedArr=checkBoxId.split("]");
 		        var splittedArrTemp=splittedArr[0].split("[");
 		        var checkBoxIndex=splittedArrTemp[1];
 		        var i = parseInt(checkBoxIndex);
 		
 		 
 		        var chk = document.getElementById("userRole["+i+"].roleId").checked;
				if(chk === true){
				
				isChecked=1;
				
				}
				});
				if(isChecked == 0){
 			 		$('.slectedCheckBoxGroup').removeClass('has-info').addClass(
							'has-error');
 			        $('#slectedCheckBox-error').css("display","block");
 			       $('#slectedCheckBox-error').html('This field is required.');
 		        } else{
 		        $('.slectedCheckBoxGroup').removeClass('has-error');
					$('#slectedCheckBox-error').css("display","none");
					$('#slectedCheckBox-error').html('');
 		            form.submit();
 		        
 		        }
					
				}
			});

});

function isunchecked(index){
	 
 	if(!document.getElementById("userRole["+index+"].roleId").checked){
 		$('.slectedCheckBoxGroup').removeClass('has-info').addClass(
		'has-error');
       $('#slectedCheckBox-error').css("display","block");
       $('#slectedCheckBox-error').html('This field is required.');
 	}
 	else{
 		$('.slectedCheckBoxGroup').removeClass('has-error');
		$('#slectedCheckBox-error').css("display","none");
		$('#slectedCheckBox-error').html('');
         form.submit();
     
     }
 	}
 


 
 


</script>


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
							<h3 class="panel-title">D.R.N. Users Registration</h3>
						</div>
						<div class="panel-content">
						<form:form class="form-horizontal" action="register-page" modelAttribute="userRegistrationForm" autocomplete="off"   method="post" id="userRegistrationForm">
						    
							<div class="form-group row required">
								<span class="label-text col-md-2 col-form-label text-md-right">First Name</span>
								<div class="col-md-10">
									<form:input type="text" path="firstName" id="firstName"  name="firstName" class="form-control "/>
								</div>
							</div>
							<hr>
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Middle Name</span>
								<div class="col-md-10">
									<form:input type="text" path="middleName" id="middleName"  name="middleName" class="form-control "/>
								</div>
							</div>
							<hr>
							<div class="form-group row required">
								<span class="label-text col-md-2 col-form-label text-md-right">Last Name
									</span>
								<div class="col-md-10">
									<form:input type="text" path="lastName" id="lastName"  name="lastName" class="form-control "/>
								</div>
							</div>
							<hr>
							<div class="form-group row required">
								<span class="label-text col-md-2 col-form-label text-md-right">Email</span>
								<div class="col-md-10">
									<form:input type="text" path="email" id="email"  name="email" class="form-control "/>
								</div>
							</div>
							<hr>
							
							<div class="form-group row required">
								<span class="label-text col-md-2 col-form-label text-md-right">Password</span>
								<div class="col-md-10">
									<form:input type="password" path="userPassword" id="userPassword"  name="userPassword" class="form-control "/>
								</div>
							</div>
							
							<hr>
							
							
							<div class="form-group row slectedCheckBoxGroup">
                             <span class="label-text col-md-2 col-form-label text-md-right py-0">Role</span> 
							        <div class="col-md-10 form-inline">
							                 <c:if test="${!empty roleList}"> 
							                       <c:forEach items="${roleList}" varStatus="index" var="record">
											                 <label class="form-check"> 
											                      <input onclick="isunchecked(${index.index})"  type="checkbox"  id="userRole[${index.index}].roleId" name="userRole[${index.index}].roleId" 
											                      value="${record.roleId}" class="form-check-input slectedCheckBox"> 
											                      <span class="form-check-label label-text " style="padding-right: 13px !important;">${record.abbreCode}</span> 
											                      
											                 </label> 
											                
							                       </c:forEach>
							                 </c:if>
							         </div>
							          <div id="slectedCheckBox-error" class="help-block" style="display: none; width: 100%;"></div>
							</div>
							<hr>
							
							
							<div class="form-group row required">
								<span class="label-text col-md-2 col-form-label text-md-right">Mobile Number</span>
								<div class="col-md-10">
									<form:input type="text" path="phone" id="phone"  name="phone" class="form-control "/>
								</div>
							</div>
							<hr>
							
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Batch/Class</span>
								<div class="col-md-10">
									<form:select  class="form-control" path="batch" id="batch" name="batch">
									    <form:option value="">--Select--</form:option>
										<c:forEach items="${batch}" var="oblist" varStatus="count" >	
																		
										 <form:option value="${oblist.key}">${oblist.value}</form:option>								
																		
			                                                              
			                                                              
			                            </c:forEach>
									</form:select>
								</div>
							</div>
							<hr>
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Correspondence Address</span>
								<div class="col-md-10">
									<form:input type="text" path="correspondanceAddress" id="correspondanceAddress"  name="correspondanceAddress" class="form-control "/>
								</div>
							</div>
							<hr>
							
							<div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Permanent Address</span>
								<div class="col-md-10">
									<form:input type="text" path="permanentAddress" id="permanentAddress"  name="permanentAddress" class="form-control "/>
								</div>
							</div>
							<hr>
						  <div class="form-group row">
								<span class="label-text col-md-2 col-form-label text-md-right">Father Name</span>
								<div class="col-md-10">
									<form:input type="text" path="fatherName" id="fatherName"  name="fatherName" class="form-control "/>
								</div>
							</div>
							<hr>
							<div class="form-group row required">
								<span class="label-text col-md-2 col-form-label text-md-right">Mother Name</span>
								<div class="col-md-10">
									<form:input type="text" path="motherName" id="motherName"  name="motherName" class="form-control "/>
								</div>
							</div>
							<hr>
							
								<div class="m-account--actions">
										<button type="submit" style="color: #fff !important;
    background-color: #e16123 !important;" class="btn btn-rounded btn-warning">Register</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>