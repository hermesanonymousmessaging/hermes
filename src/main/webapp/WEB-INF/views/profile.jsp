<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>User Profile</title>
<!-- Tell the browser to be responsive to screen width -->

<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="../resources/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../resources/adminlte/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="../resources/adminlte/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/adminlte/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="../resources/adminlte/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>H</b>S</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Hermes</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i> <span class="label label-success">1</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 1 messages</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#">
												<h4>
													Channel X <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4>
												<p>Alperen Ozkan: Hey, starting soon?</p>
										</a>
										</li>
										<!-- end message -->
									</ul>
								</li>
								<li class="footer"><a href="#">See All Messages</a></li>
							</ul></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">1</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 1 notification</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												5 new members joined today
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../resources/adminlte/dist/img/userbeko-160x160.jpg"
								class="user-image" alt="User Image"> <span
								class="hidden-xs">${profile.getFirstName()} ${profile.getLastName()}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../resources/adminlte/dist/img/userbeko-160x160.jpg"
									class="img-circle" alt="User Image">

									<p>
										${profile.getFirstName()} ${profile.getLastName()} <small>Professional T-Rex Hunter</small>
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center">
											<a href="#">Followers</a>
										</div>
										<div class="col-xs-4 text-center">
											<a href="#">Friends</a>
										</div>
									</div> <!-- /.row -->
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">

			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- Sidebar user panel (optional) -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="../resources/adminlte/dist/img/userbeko-160x160.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${profile.getFirstName()} ${profile.getLastName()}</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>

				<!-- search form (Optional) -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->

				<!-- Sidebar Menu -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">Navigation</li>
					<!-- Optionally, you can add icons to the links -->
					<li class="active"><a href="#"><i class="fa fa-circle"></i>
							<span>Home</span></a></li>
					<li class="active"><a href="#"><i class="fa fa-calendar"></i>
							<span>Schedule</span></a></li>
					<li class="active"><a href="#"><i
							class="fa fa-hourglass-half"></i> <span>Timeline</span></a></li>
					<li class="treeview"><a href="#"><i
							class="fa fa-envelope-o"></i> <span>Channels</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span> </a>
						<ul class="treeview-menu">
							<li class="treeview"><a href="#"><span>Sms</span> <span
									class="pull-right-container"> <i
										class="fa fa-angle-left pull-right"></i>
								</span> </a>
								<ul class="treeview-menu">
									<li><a href="#">Sms Channel 1</a></li>
									<li><a href="#">Sms Channel 2</a></li>
								</ul></li>
							<li><a href="#">E-Mail</a></li>
							<li><a href="#">Internet Messaging</a></li>
							<li><button type="button" onclick="#"
									class="btn btn-info btn-flat">
									<div class="col-md-3 col-sm-4">
										<i class="fa fa-fw fa-plus-square"></i> Add New Channel
									</div>
								</button></li>
						</ul></li>
					<li class="active"><a href="#"><i class="fa fa-info"></i>
							<span>About</span></a></li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

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
									src="../resources/adminlte/dist/img/userbeko-160x160.jpg"
									alt="User profile picture">

								<h3 class="profile-username text-center">${profile.getFirstName()} ${profile.getLastName()}</h3>

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
		<footer class="main-footer">
			<!-- Default to the left -->
			<strong>Copyright &copy; 2016 <a href="#">Hermes</a>.
			</strong> All rights reserved.
		</footer>

	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script
		src="../resources/adminlte/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="../resources/adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script
		src="../resources/adminlte/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="../resources/adminlte/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../resources/adminlte/dist/js/demo.js"></script>
</body>
</html>