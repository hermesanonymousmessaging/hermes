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
			<section class="content-header">
				<h1>Favourite Messages</h1>
			</section>
			<section class="content">

					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<!-- The time line -->
							<ul class="timeline">
								<!-- timeline time label -->
								<!-- /.timeline-label -->
								<!-- timeline item -->
								
								<c:forEach items="${favouriteMessages}" var="msg" varStatus="counter">
									<li>
									
										<i class="fa fa-envelope bg-blue"></i>
											<div class="timeline-item">
<%-- 												<span class="time"><small class="pull-right">${favouriteMessages.getTimestamp().toLocaleString()}</small></span> --%>

												<h3 class="timeline-header">
													<a href="/test/channel/<c:out value="${msg.getChannelId()}"/>"><c:out value="${current.getUserName()}" />Channel name : ${msg.getChannelName()}</a>
												</h3>
											    	<div class="timeline-body">
											    	${msg.getMessageText()}
											    	</div>
											</div>
										</a>
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
