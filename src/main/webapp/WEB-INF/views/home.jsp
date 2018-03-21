



<html>
<head>
<title>Hermes Anonymous Messaging</title>
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
<style>
body {
	font: 20px Montserrat, sans-serif;
	line-height: 1.8;
	color: #f5f6f7;
}

p {
	font-size: 16px;
}

.margin {
	margin-bottom: 45px;
}

.bg-1 {
	background-color: #496761; /* Green */
	color: #ffffff;
}

.bg-2 {
	background-color: #474e5d; /* Dark Blue */
	color: #ffffff;
}

.bg-3 {
	background-color: #ffffff; /* White */
	color: #555555;
}

.bg-4 {
	background-color: #2f2f2f; /* Black Gray */
	color: #fff;
}

.container-fluid {
	padding-top: 70px;
	padding-bottom: 70px;
}

.navbar {
	padding-top: 15px;
	padding-bottom: 15px;
	border: 0;
	border-radius: 0;
	margin-bottom: 0;
	font-size: 14px;
	letter-spacing: 5px;
	background-color: #3c8dbc;
	font-color: #3c8dbc;
}
.navbar-brand {
    color: #ffffff !important;
}
.navbar-nav  li a {
	color: #ffffff !important;
}
.navbar-nav  li a:hover {
	color: #1abc9c !important;
}
</style>

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
	<!-- Navbar -->
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="https://localhost:5001">Hermes</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">ABOUT</a></li>
					<li><a href="#">CONTACT</a></li>
					<li><a href="#">DEV</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- First Container -->
	<div class="container-fluid bg-1 text-center">
		<h3 class="margin">Welcome to Hermes Anonymous Messaging Website</h3>
		<img src="/resources/logo.png" class="img-responsive img-circle margin"
			style="display: inline" alt="LOGO" width="350" height="350">
		<div class="row">
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#modal-login" data-backdrop="false"
				style="float: center;">Login</button>
			<button type="button" class="btn btn-info" data-toggle="modal"
				data-target="#modal-register" data-backdrop="false"
				style="float: center;">Register</button>

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
							<form method="POST" action="/test/login" class="form-horizontal">
								<div class="box-body">
									<div class="form-group">
										<label for="email" class="col-sm-2 control-label">Username</label>

										<div class="col-sm-10">
											<input type="username" class="form-control" id="username"
												placeholder="Username" name = "username">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword3" class="col-sm-2 control-label">Password</label>

										<div class="col-sm-10">
											<input type="password" class="form-control"
												id="password" placeholder="Password" name="password">
										</div>
									</div>
									
								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="submit" class="btn btn-info">Sign
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
							<form method="POST" action="/test/createUser"
								modelAttribute="user" class="form-horizontal">
								<div class="box-body">
									<div class="form-group">
										<label for="firstName" class="col-sm-2 control-label">First
											Name</label>

										<div class="col-sm-10">
											<input type="firstName" class="form-control" id="firstName"
												placeholder="First Name" name="firstName">
										</div>
									</div>
									<div class="form-group">
										<label for="lastName" class="col-sm-2 control-label">Last
											Name</label>

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
											<input type="username" class="form-control" id="username"
												placeholder="Username" name="username">
										</div>
									</div>
									<div class="form-group">
										<label for="phoneNumber" class="col-sm-2 control-label">Phone Number</label>

										<div class="col-sm-10">
											<input type="phoneNumber" class="form-control" id="phoneNumber"
												placeholder="Phone Number" name="phoneNumber">
										</div>
									</div>
									<div class="form-group">
										<label for="profilePicture" class="col-sm-2 control-label">Profile Picture URL</label>

										<div class="col-sm-10">
											<input type="profilePicture" class="form-control" id="profilePicture"
												placeholder="Profile Picture URL" name="profilePicture">
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-2 control-label">Password</label>
										<div class="col-sm-10">
											<input type="password" class="form-control" id="password"
												placeholder="Password" name="password">
										</div>
									</div>
								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="submit" class="btn btn-info">Register</button>
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
		</div>
	</div>


	<!-- Main Footer -->
		<%@ include file="/WEB-INF/partials/footer.jspf"%>
		
	<!-- Script library -->
	<%@ include file="/WEB-INF/partials/scriptLib.jspf"%>

</body>
</html>



