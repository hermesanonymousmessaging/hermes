<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>CHANGE THE TITLE</title>
<!-- IMPORT STYLES HERE -->

<%@ include file="/WEB-INF/partials/headerStyle.jspf"%>

<link rel="stylesheet" href="../resources/css/chat.css" />

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
														<span class="name-meta">Person 5 (Channel 1) </span>
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
														<span class="name-meta">Person 2 (Channel 1) </span>
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
														<span class="name-meta">Person 156 (Channel 2) </span>
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
														<span class="name-meta">Person 5 (Channel 2) </span>
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
														<span class="name-meta">Person 7 (Channel 3) </span>
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
														<span class="name-meta">Person 3 (Channel 3) </span>
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
														<span class="name-meta">Person 6 (Channel 3) </span>
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
									<i class="fa fa-ellipsis-v fa-2x  pull-right"
										aria-hidden="true"></i>
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
										<c:if test="${message.getSenderId() == login.getId()}">
											<div class="col-sm-12 message-main-sender">
												<div class="sender">
										</c:if>
										<c:if test="${message.getSenderId() != login.getId()}">
											<div class="col-sm-12 message-main-receiver">
												<div class="receiver">
										</c:if>
										<div class="message-text">${message.getText()}</div>
										<span class="message-time pull-right">
											${message.getTimestamp()} </span>
									</div>
							</div>
						</div>
						</c:forEach>


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

								<textarea name="usermsg" autocomplete="off" id="usermsg"
									class="form-control" rows="1"></textarea>

							</div>
							<div class="col-sm-1 col-xs-1 reply-recording"></div>
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
	<%@ include file="/WEB-INF/partials/footer.jspf"%>


	</div>
	<!-- ./wrapper -->


	<!-- Script library -->
	<%@ include file="/WEB-INF/partials/scriptLib.jspf"%>


	<script>
		$("#usermsg").keypress(function(e) {
			if (e.which == 13 && !e.shiftKey) {
				$(this).closest("form").submit();
				e.preventDefault();
				return false;
			}
		});
	</script>
</body>
</html>
