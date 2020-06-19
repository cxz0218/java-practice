<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>图书馆 | 欢迎你</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/common.css">
<link rel="stylesheet" href="assets/css/base.css">
<link rel="stylesheet" href="assets/css/page.css">
</head>
<body>
    <div class="wrapper">
        <div class="header">

            <div class="navbar-menu">
                <a class="login" href="login.jsp" title="Login">
                    <button type="button" class=" btn-lg">
                        <span class="glyphicon glyphicon-user"></span> Login
                    </button>
                </a>
            </div>
        </div>
        <div class="content" style="background-image:url(img/library.jpg)">
            <div class="mask">
                <div class="bigText">
                    <p>Books are steps toward human progress</p> 
                    <div class="smallText">
                        Welcome to the library, there are the ocean of knowledge.
                    </div>
                </div>

            </div>
        </div>
    </div>  
    <jsp:include page="footer.jsp" />  
</body>
</html>
