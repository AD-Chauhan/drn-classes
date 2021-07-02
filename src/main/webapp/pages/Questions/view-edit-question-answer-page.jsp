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
	src="${pageContext.request.contextPath}/drnclasses/interface/videoDwrUtils.js"></script>

<script type="text/javascript">	
function deleteFilesAndFolder(questionAnswerId){
	
	var pageContext='${pageContext.request.contextPath}';
	
	bootbox.confirm({
	    message: "Are you sure you want to delete  this Record ?",
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
			videoDwrUtils.deleteFolderAndSheetsById(parseInt(questionAnswerId),{callback:function(message){
				window.location.href=pageContext+"/view-exam-question-answer-metrials";
			},
			async : false
			});	
			
			}
	    }
	});
	
}


function reSubmitAnswerSheet(answerFolderId){
	
	var pageContext='${pageContext.request.contextPath}';
	
	bootbox.confirm({
	    message: "Are you sure you want to re-submit answer sheet from student ?",
	    buttons: {
	        confirm: {
	            label: 'YES',
	            className: 'btn btn-rounded btn-outline-warning'
	        },
	        cancel: {
	            label: 'NO',
	            className: 'btn btn-rounded btn-outline-success'
	        }
	    },
	    callback: function (result) {
	    	if(result)
			{
			videoDwrUtils.reSubmitAnswerSheet(answerFolderId,{callback:function(message){
			
				if(message=='true'){
    				
    				window.location.href=pageContext+"/view-exam-question-answer-metrials";
    				$( document ).ready(function() {
						$.notify({
							title: 'Message:',
							message: 'Student Can Submit Answer Sheet Again',
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
							message: 'Somthing is wrong ..Unable to Re Submit',
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
function getCourseCategory(value){
	
	videoDwrUtils.getCourseCategory(parseInt(value),{callback:function(response){
		
		if(response!=null){
				
				    dwr.util.removeAllOptions('courseCategory');
					$("#courseCategory").append("<option value=''>By Course Category</option>");
					dwr.util.addOptions('courseCategory',response);
		}
		
		
	},
	async : false
	});	
	
}

</script>
<section class="main--content">
	<div class="panel">
		<div class="records--header">
			<div class="title ">
				<h3 class="h3">
					Search
				</h3>
				
			</div>
			<div class="actions">
				<form:form action="view-exam-question-answer-metrials" class="search flex-wrap flex-md-nowrap" modelAttribute="searchForm" autocomplete="off"   method="post" id="searchForm">
					<form:input type="text" class="form-control" path="keyword" name="keyword" id="keyword"
						placeholder="By Keyword" required=""/> 
						<form:select path="batch" name="batch" onchange="getCourseCategory(this.value)" id="batch"
						 class="form-control">
						<form:option value="-Select-" selected="">By Class</form:option>
						<c:forEach items="${batch}" var="oblist" varStatus="count" >	
										 <form:option value="${oblist.key}">${oblist.value}</form:option>								
			                                                              
			                            </c:forEach>
					  </form:select>
					  <form:select path="courseCategory" name="courseCategory" id="courseCategory"
						 class="form-control">
						<form:option value="-Select-" selected="">By Course Category</form:option>
					  </form:select>
					  
					<button type="submit" class="btn btn-rounded">
						<i class="fa fa-search"></i>
					</button>
				</form:form>
				
			</div>
		</div>
	</div>
	<div class="panel">
		<div class="records--list" data-title="Answer Sheet Listing">
			<div id="recordsListView_wrapper"
				class="dataTables_wrapper no-footer">
				
				<div class="table-responsive">
					<table id="recordsListView" class="dataTable no-footer"
						aria-describedby="recordsListView_info" role="grid">
						<thead>
							<tr role="row">
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="ID: activate to sort column ascending"
									style="width: 79.1719px;">SR No.</th>
								<th class="sorting" rowspan="1"
									colspan="1" aria-label="Image" style="width: 61.9219px;">Question Sheet Title</th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Product Name: activate to sort column ascending"
									style="width: 132.672px;">Question Sheet Name</th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Category: activate to sort column ascending"
									style="width: 124.734px;">Batch</th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Price: activate to sort column ascending"
									style="width: 62.8125px;">Course Category</th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Quantity: activate to sort column ascending"
									style="width: 85.7188px;">Question Sheet Uploaded Date</th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Created Date: activate to sort column ascending"
									style="width: 122.094px;">Question Sheet Uploaded By</th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Status: activate to sort column ascending"
									style="width: 150.797px;">Is Answered</th>
									
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Status: activate to sort column ascending"
									style="width: 150.797px;">Answer Sheet Uploaded Date</th>'<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Status: activate to sort column ascending"
									style="width: 150.797px;">Answer Sheet Uploaded By(Roll No.)<i class="fa fa-search" aria-hidden="true"></i></th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Status: activate to sort column ascending"
									style="width: 150.797px;">Answer Sheet Uploaded By(Name)<i class="fa fa-search" aria-hidden="true"></i></th>
								<th class="sorting" tabindex="0" aria-controls="recordsListView"
									rowspan="1" colspan="1"
									aria-label="Status: activate to sort column ascending"
									style="width: 150.797px;">Answer Sheet Uploaded By(Email)<i class="fa fa-search" aria-hidden="true"></i></th>
								<th class="not-sortable sorting_disabled" rowspan="1"
									colspan="1" aria-label="Actions" style="width: 73.0781px;">Answer Sheet Download</th>
									<th class="not-sortable sorting_disabled" rowspan="1"
									colspan="1" aria-label="Actions" style="width: 73.0781px;">Re-Submit Answer Sheet</th>
									<th class="not-sortable sorting_disabled" rowspan="1"
									colspan="1" aria-label="Actions" style="width: 73.0781px;">Answer Sheet Delete</th>
									
							</tr>
						</thead>
						<tbody>
						<c:if test="${!empty finalList}">
						<c:forEach items="${finalList}" varStatus="index" var="record">
							<tr role="row" class="odd">
								<td>${index.count}</td>
								<td>${record.meterialTitle}</td>
								<td>${record.meterialName}</td>
								<td>${record.batch}</td>
								<td>${record.courseCategory}</td>
								<td>${record.questionCreatedDate}</td>
								<td>${record.questionCreatedby}</td>
								<td>${record.answerGiven}</td>
								<td>${record.answerCreatedDate}</td>
								<td>${record.answerCreatedByRollNo}</td>
								<td>${record.answerCreatedByName}</td>
								<td>${record.answerCreatedByEmail}</td>
								<td><a
									style="font-size: 22px !important; cursor: pointer !important;"
									href="<%=request.getContextPath()%>/downloadSheets?folderId=${record.answerFolderId}&action=ANSWER"><i
										class="fa fa-download" aria-hidden="true"></i></a></td>
								<c:choose>

									<c:when test="${record.answerGiven eq true}">

										<td><a
											style="font-size: 22px !important; cursor: pointer !important;"
											href="#"
											onclick="reSubmitAnswerSheet('${record.answerFolderId}')"><i
												class="fa fa-power-off" aria-hidden="true"></i></a></td>
									</c:when>
									<c:otherwise>

										<td><a
											style="font-size: 15px !important; font-weight: 700 !important; cursor: pointer !important;"
											href="#">ANSWER NOT SUBMITTED</a></td>
									</c:otherwise>
								</c:choose>
								<td><a
									style="font-size: 22px !important; cursor: pointer !important;"
									href="#"
									onclick="deleteFilesAndFolder(${record.questionAnswerId})"><i
										class="fa fa-trash" aria-hidden="true"></i></a></td>
							</tr>
							</c:forEach>
					</c:if>
							
						</tbody>
					</table>
				</div>
			
			</div>
		</div>
	</div>
</section>






