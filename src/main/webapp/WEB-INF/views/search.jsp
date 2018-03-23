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
				<h1>Search</h1>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-3">

						<!-- Profile Image -->
						<div class="box box-primary">
							<div class="box-body box-profile">
							<c:forEach items="${searchUsers}" var="user" varStatus="counter">
								<c:if test="${!empty user}">
								<h3 class="profile-username text-center"><a href="/test/profile/${user.getUsername()}">${user.getFirstName()}
									${user.getLastName()}</a></h3>
								</c:if>
							</c:forEach>
							<c:forEach items="${searchChannels}" var="channel" varStatus="counter">
								<c:if test="${!empty channel}">
								<h3 class="profile-username text-center"><a href="/test/channelView/${channel.getId()}">${channel.getName()}</a></h3>
								</c:if>
							</c:forEach>
							</div>
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