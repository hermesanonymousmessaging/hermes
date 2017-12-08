<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
	<head>
		<title>HERMES | Calendar</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<link rel="stylesheet" href="../resources/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css">
		 <link rel="stylesheet" href="../resources/adminlte/bower_components/font-awesome/css/font-awesome.min.css">
		 <link rel="stylesheet" href="../resources/adminlte/bower_components/Ionicons/css/ionicons.min.css">
		 <link rel="stylesheet" href="../resources/adminlte/dist/css/AdminLTE.min.css">
		 <link rel="stylesheet" href="../resources/adminlte/dist/css/skins/_all-skins.min.css">
		 <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		<link href='../resources/adminlte/bower_components/fullcalendar/dist/fullcalendar.min.css' rel='stylesheet' />
		<link href='../resources/adminlte/bower_components/fullcalendar/dist/fullcalendar.print.min.css' rel='stylesheet' media='print' />
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
<style>

	body {
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	}
		
	#wrap {
		width: 1100px;
		margin: 0 auto;
	}
		
	#external-events {
		float: left;
		width: auto;
		padding: 0 10px;
		border: 1px solid #ccc;
		background: #eee;
		text-align: left;
	}
		
	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
	}
		
	#external-events .fc-event {
		margin: 10px 0;
		cursor: pointer;
	}
		
	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
	}
		
	#external-events p input {
		margin: 0;
		vertical-align: middle;
	}

	#calendar {
		float: right;
		width: auto;
	}

</style>
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
        Calendar
      </h1>

    <!-- Main content -->
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
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
		<%@ include file="/WEB-INF/partials/footer.jspf"%>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../resources/adminlte/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../resources/adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../resources/adminlte/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Slimscroll -->
<script src="../resources/adminlte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../resources/adminlte/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/adminlte/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/adminlte/dist/js/demo.js"></script>
<!-- fullCalendar -->
<script src="../resources/adminlte/bower_components/moment/moment.js"></script>
<script src="../resources/adminlte/bower_components/fullcalendar/dist/fullcalendar.min.js"></script>
<!-- Page specific script -->
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
		var numberofevents = ${sessionList.size()};
		console.log(${sessionList.size()});
		
		
		var bekoList = eval(${bekoSessions});
		  $.each(bekoList, function (indexa, all) {
		     console.log(all);
		     event = new Object();
		     console.log(all.startDateD);
			    date = new Date(all.startDateD);
			    console.log(date);
			    event.start = date; // this should be date object // this should be date object
			    date = new Date(all.endDateD);
			    event.end = date;
			    event.color = "blue";
			    event.allDay = false;
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