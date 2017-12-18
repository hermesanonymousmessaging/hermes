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
.select2-selection__choice{
    background-color: #3c8dbc !important;
}
</style>


<title>Channel</title>
<%@ include file="/WEB-INF/partials/headerStyle.jspf"%>
<!-- Select2 -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />

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
					<c:if test="${channel.getOwnerId() == login.getId()}">
						<!-- form start -->
						<form role="form" method="POST" action="/test/channel/{channelId}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="name"> Add a user by username
									<select class="js-example-basic-single" style="width: 100%" id="name" name="name">
										<c:forEach items="${nonMembers}" var="nonMember">
											<option value="${nonMember.getUsername()}">${nonMember.getUsername()}</option>
										</c:forEach>
									</select>
									</label>
								</div>
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
							<!-- /.box-body -->
						</form>
						<!-- form start -->
						<form role="form" method="POST"
							action="/test/channel/{channelId}/{banName}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="banName"> Ban a user by username
									<select class="js-example-basic-single" style="width: 100%" id="banName" name="banName">
										<c:forEach items="${members}" var="member">
											<option value="${member.getUsername()}">${member.getUsername()}</option>
										</c:forEach>
									</select>
									</label>
								</div>
								<button type="submit" class="btn btn-primary">Ban</button>
							</div>
							<!-- /.box-body -->
						</form>
						<!-- form start -->
						<form role="form" method="POST"
							action="/test/channel/{channelId}/unban/{banName}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="unbanName"> Unban a user by username
									<select class="js-example-basic-single" style="width: 100%" id="unbanName" name="banName">
										<c:forEach items="${bannedUsers}" var="member">
											<option value="${member.getUsername()}">${member.getUsername()}</option>
										</c:forEach>
									</select>
									</label>
								</div>
								<button type="submit" class="btn btn-primary">Unban</button>
							</div>
							<!-- /.box-body -->
						</form>

						<form role="form" method="POST"
							action="/test/channel/{channelId}/deleteuser/{deleteName}"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-body">
								<div class="form-group">
									<label for="deleteName"> Delete User by username
									<select class="js-example-basic-single" style="width: 100%" id="deleteName" name="deleteName">
										<c:forEach items="${members}" var="member">
											<option value="${member.getUsername()}">${member.getUsername()}</option>
										</c:forEach>
									</select>
									</label>
								</div>
								<button type="submit" class="btn btn-primary">Delete</button>
							</div>
							<!-- /.box-body -->
						</form>
						<form role="form" method="POST"
							action="/test/channel/{channelId}/deletechannel"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Delete Channel</button>
							</div>
						</form>
						</c:if>
						<c:if test="${channel.getOwnerId() != login.getId()}">
						<form role="form" method="POST"
							action="/test/channel/{channelId}/leavechannel"
							modelAttribute="user">
							<input type="hidden" name="channelId" value="${channel.getId()}">

							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Leave Channel</button>
							</div>
						</form>
						</c:if>

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
	
		<!-- Select2 -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
		<script>
		$(document).ready(function() {
		    $('.js-example-basic-single').select2({
		    	 minimumInputLength: 1,
		    	 placeholder: 'Username',
		    	 allowClear: true,
		    	 maximumSelectionLength: 1,
		    	 multiple: true
		    });
		    $('.js-example-basic-single').val(null).trigger("change")
		});
		</script>

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