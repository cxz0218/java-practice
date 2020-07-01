<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/common.css">
<link rel="stylesheet" href="assets/css/base.css">
<link rel="stylesheet" href="assets/css/page.css">
<title>登录</title>
</head>
<body>
    <div class="wrapper">
        <div class="content content-flex" style="background-image:url(img/library.jpg)">
            <div class="mask">
                <div class="formGap">
                    <form class="form-auth-small" method="post" action="LoginService">
                        <table>
                            <tr>
                                <td width=150px>
                                    <div class="firstTD form-group has-success">
                                        <label class="control-label" name="userID">User ID</label>
                                    </div>
                                </td>
                                <td width=350px>
                                    <div class="form-group has-success">
                                        <input type="text" name="userID" class="form-control" placeholder="User ID"
                                            onkeyup="this.value=this.value.replace(/\D/g,'')"
                                            onafterpaste="this.value=this.value.replace(/\D/g,'')" value="${userId}">
                                    </div>
                                </td>
                                <td>
                                    <div class="form-group">
                                        <select name="account" size="1" id="account" class="selectpicker"
                                            onchange="change(this.value)">
                                            <option value="please">please select </option>
                                            <c:forEach var="item" items="${idList }">
                                                <option value="${item }">${item }</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td width=150px>
                                    <div class="firstTD form-group has-success has-feedback">
                                        <label class="control-label" name="password">Password</label>
                                    </div>
                                </td>
                                <td width=350px>
                                    <div class="form-group has-success has-feedback">
                                        <c:if test="${empty password }">
                                            <input type="password" name="password" id="pw" class="form-control"
                                                placeholder="Password" maxlength="32">
                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <div class="form-group clearfix">
                                        <c:if test="${empty authority }">
                                            <input class="leftgap" type="radio" name="authority" value="reader"
                                                checked /> Reader
                                            <input class="onegap" type="radio" name="authority" value="librarian" />
                                            Librarian
                                            <input class="onegap" type="radio" name="authority" value="administrator" />
                                            Administrator

                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <div class="form-group clearfix" align="left">
                                        <input type="checkbox" name="isRemember" id="isRemember" />Remember Password
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm btn-block">LOGIN</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

            </div>
        </div>
 			<jsp:include page="footer.jsp" />
    </div>
</body>
</html>