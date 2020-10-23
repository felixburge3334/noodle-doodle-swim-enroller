<%-- 
    Document   : Event
    Author     : Fuxin Bi
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        
        Object data = request.getAttribute("Event");
        Event current = null;
        if(data!=null)
        {
            current = (Event)data;
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Event Edit Page</title>
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
                     <jsp:include page="EventNavbar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                </h1> Edit Event Details </h1>
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
                            
                            <tr><td>Event Name:</td><td><input type="text" class="form-control" value=<%= result1.get(2) %> name="Name"></td></tr>
                            <tr><td>Event Date:</td><td><input type="date" class="form-control" value=<%= result1.get(3) %> name="Date"></td></tr>
                            <tr><td>Event Description:</td><td><input type="text" class="form-control" value=<%= result1.get(4) %> name="Description"></td></tr>
                            <tr><td><label for="Visibility">Event Visibility:</label></td>
                            <td><select id="Visibility" class="form-control"  name="Visibility">
                                <option value="TRUE">Public</option>
                                <option value="FALSE">Hidden</option>
                            </select></td></tr>
                            <%}}%>
                            <tr><td></td><td><input type="submit" value="Delete"> <input class="btn  btn-primary btn-lg" style = "width:80px;height:45px;" type="submit" value="Update"> </td></tr>
                        </table>
                </div>
            </div>
        </div>
    </body>
</html>
