<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>User Profile</title>
<%@ include file="/WEB-INF/partials/headerStyle.jspf"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@ include file="/WEB-INF/partials/header.jspf"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@ include file="/WEB-INF/partials/sidebar.jspf"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header"></section>

			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
						Notifications
					</h1>
				</section>

				<!-- Main content -->
				<section class="content">

					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<!-- The time line -->
							<ul class="timeline">
								<!-- timeline time label -->
								<!-- /.timeline-label -->
								<!-- timeline item -->
								
								<c:forEach items="${notifications}" var="notification" varStatus="counter">
									<li>
										<i class="fa 
											<c:choose>
											    <c:when test="${notification.isMessage()}">
											    	fa-envelope bg-blue">
											    </c:when>
											    
											    <c:when test="${notification.isInvite()}">
											    	fa-user-plus bg-aqua">
											    </c:when>
											    <c:when test="${notification.isApproved()}">
											    	fa-check-circle bg-green">
											    </c:when>
											    <c:when test="${notification.isJoin()}">
											    	fa-user bg-green">
											    </c:when>
											    <c:when test="${notification.isBanned()}">
											    	fa-close bg-red">
											    </c:when>
											    <c:when test="${notification.isKicked()}">
											    	fa-close bg-yellow">
											    </c:when>
											    <c:otherwise></c:otherwise>
											</c:choose>
											</i>

											<div class="timeline-item">
												<span class="time"><small class="pull-right">${notification.getTimestamp().toLocaleString()}</small></span>

												<h3 class="timeline-header">
													<a href="#">${notification.toString()}</a>
												</h3>
												<c:choose>
												<c:when test="${notification.isInvite()}">
											    	<div class="timeline-footer">
														<form role="form" method="POST"
															action="/test/channel/{channelId}" modelAttribute="user">
															<input type="hidden" name="channelId"
																value="${notification.getChannelId()}"> <input
																type="hidden" name="name"
																value="${notification.getRecipientName()}">
															<button type="submit" class="btn btn-primary">Accept</button>
															<!-- /.box-body -->
														</form>


<!-- 														<a class="btn btn-primary btn-xs">Accept</a>  -->
<!-- 													<a class="btn btn-danger btn-xs">Ignore</a> -->
													</div>
											    </c:when>
											    <c:when test="${notification.isJoin()}">
											    	<div class="timeline-body">
                									</div>${notification.getApplicantName()} wants to join ${notification.getChannelName()}
											    
											    
											    	<div class="timeline-footer">
														<form role="form" method="POST"
															action="/test/channel/{channelId}"
															modelAttribute="user">
															<input type="hidden" name="channelId" value="${notification.getChannelId()}">
															<input type="hidden" name="name" value="${notification.getApplicantName()}">
															<button type="submit" class="btn btn-primary">Accept</button>
															<!-- /.box-body -->
														</form>
<!-- 														<button type="submit" class="btn btn-danger">Ignore</button> -->
													</div>
											    </c:when>
											    <c:otherwise></c:otherwise>
											</c:choose>
											</div>
									</li>
								</c:forEach>
								
								<!-- END timeline item -->
								<!-- timeline item -->
							</ul>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->

				</section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->

			<!-- Main Footer -->
			<%@ include file="/WEB-INF/partials/footer.jspf"%>

		</div>
		<!-- ./wrapper -->

		<!-- Script library -->
		<%@ include file="/WEB-INF/partials/scriptLib.jspf"%>
</body>
</html>
