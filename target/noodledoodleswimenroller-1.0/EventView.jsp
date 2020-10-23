<%-- 
    Document   : Event
    Author     : Fuxin Bi
--%>
<%@page import="java.util.ArrayList"%>
<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList eventList = new ArrayList();
        Object data = request.getAttribute("EventInfo");
        if(data!=null)
        {
            eventList = (ArrayList)data;
        }
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Listing of All Events</title>
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
                     <jsp:include page="EventViewNavbar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                </h1> View Event info </h1>
                     <div class="jumbotron">
                     <table class = "table">
            <thead>
                <tr>
                    <th>Event ID</th>
                    <th>Event Name</th>
                    <th>Event Date</th>
                    <th>Event Description</th>
                    <th>Event Visible</th>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i < eventList.size(); i++){ %>
                <tr>
                    <% Event ev = (Event)eventList.get(i); %>
                    <td><%= ev.getId()%></td>
                    <td><%= ev.getName().toString()%></td>
                    <td><%= ev.getDate().toString()%></td>
                    <td><%= ev.getDescription().toString()%></td>
                    <td><%= ev.isVisibility()%></td>
                    
                    </td>
                    <td style="height: 100px">
                        <a role="button" href="${pageContext.request.contextPath}/EventEdit?Id=<%= ev.getId()%>" >Edit</a>
                        <a role="button" href="${pageContext.request.contextPath}/deleteEvent?Id=<%= ev.getId()%>">Delete</a>
                    </td>
                </tr>    
                <% } %>
            </tbody>
        </table>
                     </div>
                </div>
            </div>
        </div>
    </body>
</html>
