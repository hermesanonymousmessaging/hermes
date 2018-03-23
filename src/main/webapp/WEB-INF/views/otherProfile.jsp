<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>User Profile</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<%@ include file="/WEB-INF/partials/headerStyle.jspf"%>
		<link href='../../resources/adminlte/bower_components/fullcalendar/dist/fullcalendar.min.css' rel='stylesheet' />
		<link href='../../resources/adminlte/bower_components/fullcalendar/dist/fullcalendar.print.min.css' rel='stylesheet' media='print' />
		<script>
		
	$(document).ready(function() {


		/* initialize the external events
		-----------------------------------------------------------------*/

		$('#external-events .fc-event').each(function() {

			// store data so the calendar knows to render an event upon drop
			$(this).data('event', {
				title: $.trim($(this).text()), // use the element's text as the event title
				stick: true // maintain when user navigates (see docs on the renderEvent method)
			});

			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});

		});


		/* initialize the calendar
		-----------------------------------------------------------------*/

		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
			droppable: true, // this allows things to be dropped onto the calendar
			drop: function() {
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
			}
		});


	});

</script>
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
									src="${otherProfile.getProfilePicture()}"
									alt="User profile picture">

								<h3 class="profile-username text-center">${otherProfile.getFirstName()}
									${otherProfile.getLastName()}</h3>

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

									<div class="col-md-3">
										<div class="box box-default box-solid collapsed-box" >
											<div class="box-header with-border" style="background-color:#00c0ef">
												<h3 class="box-title" style="font-size:100%;color:white">My Channels</h3>

												<div class="box-tools pull-right">
													<button type="button" class="btn btn-box-tool"
														data-widget="collapse">
														<i class="fa fa-plus"></i>
													</button>
												</div>
												<!-- /.box-tools -->
											</div>
											<!-- /.box-header -->
											<div class="box-body" style="display: none;">
												<c:forEach items="${othermychannels}" var="item">
												<c:if test="${!item.isHidden()}">
													<a href="#" class="btn btn-primary"><c:out value="${item.getName()}" /></a>
												</c:if>
												</c:forEach>					
											</div>
											<!-- /.box-body -->
										</div>
										<!-- /.box -->
									</div>
									<div class="col-md-3">
										<div class="box box-default box-solid collapsed-box">
											<div class="box-header with-border" style="background-color:#3c8dbc">
												<h3 class="box-title" style="font-size:100%;color:white">Joined Channels</h3>

												<div class="box-tools pull-right">
													<button type="button" class="btn btn-box-tool"
														data-widget="collapse">
														<i class="fa fa-plus"></i>
													</button>
												</div>
												<!-- /.box-tools -->
											</div>
											<!-- /.box-header -->
												<div class="box-body" style="display: none;">
												<c:forEach items="${otherjoinedChannels}" var="item">
												<c:if test="${!item.isHidden()}">
													<a href="#" class="btn btn-primary"><c:out value="${item.getName()}" /></a>
												</c:if>
												</c:forEach>					
												</div>
											<!-- /.box-body -->
										</div>
										<!-- /.box -->
									</div>
									<div class="col-md-3">
										<div class="box box-default box-solid collapsed-box">
											<div class="box-header with-border" style="background-color:#3c8dbc">
												<h3 class="box-title" style="font-size:100%;color:white">Favourite Channels</h3>

												<div class="box-tools pull-right">
													<button type="button" class="btn btn-box-tool"
														data-widget="collapse">
														<i class="fa fa-plus"></i>
													</button>
												</div>
												<!-- /.box-tools -->
											</div>
											<!-- /.box-header -->
												<div class="box-body" style="display: none;">
												<c:forEach items="${otherfavouriteChannels}" var="item">
												<c:if test="${!item.isHidden()}">
													<a href="#" class="btn btn-primary"><c:out value="${item.getName()}" /></a>
												</c:if>
												</c:forEach>					
												</div>
											<!-- /.box-body -->
										</div>
										<!-- /.box -->
									</div>
									</div>

								</div>
								<!-- /.tab-pane -->
								<div class="tab-pane" id="schedule">
									<section class="content">
										<div class="row">

											<!-- /.col -->
											<div class="col-md-9">
												<div class="box box-primary">
													<div class="box-body no-padding">
														<!-- THE CALENDAR -->
														<div id="calendar"></div>
													</div>
													<!-- /.box-body -->
												</div>
												<!-- /. box -->
											</div>
											<!-- /.col -->
										</div>
										<!-- /.row -->
									</section>
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
		<%@ include file="/WEB-INF/partials/footer.jspf"%>

	</div>
	<!-- ./wrapper -->

	<!-- Script library -->
