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
				<h1>User Profile</h1>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-3">

						<!-- Profile Image -->
						<div class="box box-primary">
							<div class="box-body box-profile">
								<img class="profile-user-img img-responsive img-circle"
									src="${otherProfile.getProfilePicture()}"
									alt="User profile picture">

								<h3 class="profile-username text-center">${otherProfile.getFirstName()}
									${otherProfile.getLastName()}</h3>

								<p class="text-muted text-center">Software Engineer</p>

								<a href="#" class="btn btn-primary btn-block"><b>Contact</b></a>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
					<div class="col-md-9">
						<div class="nav-tabs-custom">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#about" data-toggle="tab">About</a></li>
								<li><a href="#channels" data-toggle="tab">Channels</a></li>
								<li><a href="#schedule" data-toggle="tab">Schedule</a></li>
							</ul>
							<div class="tab-content">
								<div class="active tab-pane" id="about">
									<div class="box-body">
										<strong><i class="fa fa-book margin-r-5"></i>
											Education</strong>

										<p class="text-muted">B.S. in Computer Science from the
											Istanbul Technical University</p>

										<hr>

										<strong><i class="fa fa-map-marker margin-r-5"></i>
											Location</strong>

										<p class="text-muted">Istanbul, Turkey</p>

										<hr>

										<strong><i class="fa fa-file-text-o margin-r-5"></i>
											Notes</strong>

										<p>Since I'm busy this term, it might take a few hours for
											me to reply back. Sorry for inconvenience.</p>

										<hr>

										<strong><i class="fa fa-clock-o margin-r-5"></i>
											Available times</strong>

										<p>I'm available from 9-to-5 from Mondays to Thursdays</p>

										<hr>

										<strong><i class="fa fa-comments margin-r-5"></i>
											Preferred communication channels</strong>

										<p>
											<span class="label label-primary">E-mail</span> <span
												class="label label-primary">In app message</span> <span
												class="label label-primary">SMS</span>
										</p>

									</div>
								</div>
								<!-- /.tab-pane -->
								<div class="tab-pane" id="channels">

									<div class="box-body">

										<h4>
											<i class="fa fa-caret-right" aria-hidden="true"></i> Channel
											X
										</h4>
										<p>General discussion about ChannelX project</p>
										<br>

										<h4>
											<i class="fa fa-caret-right" aria-hidden="true"></i> 2F2A
										</h4>
										<p>General discussion about 2Fast2Autonomous project</p>
										<br>

										<h4>
											<i class="fa fa-caret-right" aria-hidden="true"></i> COMCOM
										</h4>
										<p>General discussion related to BLG433E Computer
											Communications class</p>
										<br>

										<h4>
											<i class="fa fa-caret-right" aria-hidden="true"></i> ITU ACM
										</h4>
										<p>Announcements related to ITU ACM organization</p>
										<br>

									</div>

								</div>
								<!-- /.tab-pane -->
								<div class="tab-pane" id="schedule">
									<p>Schdule will be added here</p>
								</div>
								<!-- /.tab-pane -->
							</div>
							<!-- /.tab-content -->
						</div>
						<!-- /.nav-tabs-custom -->
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