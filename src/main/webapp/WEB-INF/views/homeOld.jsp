



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
				<!-- 				Sidebar toggle button -->
				<!-- 				<a href="#" class="sidebar-toggle" data-toggle="push-menu" -->
				<!-- 					role="button"> <span class="sr-only">Toggle navigation</span> -->
				<!-- 				</a> -->

				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#modal-login" data-backdrop="false"
					style="float: right;">Login</button>
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#modal-register" data-backdrop="false"
					style="float: right;">Register</button>

				<div class="modal modal-info fade" id="modal-login">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">Login</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal">
									<div class="box-body">
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">Email</label>

											<div class="col-sm-10">
												<input type="email" class="form-control" id="email"
													placeholder="Email">
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-2 control-label">Password</label>

											<div class="col-sm-10">
												<input type="password" class="form-control"
													id="inputPassword3" placeholder="Password">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label> <input type="checkbox"> Remember me
													</label>
												</div>
											</div>
										</div>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
										<button type="submit" class="btn btn-default"
											data-dismiss="modal">Cancel</button>
										<button type="submit" class="btn btn-info pull-right">Sign
											in</button>
									</div>
									<!-- /.box-footer -->
								</form>
							</div>
						</div>
						<!-- 						<div class="modal-footer"> -->
						<!-- 							<button type="button" class="btn btn-default pull-left" -->
						<!-- 								data-dismiss="modal">Close</button> -->
						<!-- 							<button type="button" class="btn btn-primary">Save -->
						<!-- 								changes</button> -->
						<!-- 						</div> -->
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
				<!-- /.modal -->

				<div class="modal modal-info fade" id="modal-register">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">Register</h4>
							</div>
							<div class="modal-body">
								<form method="POST" action="/test/createUser" modelAttribute="user" class="form-horizontal">
									<div class="box-body">
										<div class="form-group">
											<label for="firstName" class="col-sm-2 control-label">First Name</label>

											<div class="col-sm-10">
												<input type="firstName" class="form-control" id="firstName"
													placeholder="First Name" name="firstName">
											</div>
										</div>
										<div class="form-group">
											<label for="lastName" class="col-sm-2 control-label">Last Name</label>

											<div class="col-sm-10">
												<input type="lastName" class="form-control" id="lastName"
													placeholder="Last Name" name="lastName">
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">Email</label>

											<div class="col-sm-10">
												<input type="email" class="form-control" id="email"
													placeholder="Email" name="email">
											</div>
										</div>
										<div class="form-group">
											<label for="username" class="col-sm-2 control-label">Username</label>

											<div class="col-sm-10">
												<input type="username" class="form-control"
													id="username" placeholder="Username" name="username">
											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-2 control-label">Password</label>
											<div class="col-sm-10">
												<input type="password" class="form-control"
													id="password" placeholder="Re-Password" name="password">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label> <input type="checkbox"> Remember me
													</label>
												</div>
											</div>
										</div>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
										<button type="submit" class="btn btn-default"
											data-dismiss="modal">Cancel</button>
										<button type="submit" class="btn btn-info pull-right">Sign
											in</button>
									</div>
									<!-- /.box-footer -->
								</form>
							</div>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
				<!-- /.modal -->

			</nav>


		</header>

		<aside class="main-sidebar">

			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- Sidebar Menu -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">Navigation</li>
					<!-- Optionally, you can add icons to the links -->

					<li class="active"><a href="#"><i class="fa fa-info"></i>
							<span>About</span></a></li>
					<li class="active"><a href="#"><i class="fa fa-briefcase"></i>
							<span>Career</span></a></li>
					<li class="active"><a href="#"><i class="fa fa-heartbeat"></i>
							<span>Support</span></a></li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Anonymous Transient Shared Communication Channels</h1>
			</section>

			<!-- Main content -->
			<section class="content container-fluid">

				<!--------------------------
        | Your Page Content Here |
        -------------------------->







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
</body>
</html>



