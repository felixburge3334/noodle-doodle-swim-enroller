<%-- 
    Document   : Student
    Author     : Fuxin Bi
--%>

<%@page import="uts.asd.model.Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    Object eventTest = request.getAttribute("EventInfo");
    Event current= null;
                        if(eventTest !=null){
                            current = (Event)eventTest;
                        }else{
                              current = new Event();
                          }
%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Event Update Page</title>
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
                    <h1>Update</h1> 
                    <div class="jumbotron">
                        <form method="POST" action="EventEdit">
                            <input type="hidden" id="SID" name="Id" value="<%= current.getId()%>">
                        <table>
                            
                            <tr><td>Event Name: </td><td><input type="text" value= "<%= current.getName().toString() %>" placeholder="Enter Company Name" name="Name"></td></tr>
                            <tr><td>Event Date: </td><td><input type="date" value= "<%= current.getDate().toString() %>" placeholder="Enter DOB" name="Date"></td></tr>
                            <tr><td>Event Description: </td><td><input type="text" value= "<%= current.getDescription().toString() %>" placeholder="Enter Description" name="Description"></td></tr> 
                            <tr><td><label for="Visibility">Event Visibility:</label></td>
                            <td><select id="Visibility" class="form-control"  " name="Visibility">
                                <option value="TRUE">Public</option>
                                <option value="FALSE">Hidden</option>
                            </select></td></tr>
                        </table>
                               <input class="button" type="submit" value="Update" role="button" > 
                        </form>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
