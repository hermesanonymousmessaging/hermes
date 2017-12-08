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
								<c:if test="${!empty otherProfileUser}">
								<h3 class="profile-username text-center"><a href="/test/profile/${otherProfileUser.getUsername()}">${otherProfileUser.getFirstName()}
									${otherProfileUser.getLastName()}</a></h3>
								</c:if>
								<c:if test="${!empty otherProfilesFirst}">
								<h3 class="profile-username text-center"><a href="/test/profile/${otherProfilesFirst[0].getUsername()}">${otherProfilesFirst[0].getFirstName()}
									${otherProfilesFirst[0].getLastName()}</a></h3>
								</c:if>
								<c:if test="${!empty otherProfilesFirst[1]}">
								<h3 class="profile-username text-center"><a href="/test/profile/${otherProfilesFirst[1].getUsername()}">${otherProfilesFirst[1].getFirstName()}
									${otherProfilesFirst[1].getLastName()}</a></h3>
								</c:if>	
								<c:if test="${!empty otherProfilesLast}">
								<h3 class="profile-username text-center"><a href="/test/profile/${otherProfilesLast[0].getUsername()}">${otherProfilesLast[0].getFirstName()}
									${otherProfilesLast[0].getLastName()}</a></h3>
								</c:if>
								<c:if test="${!empty otherProfilesLast[1]}">
								<h3 class="profile-username text-center"><a href="/test/profile/${otherProfilesLast[1].getUsername()}">${otherProfilesLast[1].getFirstName()}
									${otherProfilesLast[1].getLastName()}</a></h3>
								</c:if>
								<c:if test="${!empty searchChannels}">
								<h3 class="profile-username text-center"><a href="/test/channelView/${searchChannels.get(0).getId()}">${searchChannels.get(0).getName()}</a></h3>
								</c:if>
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