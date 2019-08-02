<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<style>
    <%@include file="/WEB-INF/resources/css/bootstrap.css"%>
    <%@include file="/WEB-INF/resources/css/bootstrap.min.css"%>
    <%@include file="/WEB-INF/resources/css/bootstrap-treeview.min.css"%>
    <%@include file="/WEB-INF/resources/css/bootstrap-theme.min.css"%>
</style>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>Приветствие</title>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Помощник арендатору</a>
        </div>

        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="/newCompany">New Company</a></li>

        </ul>

        <div id="navbar" class="navbar-collapse collapse">
                <form action="/login">
                    <button class="navbar-form navbar-right" type="submit">Личный кабинет</button>
                </form>
            </form>
        </div>


    </div>
</nav>




<!-- поле с картой  -->

        <script src="https://api-maps.yandex.ru/2.1/?apikey=<2b4c3058-6a6d-4ca0-b41b-6f5d1da839f0>&lang=ru_RU"
                type="text/javascript">
        </script>
        <script type="text/javascript">
            <%@include file="/WEB-INF/resources/js/map.js"%>
        </script>
        <style>
            body, html {
                padding: 28px;
                margin: 0;
                width: 100%;
                height: 100%;
            }

            #map {
                width: 100%;
                height: 90%;
            }
        </style>
  <div id="map"></div>



    <div class="container">
        <!-- Example row of columns -->
    </div>
    <div align="center">
        <ul class="pagination">
            <li><a href="/">1</a></li>
            <li><a href="/home">2</a></li>
            <li><a href="/login">3</a></li>
        </ul>
    </div>



</div> <!-- /container -->



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
