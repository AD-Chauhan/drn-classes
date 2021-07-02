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
			videoDwrUtils.deleteQuestionById(parseInt(questionAnswerId),{callback:function(message){
				window.location.href=pageContext+"/view-exam-question-sheet";
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


</script>


<section class="main--content">

	<div class="panel">
		<div class="records--list" data-title="Orders Listing">
			<table id="recordsListView" width="100%">
				<thead>
					<tr>
						<th>SR No.</th>
						<th>Question Sheet Title</th>
						<th>Question Sheet Name</th>
						<th>Batch</th>
						<th>Course Category</th>
						<th>Question Sheet Uploaded Date</th>
						<th>Question Sheet Uploaded By</th>
						
						<th>Question Sheet Delete</th>
						<th>Question Sheet Download</th>
						
                        
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty finalList}">
						<c:forEach items="${finalList}" varStatus="index" var="record">
							<tr>
								<td>${index.count}</td>
								<td>${record.meterialTitle}</td>
								<td>${record.meterialName}</td>
								<td>${record.batch}</td>
								<td>${record.courseCategory}</td>
								<td>${record.questionCreatedDate}</td>
								<td>${record.questionCreatedby}</td>
								
								<td><a style="font-size: 22px !important;cursor: pointer !important;" href="#" onclick="deleteFilesAndFolder(${record.questionAnswerId})"><i
										class="fa fa-trash" aria-hidden="true"></i></a></td>
								<td><a style="font-size: 27px !important;" href="<%=request.getContextPath()%>/downloadSheets?folderId=${record.questionFolderId}&action=QUESTION"
									><i
										class="fa fa-download" aria-hidden="true"></i></a></td>
										
									

							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</section>




