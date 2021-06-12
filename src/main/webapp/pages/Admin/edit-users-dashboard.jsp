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
				videoDwrUtils.deleteFolderAndVideoById(parseInt(userid),action,{callback:function(message){
					window.location.href=pageContext+"/video-details";
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
				videoDwrUtils.deleteFolderAndVideoById(parseInt(userid),action,{callback:function(message){
					window.location.href=pageContext+"/video-details";
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
					                     <c:if test="${!empty record.userRole}">
					                     
					                     <c:forEach items="${record.userRole}" varStatus="index" var="roles">
					                        <li style="margin-top: 5px !important;"><span style="color: #b13b0f !important; font-weight: 700 !important;text-transform: uppercase !important;">${roles.abbreCode}</span> </li>
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

							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
</section>




