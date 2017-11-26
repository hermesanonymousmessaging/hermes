<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>CHANGE THE TITLE</title>
<!-- IMPORT STYLES HERE -->

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


<link rel="stylesheet" href="../resources/css/chat.css" />

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

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>H</b>S</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Hermes</b></span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
								class="label label-success">4</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 4 messages</li>
								<li>
									<!-- inner menu: contains the messages -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#"> <!-- Message title and timestamp -->
												<h4>
													Channel A <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4> <!-- The message -->
												<p>Dehrioglu #A03C: Greetings, Mr. Giriş.</p>
										</a>
										</li>
										<!-- end message -->
									</ul> <!-- /.menu -->
								</li>
								<li class="footer"><a href="#">See All Messages</a></li>
							</ul>
						</li>
						<!-- /.messages-menu -->

						<!-- Notifications Menu -->
						<li class="dropdown notifications-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
								class="label label-warning">10</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 10 notifications</li>
								<li>
									<!-- Inner Menu: contains the notifications -->
									<ul class="menu">
										<li>
											<!-- start notification --> <a href="#"> <i
												class="fa fa-users text-aqua"></i> 5 new members joined your
												channel today
										</a>
										</li>
										<!-- end notification -->
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul>
						</li>
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar-->
								<img src="../resources/adminlte/dist/img/userbeko-160x160.jpg"
								class="user-image" alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">Berkay Giriş</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img
									src="../resources/adminlte/dist/img/userbeko-160x160.jpg"
									class="img-circle" alt="User Image">

									<p>
										Berkay Giriş <small>Professional T-Rex Hunter</small>
									</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="/test/logout" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul>
						</li>
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
						<p>Berkay Giriş</p>
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
			        <li class="active"><a href="#"><i class="fa fa-circle"></i> <span>Home</span></a></li>
			        <li class="active"><a href="#"><i class="fa fa-calendar"></i> <span>Schedule</span></a></li>
			        <li class="active"><a href="#"><i class="fa fa-hourglass-half"></i> <span>Timeline</span></a></li>   
			        <li class="treeview">
			          <a href="#"><i class="fa fa-envelope-o"></i> <span>Channels</span>
			            <span class="pull-right-container">
			                <i class="fa fa-angle-left pull-right"></i>
			              </span>
			          </a>
			          <ul class="treeview-menu">
			          	<li class="treeview">
			          		<a href="#"><span>Sms</span>
			            			<span class="pull-right-container">
			                			<i class="fa fa-angle-left pull-right"></i>
			              		</span>
			          		</a>
			          		<ul class="treeview-menu">
			            			<li><a href="#">Sms Channel 1</a></li>
			            			<li><a href="#">Sms Channel 2</a></li>
			          		</ul>
			        		</li>
			            <li><a href="#">E-Mail</a></li>
			            <li><a href="#">Internet Messaging</a></li>
			            <li><button type="button" onclick="#" class="btn btn-info btn-flat"><div class="col-md-3 col-sm-4"><i class="fa fa-fw fa-plus-square"></i> Add New Channel</div></button></li>
			          </ul>
			        </li>
			        <li class="active"><a href="#"><i class="fa fa-info"></i> <span>About</span></a></li>     
			      </ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Chat <small>Optional description</small>
				</h1>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">

				<div class="container app">
					<div class="row app-one">

						<div class="col-sm-4 side">
							<div class="side-one">
								<!-- Heading -->
								<div class="row heading">
									<div class="col-sm-3 col-xs-3 heading-avatar">
										<div class="heading-avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-1 col-xs-1  heading-dot  pull-right">
										<i class="fa fa-ellipsis-v fa-2x  pull-right"
											aria-hidden="true"></i>
									</div>
									<div class="col-sm-2 col-xs-2 heading-compose  pull-right">
										<i class="fa fa-comments fa-2x  pull-right" aria-hidden="true"></i>
									</div>
								</div>
								<!-- Heading End -->

								<!-- SearchBox -->
								<div class="row searchBox">
									<div class="col-sm-12 searchBox-inner">
										<div class="form-group has-feedback">
											<input id="searchText" type="text" class="form-control"
												name="searchText" placeholder="Search"> <span
												class="glyphicon glyphicon-search form-control-feedback"></span>
										</div>
									</div>
								</div>

								<!-- Search Box End -->
								<!-- sideBarChat -->
								<!-- EXPANDABLE BOX BOX BOX BOX -->
								<div class="box box-default box-solid collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Channel 1</h3>

										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
										<!-- /.box-tools -->
									</div>
									<!-- /.box-header -->
									<div class="box-body">
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 1 (Channel 1) </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 5 (Channel 1)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 2 (Channel 1)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
								<!-- EXPANDABLE BOX BOX BOX BOX -->

								<!-- EXPANDABLE BOX BOX BOX BOX -->
								<div class="box box-default box-solid collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Channel 2</h3>

										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
										<!-- /.box-tools -->
									</div>
									<!-- /.box-header -->
									<div class="box-body">
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 156 (Channel 2)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 5 (Channel 2)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
								<!-- EXPANDABLE BOX BOX BOX BOX -->
								<div class="sideBar-group">
									<div class="row sideBarChat-body">
										<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
											<div class="avatar-icon">
												<img src="http://shurl.esy.es/y">
											</div>
										</div>
										<div class="col-sm-9 col-xs-9 sideBarChat-main">
											<div class="row">
												<div class="col-sm-8 col-xs-8 sideBarChat-name">
													<span class="name-meta">Channel 3 (Group Messaging)</span>
												</div>
												<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
													<span class="time-meta pull-right">18:18 </span>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- EXPANDABLE BOX BOX BOX BOX -->
								<div class="box box-default box-solid collapsed-box">
									<div class="box-header with-border">
										<h3 class="box-title">Channel 4</h3>

										<div class="box-tools pull-right">
											<button type="button" class="btn btn-box-tool"
												data-widget="collapse">
												<i class="fa fa-plus"></i>
											</button>
										</div>
										<!-- /.box-tools -->
									</div>
									<!-- /.box-header -->
									<div class="box-body">
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 7 (Channel 3)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 3 (Channel 3)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
										<div class="row sideBarChat-body">
											<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
												<div class="avatar-icon">
													<img src="http://shurl.esy.es/y">
												</div>
											</div>
											<div class="col-sm-9 col-xs-9 sideBarChat-main">
												<div class="row">
													<div class="col-sm-8 col-xs-8 sideBarChat-name">
														<span class="name-meta">Person 6 (Channel 3)  </span>
													</div>
													<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
														<span class="time-meta pull-right">18:18 </span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- /.box-body -->
								</div>
								<!-- /.box -->
								<!-- EXPANDABLE BOX BOX BOX BOX -->


							</div>
							<!-- Sidebar End -->
						<div class="side-two">

							<!-- Heading -->
							<div class="row newMessage-heading">
								<div class="row newMessage-main">
									<div class="col-sm-2 col-xs-2 newMessage-back">
										<i class="fa fa-arrow-left" aria-hidden="true"></i>
									</div>
									<div class="col-sm-10 col-xs-10 newMessage-title">New
										Chat</div>
								</div>
							</div>
							<!-- Heading End -->

							<!-- ComposeBox -->
							<div class="row composeBox">
								<div class="col-sm-12 composeBox-inner">
									<div class="form-group has-feedback">
										<input id="composeText" type="text" class="form-control"
											name="searchText" placeholder="Search People"> <span
											class="glyphicon glyphicon-search form-control-feedback"></span>
									</div>
								</div>
							</div>
							<!-- ComposeBox End -->

							<!-- sideBarChat -->
							<div class="row compose-sideBarChat">
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>

								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
								<div class="row sideBarChat-body">
									<div class="col-sm-3 col-xs-3 sideBarChat-avatar">
										<div class="avatar-icon">
											<img src="http://shurl.esy.es/y">
										</div>
									</div>
									<div class="col-sm-9 col-xs-9 sideBarChat-main">
										<div class="row">
											<div class="col-sm-8 col-xs-8 sideBarChat-name">
												<span class="name-meta">Person x </span>
											</div>
											<div class="col-sm-4 col-xs-4 pull-right sideBarChat-time">
												<span class="time-meta pull-right">18:18 </span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Sidebar End -->
					</div>


					<!-- New Message Sidebar End -->

					<!-- Conversation Start -->
					<div class="col-sm-8 conversation">
						<!-- Heading -->
						<div class="row heading">
							<div class="col-sm-2 col-md-1 col-xs-3 heading-avatar">
								<div class="heading-avatar-icon">
									<img src="http://shurl.esy.es/y">
								</div>
							</div>
							<div class="col-sm-8 col-xs-7 heading-name">
								<a class="heading-name-meta">Berkay</a> <span
									class="heading-online">Online</span>
							</div>
							<div class="col-sm-1 col-xs-1  heading-dot pull-right">
								<i class="fa fa-ellipsis-v fa-2x  pull-right" aria-hidden="true"></i>
							</div>
						</div>
						<!-- Heading End -->

						<!-- Message Box -->
						<div class="row message" id="conversation">

							<div class="row message-previous">
								<div class="col-sm-12 previous">
									<a onclick="previous(this)" id="ankitjain28" name="20">
										Show Previous Messages </a>
								</div>
							</div>
							<c:forEach items="${messageList}" var="message">
								<div class="row message-body">
								<c:if test = "${message.getSenderId() == login.getId()}" >
									<div class="col-sm-12 message-main-sender">
										<div class="sender">
								</c:if>
								<c:if test = "${message.getSenderId() != login.getId()}" >
									<div class="col-sm-12 message-main-receiver">
										<div class="receiver">
								</c:if>
											<div class="message-text">${message.getText()}</div>
											<span class="message-time pull-right"> ${message.getTimestamp()} </span>
										</div>
									</div>
								</div>
							</c:forEach>
							
							<div class="row message-body">
								<div class="col-sm-12 message-main-receiver">
									<div class="receiver">
										<div class="message-text">This chat is awesome</div>
										<span class="message-time pull-right"> 18:15 </span>
									</div>
								</div>
							</div>
							
							<div class="row message-body">
								<div class="col-sm-12 message-main-receiver">
									<div class="receiver">
										<div class="message-text">Hello sir</div>
										<span class="message-time pull-right"> 18:19 </span>
									</div>
								</div>
							</div>
							

							<div class="row message-body">
								<div class="col-sm-12 message-main-sender">
									<div class="sender">
										<div class="message-text">Hi what is up?</div>
										<span class="message-time pull-right"> 18:20 </span>
									</div>
								</div>
							</div>
							
							<div class="row message-body">
								<div class="col-sm-12 message-main-sender">
									<div class="sender">
										<div class="message-text">You can contact me from here</div>
										<span class="message-time pull-right"> 18:20 </span>
									</div>
								</div>
							</div>
							
							<div class="row message-body">
								<div class="col-sm-12 message-main-sender">
									<div class="sender">
										<div class="message-text">Okay?</div>
										<span class="message-time pull-right"> 18:20 </span>
									</div>
								</div>
							</div>
						</div>
						<!-- Message Box End -->

						<!-- Reply Box -->
						<form method="POST" name="message" action="/test/send">
							<input type="hidden" name="channelId" value="CHANGETHIS">
							<div class="row reply">
								<div class="col-sm-1 col-xs-1 reply-emojis">
									<i class="fa fa-smile-o fa-2x"></i>
								</div>
								<div class="col-sm-9 col-xs-9 reply-main">
									
									<textarea name="usermsg" autocomplete="off" id="usermsg" class="form-control" rows="1"></textarea>
									
								</div>
								<div class="col-sm-1 col-xs-1 reply-recording">
									
								</div>
								<div class="col-sm-1 col-xs-1 reply-send">
									<i class="fa fa-send fa-2x" aria-hidden="true"></i>
								</div>
							</div>
						</form>
						<!-- Reply Box End -->
					</div>
					<!-- Conversation End -->
				</div>
				<!-- App One End -->
		</div>

		<!-- App End -->

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
	<!-- jQuery UI 1.11.4 -->
	<script
		src="../resources/adminlte/bower_components/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="../resources/adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="../resources/adminlte/bower_components/raphael/raphael.min.js"></script>
	<script
		src="../resources/adminlte/bower_components/morris.js/morris.min.js"></script>
	<!-- Sparkline -->
	<script
		src="../resources/adminlte/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script
		src="../resources/adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="../resources/adminlte/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="../resources/adminlte/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="../resources/adminlte/bower_components/moment/min/moment.min.js"></script>
	<script
		src="../resources/adminlte/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- datepicker -->
	<script
		src="../resources/adminlte/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="../resources/adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script
		src="../resources/adminlte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="../resources/adminlte/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="../resources/adminlte/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="../resources/adminlte/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../resources/adminlte/dist/js/demo.js"></script>
	
	<script>
	$("#usermsg").keypress(function (e) {
	    if(e.which == 13 && !e.shiftKey) {        
	        $(this).closest("form").submit();
	        e.preventDefault();
	        return false;
	    }
	});
	</script>
</body>
</html>
