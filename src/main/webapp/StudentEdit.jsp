<%-- 
    Document   : Student
    Author     : Fuxin Bi
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        
        Object data = request.getAttribute("Student");
        Student current = null;
        if(data!=null)
        {
            current = (Student)data;
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Edit Student Information Page</title>
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
                     <jsp:include page="StudentNavbar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                </h1> Edit Student info </h1>
                     <form method="post" action="">
                        <table class = "table"> 
                               
                       <tr><td> <input type="text" id="myInput" onkeyup="" placeholder="Search for names.." title="Type in a name">
                               . </td><td><input type="submit" name="submit" value="Search"> </td></tr>
                        <tr></tr>
                            <%
                       
                            if(request.getAttribute("result1")!=null)
                            { 
                                ArrayList result = (ArrayList)request.getAttribute("result1");
                                Iterator itr = result.iterator();
                                
                                while(itr.hasNext())
                                {
                                    
                                    ArrayList result1 = (ArrayList)itr.next();
                            %>
                            
                            <tr><td>Name:</td><td><input type="text" value=<%= result1.get(2) %> name="Full_Name"></td></tr>
                            <tr><td>Date of Birth:</td><td><input type="date" value=<%= result1.get(3) %> name="DOB"></td></tr>
                            <tr><td>Email:</td><td><input type="email" value=<%= result1.get(4) %> name="Email"></td></tr>
                            <tr><td>Address:</td><td><input type="text" value=<%= result1.get(5) %> name="Address"></td></tr>
                            <tr><td>Phone:</td><td><input type="text" value=<%= result1.get(6) %> name="Phone"></td></tr>
                            <tr><td>Title:</td><td><input type="text" value=<%= result1.get(7) %> name="Title"></td></tr>
                            <tr><td>Password:</td><td><input type="text" value=<%= result1.get(8) %> name="Password"></td></tr>
                            <%}}%>
                            <tr><td></td><td><input type="submit" value="Delete"> <input class="btn  btn-primary btn-lg" type="submit" value="Update"> </td></tr>
                        </table>
                </div>
            </div>
        </div>
    </body>
</html>
