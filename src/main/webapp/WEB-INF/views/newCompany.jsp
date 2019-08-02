<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<style>
    <%@include file="/WEB-INF/resources/css/bootstrap.css"%>
    <%@include file="/WEB-INF/resources/css/bootstrap.min.css"%>
    <%@include file="/WEB-INF/resources/css/bootstrap-treeview.min.css"%>
    <%@include file="/WEB-INF/resources/css/bootstrap-theme.min.css"%>
</style>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новый объект</title>
</head>


<body>

<form class="form col-md-4" action="saveTemplate" method="post">

    <div align="left">
        <ol class="breadcrumb">
            <li><a href="/">home</a></li>
        </ol>
    </div>

    <div>
        <div>
            <ul class="nav nav-pills">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        Action list <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/newTask/">Add First Task</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div class="col-md-10">
        <div align="left">
            <div class="row">
                <div class="container-fluid">
                    <h3>List Task</h3>
                    <table class="table table-responsive table-condensed table-hover">
                        <th>Object_Id</th>
                        <th>Name</th>
                        <c:forEach var="entity" items="${listEntity}" varStatus="status">
                            <tr>
                                <td style="color: #100508">${entity.objectId}</td>
                                <td><a style="color: #100508" href="object?objectId=${entity.objectId}">${entity.name}
                                    <a href="delete?objectId=${entity.objectId}"><span class="glyphicon glyphicon-trash"></span></a></a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

        <div align="center">
            <button class="btn btn-warning" type="submit"
                    onclick="history.back()"><span class="glyphicon glyphicon-chevron-left"></span>
                Back
            </button>
        </div>

    </div>


</form>
</body>
</html>



