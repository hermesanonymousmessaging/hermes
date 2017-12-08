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
				<h1>${channel.getName()}</h1>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-3">
						<ul class="contacts-list">
							<li>CHANNEL NAME: ${channel.getName()}</li>
							<li>CHANNEL OWNER: <a href="/test/profile/${owner.getUsername()}">${owner.getUsername()}</a></li>
							<li>Number of user: ${memberNo}</li>
							<c:forEach items="${sessionList}" var="item">
									<li>
										<ul>
											<li>Session Id: ${item.getId()}</li>
											<li>Session Start Date: ${item.getStartDate()}</li>
											<li>Session End Date: ${item.getEndDate()}</li>
											<li>Session Activity: ${item.getActive()}</li>
										</ul>
									</li>
								
							</c:forEach>
							
						<!-- End Contact Item -->
						</ul>
						<!-- Profile Image -->
						<div class="box box-primary">
							
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
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