<!-- jQuery 3 -->
<script src="../../resources/adminlte/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../resources/adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../../resources/adminlte/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Slimscroll -->
<script src="../../resources/adminlte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../../resources/adminlte/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../../resources/adminlte/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../resources/adminlte/dist/js/demo.js"></script>
<!-- fullCalendar -->
<script src="../../resources/adminlte/bower_components/moment/moment.js"></script>
<script src="../../resources/adminlte/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
	<script>
  $(function () {

    /* initialize the external events
     -----------------------------------------------------------------*/
    function init_events(ele) {
      ele.each(function () {

        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
          title: $.trim($(this).text()) // use the element's text as the event title
        }

        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject)

        // make the event draggable using jQuery UI
        $(this).draggable({
          zIndex        : 1070,
          revert        : true, // will cause the event to go back to its
          revertDuration: 0  //  original position after the drag
        })

      })
    }

    init_events($('#external-events div.external-event'))

    /* initialize the calendar
     -----------------------------------------------------------------*/
    //Date for the calendar events (dummy data)
    var date = new Date()
    var d    = date.getDate(),
        m    = date.getMonth(),
        y    = date.getFullYear()
    $('#calendar').fullCalendar({
    	displayEventTime: false,
      header    : {
        left  : 'prev,next today',
        center: 'title',
        right : 'month,agendaWeek,agendaDay'
      },
      buttonText: {
        today: 'today',
        month: 'month',
        week : 'week',
        day  : 'day'
      },
      //Random default events
      events    : [],
      editable  : true,
      droppable : true, // this allows things to be dropped onto the calendar !!!
      drop      : function (date, allDay) { // this function is called when something is dropped
        // retrieve the dropped element's stored Event Object
        var originalEventObject = $(this).data('eventObject')
        // we need to copy it, so that multiple events don't have a reference to the same object
        var copiedEventObject = $.extend({}, originalEventObject)
        // assign it the date that was reported
        copiedEventObject.start           = date
        copiedEventObject.allDay          = allDay
        copiedEventObject.backgroundColor = $(this).css('background-color')
        copiedEventObject.borderColor     = $(this).css('border-color')
        // render the event on the calendar
        // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
        $('#calendar').fullCalendar('renderEvent', copiedEventObject, true)
        // is the "remove after drop" checkbox checked?
        if ($('#drop-remove').is(':checked')) {
          // if so, remove the element from the "Draggable Events" list
          $(this).remove()
        }
      }
    })
    
		var events=new Array();

		var bekoList = eval(${bekoSessions});
		var channelNames = eval(${bekoChannelNames});
		  $.each(bekoList, function (indexa, all) {
		     event = new Object();
			    date = new Date(all.startDateD);
			    event.start = date; // this should be date object // this should be date object
			    date = new Date(all.endDateD);
			    event.end = date;
			    event.color = "blue";
			    event.allDay = false;
			    var aloalo = all.id;
			    event.title = channelNames[aloalo];
			    event.startEditable = false;
			    event.durationEditable = false;
			    events.push(event);
		 });
			$('#calendar').fullCalendar('addEventSource',events);


    /* ADDING EVENTS */
    var currColor = '#3c8dbc' //Red by default
    //Color chooser button
    var colorChooser = $('#color-chooser-btn')
    $('#color-chooser > li > a').click(function (e) {
      e.preventDefault()
      //Save color
      currColor = $(this).css('color')
      //Add color effect to button
      $('#add-new-event').css({ 'background-color': currColor, 'border-color': currColor })
    })
    $('#add-new-event').click(function (e) {
      e.preventDefault()
      //Get value and make sure it is not null
      var val = $('#new-event-title').val()
      if (val.length == 0) {
        return
      }

      //Create events
      var event = $('<div />')
      event.css({
        'background-color': currColor,
        'border-color'    : currColor,
        'color'           : '#fff'
      }).addClass('external-event')
      event.html(val)
      $('#external-events').prepend(event)

      //Add draggable funtionality
      init_events(event)

      //Remove event from text input
      $('#new-event-title').val('')
    })
  })
</script>
</body>
</html>
