<%-- 
    Document   : Student
    Author     : Fuxin Bi
--%>

<%@page import="uts.asd.model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    Object studentTest = request.getAttribute("StudentInfo");
    Student current= null;
                        if(studentTest !=null){
                            current = (Student)studentTest;
                        }else{
                              current = new Student();
                          }
%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Update Supplier Page</title>
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
                    <h1>Update</h1> 
                    <div class="jumbotron">
                        <form method="POST" action="StudentEdit">
                            <input type="hidden" id="SID" name="Id" value="<%= current.getId()%>">
                        <table>
                            
                            <tr><td>Student Name: </td><td><input type="text" value= "<%= current.getFullName().toString() %>" placeholder="Enter Company Name" name="Name"></td></tr>
                            <tr><td>Date of Birth: </td><td><input type="date" value= "<%= current.getDOB().toString() %>" placeholder="Enter DOB" name="Date"></td></tr>
                            <tr><td>Email: </td><td><input type="text" value= "<%= current.getEmail().toString() %>" placeholder="Enter Email" name="Email"></td></tr>
                            <tr><td>Address: </td><td><input type="text" value= "<%= current.getAddress().toString() %>" placeholder="Enter Address" name="Address"></td></tr>
                            <tr><td>Phone: </td><td><input type="text" value= "<%=current.getPhone()%>" placeholder="Enter Phone" name="Phone"></td></tr>
                            <tr><td>Title: </td><td><input type="text" value= "<%=current.getTitle().toString()%>" placeholder="Enter Title" name="Title"></td></tr>
                            <tr><td>Password: </td><td><input type="text" value= "<%=current.getPassword().toString()%>" placeholder="Enter Password" name="Password"></td></tr>          
                        </table>
                               <input class="button" type="submit" value="Update" role="button" > 
                        </form>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
