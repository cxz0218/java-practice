<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reader Search Book</title>
</head>
<body>
	<c:if test="${empty sessionScope.ReaderEntity}">
		<jsp:forward page="index.jsp" />
	</c:if>
	<jsp:include page="readerLeftSlider.jsp" />

	<div class="panel-body">
		ISBN:
		<input type="text" class="form-control" name="bookDetailName" readonly="readonly" value="${BookDetail.ISBN }" />
		<br>
		Book Name:
		<input type="text" class="form-control" name="bookDetailName" readonly="readonly" value="${BookDetail.name}" />
		<br>
		Publisher:
		<input type="text" class="form-control" name="bookDetailName" readonly="readonly" value="${BookDetail.publisher.name }" />
		<br>
		Authors:
		<input type="text" class="form-control" name="bookDetailName" readonly="readonly" value="${BookDetail.authors }" />
		<br>
		Price:
		<input type="text" class="form-control" name="bookDetailName" readonly="readonly" value="${BookDetail.price }" />
		<br>
		Description:
		<textarea class="form-control" name="bookDetailName" readonly="readonly">${BookDetail.description }</textarea>
		<br>
	</div>
	展示图书
</body>
</html>