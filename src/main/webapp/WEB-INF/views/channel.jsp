<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Channel</title>
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
				<h1>Channel</h1>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- DIRECT CHAT PRIMARY -->
						<div class="box box-primary direct-chat direct-chat-primary">
							<div class="box-header with-border">
								<h3 class="box-title">Direct Chat</h3>

								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool"
										data-toggle="tooltip" title="" data-widget="chat-pane-toggle"
										data-original-title="Channel Info">
										<i class="fa fa-info-circle"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<!-- Conversations are loaded here -->
								<div class="direct-chat-messages">
									<%@ include file="/WEB-INF/partials/channel-messages.jspf"%>
								</div>
								<!--/.direct-chat-messages-->

								<%@ include file="/WEB-INF/partials/channel-info.jspf"%>
								<!-- /.direct-chat-pane -->
							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<form action="#" method="post">
									<div class="input-group">
										<input type="text" name="message"
											placeholder="Type Message ..." class="form-control">
										<span class="input-group-btn">
											<button type="submit" class="btn btn-primary btn-flat">Send</button>
										</span>
									</div>
								</form>
							</div>
							<!-- /.box-footer-->
						</div>
						<!--/.direct-chat -->
					</div>
				</div>
				<div class="row">
					<div class="box-body">
						<!-- form start -->
						<form role="form" method="POST" action="/test/channel/{channelId}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="userName">Add User by username</label> <input
										type="text" class="form-control" id="name" placeholder="name"
										name="name">
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
						</form>
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