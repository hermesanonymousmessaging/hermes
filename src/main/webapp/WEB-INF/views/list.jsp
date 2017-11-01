<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>CHANGE THE TITLE</title>
	<!-- IMPORT STYLES HERE -->
	<%@ include file="/WEB-INF/partials/style.jspf" %>
</head>
<body>

<p class="text-center">I can write java in here.. Size of the list: ${ list.size() }</p>

<c:forEach items="${list}" var="myVariable" varStatus="status">
	<div class="container text-center">
	  <h3>A LIST ITEM #${status.count}</h3>
	  <p><em>Wow! this is crazy</em></p>
	  <br>
	  <div class="row">
	  	<c:forEach items="${myVariable}" var="child">
		    <div class="col-sm-4">
		      <p><strong>${child}</strong></p><br>
		    </div>
	    </c:forEach>
	  </div>
	</div>
</c:forEach>

</body>
</html>
