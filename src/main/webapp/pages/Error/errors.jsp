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
	max-width: 113% !important;
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

<div class="wrapper">
	<div class="m-account-w"
		data-bg-img="<%=request.getContextPath()%>/resources/Admin/assets/img/bg-par2.jpg">
		<div class="m-account">
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
				<table>
<c:forEach items="${finalList}" var="element"> 
  <tr>
    <td>${element.firstName}</td>
    <td>${element.lastName}</td>
    <td>${element.email}</td>
       
  </tr>
</c:forEach> 
</table>
				
			</div>
		</div>
	</div>
</div>