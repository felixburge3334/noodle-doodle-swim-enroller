<%-- 
    Document   : Student
    Author     : Fuxin Bi
--%>
<%@page import="java.util.ArrayList"%>
<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList studentList = new ArrayList();
        Object data = request.getAttribute("StudentInfo");
        if(data!=null)
        {
            studentList = (ArrayList)data;
        }
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>View Student Information Page</title>
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
                     <jsp:include page="StudentViewNavbar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                </h1> View Student info </h1>
                     <div class="jumbotron">
                     <table class = "table">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Title</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <%for(int i = 0; i < studentList.size(); i++){ %>
                <tr>
                    <% Student st = (Student)studentList.get(i); %>
                    <td><%= st.getId()%></td>
                    <td><%= st.getFullName().toString()%></td>
                    <td><%= st.getDOB().toString()%></td>
                    <td><%= st.getEmail().toString()%></td>
                    <td><%= st.getAddress()%></td>
                    <td><%= st.getPhone()%></td>
                    <td><%= st.getTitle()%></td>
                    <td><%= st.getPassword()%></td>
                    
                    </td>
                    <td style="height: 100px">
                        <a role="button" href="${pageContext.request.contextPath}/StudentEdit?Id=<%= st.getId()%>" >Edit</a>
                        <a role="button" href="${pageContext.request.contextPath}/deleteStudent?Id=<%= st.getId()%>">Delete</a>
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
