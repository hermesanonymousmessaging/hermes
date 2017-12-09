<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<style type="text/css">
.ButtonClicked {
	color: Red;
}

.ButtonUnClicked {
	color: White;
}
</style>


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
				<h1>${channel.getName()}</h1>
				<div class="box-footer">
					<form role="form" method="POST" action="/test/addFavourites"
						style="display: inline">
						<input type="hidden" name="favChannelId"
							value="${channel.getId()}">
						<button type="submit" class="btn btn-primary"
							style="float: right;">Add to Favourites</button>


					</form>
					<form role="form" method="POST" action="/test/dropFavourites">
						<input type="hidden" name="favChannelId"
							value="${channel.getId()}">
						<button type="submit" class="btn btn-primary"
							style="float: right;">Remove from Favourites</button>

					</form>
				</div>

			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- DIRECT CHAT PRIMARY -->
						<div class="box box-primary direct-chat direct-chat-primary">
							<div class="box-header with-border">

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
								<form method="POST" name="message" action="/test/send">
									<input type="hidden" name="channelId"
										value="${channel.getId()}"> <input type="hidden"
										name="sessionId" value="${session.getId()}">
									<div class="input-group">
										<input type="text" name="usermsg" id="usermsg"
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
						<!-- form start -->
						<form role="form" method="POST"
							action="/test/channel/{channelId}/{banName}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="banName">Ban User by username</label> <input
										type="text" class="form-control" id="banName"
										placeholder="banName" name="banName">
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Ban</button>
							</div>
						</form>
						<!-- form start -->
						<form role="form" method="POST"
							action="/test/channel/{channelId}/unban/{banName}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="banName">Unban User by username</label> <input
										type="text" class="form-control" id="banName"
										placeholder="banName" name="banName">
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Unban</button>
							</div>
						</form>
						
						<form role="form" method="POST"
							action="/test/channel/{channelId}/deleteuser/{deleteName}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="deleteName">Delete User by username</label> <input
										type="text" class="form-control" id="deleteName"
										placeholder="deleteName" name="deleteName">
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Delete</button>
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

	<script>
		for (var i = 1; i <= 1000; i++) {
			string = "#" + i;
			string2 = "#" + i + "liked";

			$(string).on('click', function() {
				$(this).toggleClass('ButtonClicked');
			});
			$(string2).on('click', function() {
				$(this).toggleClass('ButtonUnClicked');
			});

		}
	</script>

</body>
</html>