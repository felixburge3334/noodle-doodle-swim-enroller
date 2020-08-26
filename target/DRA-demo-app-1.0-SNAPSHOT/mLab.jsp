<%-- 
    Document   : login
    Author     : george
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="dra.demo.controller.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>MLab</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript"></script>
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Nunito:400,300,700'>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/demo.css">
    </head>
    <%
        String status = request.getParameter("status");       
    %>
    <body style="background:none transparent;">

        <div class="row">
            <form class="mlab-form" action="ConnServlet" method="post" target="_parent">
                <p class="form_title">MongoDB Atlas Login:  </p>&emsp;<span class="error"> <c:if test="${status!=null}"><c:out value="${status}"/></c:if></span>
                    <div class="form-group" id="username">
                        <input class="form-input" name="adminemail" id="noodledoodle" placeholder="MongoDB ID">                                       
                    </div>
                    <div class="form-group" id="password">
                        <input type="password" class="form-input" name ="asd631sU" id="adminpassword" placeholder="Password">
                    </div>
                    <div class="form-group" id="collection">
                        <input type="text" class="form-input" name ="role" id="role" placeholder="Role">
                    </div>
                    <div class="form-group" id="database">
                        <input type="text" class="form-input" name ="database" id="database" placeholder="Database">
                    </div>
                    <div class="form-group" id="collection">
                        <input type="text" class="form-input" name ="collection" id="collection" placeholder="Collection">
                    </div>                    
                    <div class="form-group">
                        <input type="submit" id="mLab_login" value="Connect" class="login-button"/>                    
                    </div>
                </form>         
            </div>        
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js'></script>
        <script src='https://code.jquery.com/jquery-2.1.4.min.js'></script>       
    </body>

</html>
