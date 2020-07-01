<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/common.css">
<link rel="stylesheet" href="assets/css/base.css">
<link rel="stylesheet" href="assets/css/page.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<c:if test="${empty sessionScope.ReaderEntity}">
	<jsp:forward page="index.jsp" />
</c:if>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="readerLeftSlider.jsp" />
	<div class="main-container">
		<div class="title">
			<h3 class="desc">Information</h3>
		</div>
		<div class="tableDiv">
			<table class="table">
				<thead>
					<tr class="firstTR">
						<th>Reader_id</th>
						<th>Reader_name</th>
						<th>State</th>
						<th>Email</th>
						<th>MaxBorrow</th>
					</tr>
					<tr>
						<td>100</td>
						<td>EdSheeran</td>
						<td>unlock</td>
						<td>EdSheeran@google.com</td>
						<td>10</td>
					</tr>
				</thead>

			</table>
		</div>
	</div>
	<div  class="clearfix"></div>
	<jsp:include page="footer.jsp" />
</body>
</html>