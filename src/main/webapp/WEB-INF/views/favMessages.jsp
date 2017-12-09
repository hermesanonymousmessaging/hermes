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
				<h1></h1>
			</section>

			<!-- Main content -->
			<section class="content">

				<div class="row">
					<div class="col-md-12">
						<!-- DIRECT CHAT PRIMARY -->
						<div class="box box-primary direct-chat direct-chat-primary">
							
							<!-- /.box-header -->
							<div class="box-body">
								<!-- Conversations are loaded here -->
								<div class="direct-chat-messages">
									<%@ include file="/WEB-INF/partials/fav-messages.jspf"%>
								</div>
								<!--/.direct-chat-messages-->
								<!-- /.direct-chat-pane -->
							</div>
							<!-- /.box-body -->
							<!-- /.box-footer-->
						</div>
						<!--/.direct-chat -->
					</div>
				
				
					<!-- /.col -->
<!-- 					<div class="col-md-9"> -->
<!-- 						<div class="nav-tabs-custom"> -->
<!-- 							<ul class="nav nav-tabs"> -->
<!-- 								<li><a href="#messages" data-toggle="tab">Favourite Messages</a></li> -->
<!-- 							</ul> -->
<!-- 							<div class="tab-content"> -->
<!-- 								<div class="tab-pane" id="messages"> -->
<!-- 									<p>Schdule will be added here</p> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						/.nav-tabs-custom -->
<!-- 					</div> -->
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
