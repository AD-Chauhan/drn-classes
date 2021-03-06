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
	src="${pageContext.request.contextPath}/drnclasses/interface/blogsDwrUtils.js"></script>

<script type="text/javascript">	
function deleteFilesAndFolder(blogGallaryId){
	
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
	    		blogsDwrUtils.deleteFolderAndBlogsById(parseInt(blogGallaryId),{callback:function(message){
				window.location.href=pageContext+"/view-blogs";
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
			<table id="recordsListView">
				<thead>
					<tr>
						<th>SR No.</th>
						<th>Blog Name</th>
						<th>Blog Title</th>
						<th>File Name</th>
						<th>Schedule Date</th>
						<th>Description</th>
						<th>Created Date</th>
						<th>Created By</th>
						<th>Screenshot</th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty finalList}">
						<c:forEach items="${finalList}" varStatus="index" var="record">
							<tr>
								<td>${index.count}</td>
								<td>${record.blogName}</td>
								<td>${record.blogTitle}</td>
								<td>${record.originalFileName}</td>
								
								<td>${record.executionTime}</td>
								<td>${record.description}</td>
								<td>${record.createdDate}</td>
								<td>${record.createdby}</td>
								<td><img
									style="height: 77px !important; margin-top: 0px !important; margin-left: 0px !important; margin-right: 0px !important;"
									src="<%=request.getContextPath()%>${record.originalPath}${record.originalFileName}"
									alt=""></td>
								<td><a style="font-size: 27px !important;" href="#"
									onclick="deleteFilesAndFolder(${record.blogGallaryId})"><i
										class="fa fa-trash" aria-hidden="true"></i></a></td>

							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</section>




