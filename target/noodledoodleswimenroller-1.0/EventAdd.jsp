<%-- 
    Document   : Event
    Author     : Fuxin Bi
--%>
<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Event Create Page</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.min.css">
       <script src="lib/jquery/jquery-3.5.0.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
             <div class="row" >
                 <div class="col-sm-12 col-md-3">
                     <jsp:include page="EventAddNavbar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                </h1> Fill Event Details </h1>
                     <div class="jumbotron">
                         <form method="POST" action="AddNewEvent">
                             <input type="hidden" id="stats" name="Status" value="1">
                     <table class = "table">
                         <tr><td>Event Name:</td><td><input type="text" class="form-control" placeholder="Enter Name" name="Name"></td></tr>
                         <tr><td>Event Date:</td><td><input type="date" class="form-control" name="Date"></td></tr>
                         <tr><td>Event Description:</td><td><input type="text" class="form-control" placeholder="Enter Description" name="Description"></td></tr>
                         <tr><td><label for="Visibility">Visibility</label></td>
                            <td><select id="Visibility" class="form-control"  name="Visibility">
                                <option value="TRUE">Public</option>
                                <option value="FALSE">Hidden</option>
                            </select></td></tr>
                         <tr><td></td><td><input type="submit" class="btn btn-primary" style = "width:80px;height:45px;" value="Create"> </td></tr>
                     </table>
                     </div>
                </div>
            </div>
        </div>
    </body>
</html>
