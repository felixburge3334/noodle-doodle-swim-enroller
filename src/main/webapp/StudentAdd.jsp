<%-- 
    Document   : Student
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
        <title>Add Student Information Page</title>
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
                     <jsp:include page="StudentAddNavbar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                </h1> Add Student info </h1>
                     <div class="jumbotron">
                         <form method="POST" action="AddNewStudent">
                             <input type="hidden" id="stats" name="Status" value="1">
                     <table class = "table">
                         <tr><td>Name:</td><td><input type="text" class="form-control" placeholder="Enter Name" name="FullName"></td></tr>
                         <tr><td>Date of Birth:</td><td><input type="date" class="form-control" placeholder="Enter DOB" name="Date"></td></tr>
                         <tr><td>Email:</td><td><input type="email" class="form-control" placeholder="Enter Email" name="Email"></td></tr>
                         <tr><td>Address:</td><td><input type="text" class="form-control" placeholder="Enter Address" name="Address"></td></tr>
                         <tr><td>Phone:</td><td><input type="text" class="form-control" placeholder="Enter Phone" name="Phone"></td></tr>
                         <tr><td><label for="Title">Title</label></td>
                            <td><select id="Title" class="form-control"  name="Title">
                                <option value="Mr">Mr</option>
                                <option value="Mrs">Mrs</option>
                                <option value="Ms">Ms</option>
                                <option value="Miss">Miss</option>
                            </select></td></tr>
                         <tr><td>Password:</td><td><input type="text" class="form-control" placeholder="Enter Password" name="Password"></td></tr>
                         <tr><td></td><td><input type="submit" class="btn btn-primary" style = "width:80px;height:45px;" value="Register"> </td></tr>
                     </table>
                     </div>
                </div>
            </div>
        </div>
    </body>
</html>
