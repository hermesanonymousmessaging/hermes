<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Create a new Channel</title>
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
	<link rel="stylesheet" type="text/css" href="../resources/adminlte/bower_components/bootstrap-daterangepicker/daterangepicker.css"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@ include file="/WEB-INF/partials/header.jspf"%>
		<!-- Left side column. contains the logo and sidebar -->
		<%@ include file="/WEB-INF/partials/sidebar.jspf"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<!-- /.col -->
					<div class="col-md-12 col-lg-7">
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">Create a new Channel</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form role="form" method="POST" action="/test/createChannel"
								modelAttribute="user">
								<div id="addDateCount"><input type="hidden" name="dateCount" value="1"></div>
								<div class="box-body">
									<div class="form-group">
										<label for="channelName">Channel Name</label> <input
											type="text" class="form-control" id="name"
											placeholder="name" name="name">
									</div>
									<div class="row">
										<div class="col-md-3">
											<div class="box box-body">
												<div class="form-group">
													<div class="radio">
														<label> <input type="radio" name="type" id="type1"
															value="internet" checked=""> Internet Messaging
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="type" id="type2"
															value="email" disabled=""> e-Mail
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="type" id="type3"
															value="sms" disabled=""> SMS
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-5">
											<div class="box box-body">
												<div class="form-group">
													<div class="radio">
														<label> <input type="radio" name="public"
															id="public1" value="public" checked=""> <i class="fa fa-fw fa-unlock"></i> Public 
															<p class="text-muted">Channel will show up on search,
																everyone can join</p>
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="public"
															id="public2" value="private"> <i class="fa fa-fw fa-lock"></i> Private 
															<p class="text-muted">Channel will show up on search,
																users must apply or get invited to join</p>
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="public"
															id="public3" value="hidden"> <i class="fa fa-fw fa-eye-slash"></i> Hidden 
															<p class="text-muted">Channel will not show up on
																search, users need invite to join</p>
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="box box-body">
												<div class="form-group">
													<div class="radio">
														<label> <input type="radio" name="group"
															id="group2" value="direct" checked=""> <i class="fa fa-fw fa-user"></i> Direct 
															<p class="text-muted">Every member will contact with the owner seperately</p>
														</label>
													</div>
													<div class="radio">
														<label> <input type="radio" name="group"
															id="group2" value="group"> <i class="fa fa-fw fa-users"></i> Group 
															<p class="text-muted">Messages will be sent to all members</p>
														</label>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="box box-body">
										<div class="form-group">
											<label>Date and time range:</label>
											<div class="row">
												<div class="input-group col-md-8">
													<div class="input-group-addon">
														<i class="fa fa-clock-o"></i>
													</div>
													<input type="text" class="form-control pull-right daterange" id="daterange0" name="daterange0" style="width:100%;">
												</div>
												<div id="addDatePicker"></div>
											</div>
										</div>
										<div class="input-group">
											
											<div class="input-group-btn">
												<button onclick="createDate()" id="add-new-event" type="button"
													class="btn btn-primary btn-flat">Add</button>
											</div>
											<!-- /btn-group -->
										</div>
										<div id="error" class="row"></div>
									</div>
								</div>
								<!-- /.box-body -->

								<div class="box-footer">
									<button type="submit" class="btn btn-primary">Create</button>
								</div>
							</form>
						</div>
						<!-- /.box -->
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
	<script src="../resources/adminlte/bower_components/moment/min/moment.min.js"></script>
	<script src="../resources/adminlte/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>

	<script type="text/javascript">
		$(function() {
			$('.daterange').daterangepicker({
				timePicker : true,
				timePickerIncrement : 30,
				locale : {
					format : 'MM/DD/YYYY h:mm A'
				}
			});
		});
	</script>
	<script>
	var div = '';
	var cnt = 1;
		function createDate(){
			if(cnt<5){
				div = div + '<div class="input-group col-md-8"><div class="input-group-addon"><i class="fa fa-clock-o"></i></div><input type="text" class="form-control pull-right daterange" id="daterange'+cnt+'" name="daterange'+cnt+'" style="width:100%;"></div>';
				document.getElementById("addDatePicker").innerHTML = div;
					$('.daterange').daterangepicker({
						timePicker : true,
						timePickerIncrement : 30,
						locale : {
							format : 'MM/DD/YYYY h:mm A'
						}
					});
					cnt++;
				var count = '<input type="hidden" name="dateCount" value="'+cnt+'">'
				document.getElementById("addDateCount").innerHTML = count;
			}
			else{
				var err = '<p class="text-red"><i class="fa fa-fw fa-exclamation"></i> You cant add more than 5 sessions for a channel</p>'
				document.getElementById("error").innerHTML = err;
			}
			
		}
	</script>

</body>
</html>