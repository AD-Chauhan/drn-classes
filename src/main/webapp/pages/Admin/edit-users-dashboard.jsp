<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<script type='text/javascript'
	src='${pageContext.request.contextPath}/drnclasses/engine.js'></script>
<script type='text/javascript'
	src="${pageContext.request.contextPath}/drnclasses/util.js"> </script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/drnclasses/interface/usersDwrUtils.js"></script>

<script type="text/javascript">	
function deleteUserRecordOrDeactive(userid,action){
	
	var pageContext='${pageContext.request.contextPath}';
	if(action=='DELETE'){
		
		bootbox.confirm({
		    message: "Are you sure you want to delete  this user ?",
		    buttons: {
		        confirm: {
		            label: 'DELETE',
		            className: 'btn btn-rounded btn-outline-warning'
		        },
		        cancel: {
		            label: 'CANCEL',
		            className: 'btn btn-rounded btn-outline-success'
		        }
		    },
		    callback: function (result) {
		    	if(result)
				{
		    		usersDwrUtils.deleteOrDeactivateUserById(parseInt(userid),action,{callback:function(message){
					
		    			if(message=='true'){
		    				
		    				window.location.href=pageContext+"/edit-users-dashboard";
		    				$( document ).ready(function() {
								$.notify({
									title: 'Message:',
									message: 'User Deleated Successfully',
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
		    				
		    			}else{
		    				
		    				
		    				$( document ).ready(function() {
								$.notify({
									title: 'Message:',
									message: 'Somthing is wrong ..Unable to delete User',
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
		    			}
		    			
		    			
				},
				async : false
				});	
				
				}
		    }
		});
		
	}else if(action=='DACTIVE'){
		
		bootbox.confirm({
		    message: "Are you sure you want to deactive  this user ?",
		    buttons: {
		        confirm: {
		            label: 'DACTIVE',
		            className: 'btn btn-rounded btn-outline-warning'
		        },
		        cancel: {
		            label: 'CANCEL',
		            className: 'btn btn-rounded btn-outline-success'
		        }
		    },
		    callback: function (result) {
		    	if(result)
				{
		    		usersDwrUtils.deleteOrDeactivateUserById(parseInt(userid),action,{callback:function(message){
if(message=='true'){
		    				
		    				window.location.href=pageContext+"/edit-users-dashboard";
		    				$( document ).ready(function() {
								$.notify({
									title: 'Message:',
									message: 'User Deactivated Successfully',
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
		    				
		    			}else{
		    				
		    				
		    				$( document ).ready(function() {
								$.notify({
									title: 'Message:',
									message: 'Somthing is wrong ..Unable to Deactivate  User',
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
		    			}
				},
				async : false
				});	
				
				}
		    }
		});
		
	}else if(action=='ACTIVE'){
		
		bootbox.confirm({
		    message: "Are you sure you want to deactive  this user ?",
		    buttons: {
		        confirm: {
		            label: 'DACTIVE',
		            className: 'btn btn-rounded btn-outline-warning'
		        },
		        cancel: {
		            label: 'CANCEL',
		            className: 'btn btn-rounded btn-outline-success'
		        }
		    },
		    callback: function (result) {
		    	if(result)
				{
		    		usersDwrUtils.deleteOrDeactivateUserById(parseInt(userid),action,{callback:function(message){
if(message=='true'){
		    				
		    				window.location.href=pageContext+"/edit-users-dashboard";
		    				$( document ).ready(function() {
								$.notify({
									title: 'Message:',
									message: 'User Activated Successfully',
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
		    				
		    			}else{
		    				
		    				
		    				$( document ).ready(function() {
								$.notify({
									title: 'Message:',
									message: 'Somthing is wrong ..Unable to Deactivate  User',
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
		    			}
				},
				async : false
				});	
				
				}
		    }
		});
		
	}
	
	
}
</script>


<section class="main--content">

	<div class="panel">
		<div class="records--list" data-title="Orders Listing">
			<table id="recordsListView">
				<thead>
					<tr>
						<th>SR No.</th>
						<th>FIRST NAME</th>
						<th>MIDDLE NAME</th>
						<th>LAST NAME</th>
						<th>EMAIL</th>
						<th>PHONE</th>
						<th>BATCH</th>
						<th>CORRESPONDANCE ADD</th>
						<th>PERMANET ADD</th>
						<th>FATHER NAME</th>
						<th>MOTHER NAME</th>
						<th>STATUS</th>
						<th>CREATED ON</th>
						<th>CREATED BY</th>
						<th>ROLES/ROLE</th>
						<th>Delete</th>
						<th>Deactivate</th>
						<th>Activate</th>

					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty finalList}">
						<c:forEach items="${finalList}" varStatus="index" var="record">
							<tr>
								<td>${index.count}</td>
								<td>${record.firstName}</td>
								<td>
								
								<c:choose>
								<c:when test="${record.middleName eq 'null'}">
								
								--
								
								</c:when>
								<c:otherwise>
								
								${record.middleName}
								
								</c:otherwise>
								</c:choose>
								
								
								</td>
								<td>${record.lastName}</td>
								<td>${record.email}</td>
								<td>${record.phone}</td>
								<td>${record.batch}</td>
								<td>${record.correspondanceAddress}</td>
								<td>${record.permanentAddress}</td>
								<td>${record.fatherName}</td>
								<td>${record.motherName}</td>
								<td>
								<c:choose>
								<c:when test="${record.enabled eq true}">
								
								<span>ACTIVE</span>
								
								</c:when>
								<c:otherwise>
								
								<span>DE-ACTIVE</span>
								
								</c:otherwise>
								</c:choose>
								
								
								
								
								</td>
								<td>${record.createdOn}</td>
								<td>${record.createdBy}</td>
								<td>
								
								<div class="sidebar--nav">
					                     <ul>
					                     <c:if test="${!empty roleList}">
					                     
					                     <c:forEach items="${roleList}" varStatus="index" var="roles">
					                      <c:if test="${roles.roleId eq record.userRole}">
					                        <li style="margin-top: 5px !important;"><span style="color: #b13b0f !important; font-weight: 700 !important;text-transform: uppercase !important;">${roles.abbreCode}</span> </li>
					                        </c:if>
					                       </c:forEach> 
					                      </c:if>
					                    </ul>
					                   </div>
													
													
								</td>
								
								<td><a style="font-size: 27px !important;" href="#"
									onclick="deleteUserRecordOrDeactive(${record.userId},'DELETE')"><i
										class="fa fa-trash" aria-hidden="true"></i></a>
										
										</td>
								<td><a style="font-size: 27px !important;" href="#"
									onclick="deleteUserRecordOrDeactive(${record.userId},'DACTIVE')"><i
										class="fa fa-power-off" aria-hidden="true"></i></a>
										</td>
										
								<td><a style="font-size: 27px !important;" href="#"
									onclick="deleteUserRecordOrDeactive(${record.userId},'ACTIVE')"><i
										class="fa fa-toggle-on" aria-hidden="true"></i></a>
										</td>		

							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</section>




