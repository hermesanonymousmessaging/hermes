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
					<div class="col-md-8">
						<ul class="contacts-list">
							<li>CHANNEL NAME: ${channel.getName()}</li>
							<li>CHANNEL OWNER: <a href="/test/profile/${owner.getUsername()}">${owner.getUsername()}</a></li>
							<li>Number of user: ${memberNo}</li>
							<div class="box-body table-responsive no-padding">
								<table class="table table-hover">
									<tbody>
										<tr>
										<div class="col-md-4"><th style="width: 100px">Start</th></div>
										<div class="col-md-4"><th style="width: 100px">End</th></div>
										<div class="col-md-4"><th style="width: 60px">Status</th></div>
										</tr>
										<c:forEach items="${sessionList}" var="item">
											<tr>
												<td>${item.getStartDateD()}</td>
												<td>${item.getEndDateD()}</td>
												<td>
													<c:if test="${item.getActive()}">
														<span class="label label-success">Active</span>
													</c:if>
													<c:if test="${!( item.getActive() )}">
														<span class="label label-danger">Not active</span>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						<!-- End Contact Item -->
						</ul>
						<!-- JOIN BUTTON -->
						
						<div class="box box-primary">
							<c:if test="${channel.isPublic() eq true}">
								<form role="form" method="POST" action="/test/channel/{channelId}">
									<input type="hidden" name="channelId" value="${channel.getId()}">
									<input type="hidden" name="name" value="${login.getUsername()}">
									<span class="input-group-btn">
										<button type="submit" class="btn btn-block btn-success"><i class="fa fa-fw fa-plus-square"></i> JOIN</button>
									</span>
								</form>
							</c:if>
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