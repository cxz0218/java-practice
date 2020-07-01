<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/common.css">
<link rel="stylesheet" href="assets/css/base.css">
<link rel="stylesheet" href="assets/css/page.css">
<script src="assets/js/jquery.min.js"></script>
</head>
<body>
	<c:if test="${empty sessionScope.ReaderEntity}">
		<jsp:forward page="index.jsp" />
	</c:if>
	<jsp:include page="readerLeftSlider.jsp" />
	   <div class="main-container">
        <div class="searchDiv">
            <div class="title">
                <div class="desc">Search</div>
            </div>
            <div class="selectDiv">
                <select id="input" name="searchBy">
                    <option>Book Name</option>
                    <option>Author</option>
                    <option>Publisher</option>
                    <option>ISBN</option>
                </select>
            </div>
            <div class="formDiv">
                <form class="navbar-form" role="search" align="center" method="post"
                    action="SearchBookForReader">
                  <!--   <tag:searchBy></tag:searchBy> -->
                    <div class="form-group" align="center">
                        <input type="text" name="name" placeholder="begin to search..." class="form-control"
                            style="width: 400px;" />
                    </div>
                    <button type="submit" name="submit" class="btn btn-success">Search</button>
                </form>
            </div>
            <!-- 检索的信息 -->
            <table class="table">
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Book Name</th>
                        <th>Author</th>
                        <th>Publisher</th>
                        <th>Price</th>

                    </tr>

                    <!-- 展示书籍信息 -->
                    <c:if test="${not empty sessionScope.bookList }">
                    <c:forEach var="book" items="${sessionScope.bookList }">
                        <tr>
                            <th>${book.ISBN }</th>
                            <th>${book.name }</th>
                            <th>${book.authors }</th>
                            <th>${book.publisher.name }</th>
                            <th>${book.price }</th>
                            <th><form align="center" method="post"
                                    action="ShowBookInLib">
                                    <input type="hidden" name="isbn" value='${book.ISBN}'></input>
                                    <button type="submit" name="bookInfo"
                                        class="btn btn-success">More Information</button>
                                </form></th>
                        </tr>
                    </c:forEach>
                    </c:if>
                    <c:if test="${not empty sessionScope.bookEntity }">
                    <tr>
                            <th>${sessionScope.bookEntity.ISBN }</th>
                            <th>${sessionScope.bookEntity.name }</th>
                            <th>${sessionScope.bookEntity.authors }</th>
                            <th>${sessionScope.bookEntity.publisher.name }</th>
                            <th>${sessionScope.bookEntity.price }</th>
                            <th><form align="center" method="post"
                                    action="ShowBookInLib">
                                    <input type="hidden" name="isbn" value='${sessionScope.bookEntity.ISBN}'></input>
                                    <button type="submit" name="bookInfo"
                                        class="btn btn-success">More Information</button>
                                </form></th>
                        </tr>
                    </c:if>
                </thead>
            </table>
        </div>


    </div>
    <div  class="clearfix"></div>
    <jsp:include page="footer.jsp" />
</body>
</html>