<%-- 
    Document   : Supplier
    Author     : mood35-Laptop
--%>

<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Add to Supplier Page</title>
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
                     <jsp:include page="SupplierNavBar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                    <div class="jumbotron">
                        <h2 class="float-right pb-8">Add new Teacher/Stuff</h2> 
                       
                        
                    </div>
                    <div class="jumbotron">
                        <form  method="POST" Action="AddNewSupplier">
                         <input type="hidden" id="stats" name="CStatus" value=1>
                            <table> 
                                <tr><td>Teacher/Stuff Name: </td><td><input type="text" placeholder="Enter Teacher/Stuff Name" name="CName"></td></tr>
                                <tr><td>Address: </td><td><input type="text" placeholder="Enter Address" name="CAddress"></td></tr>
                                <tr><td>Position: </td><td><input type="text" placeholder="Enter Position Type" name="CType"></td></tr>
                                <tr><td>Email: </td><td><input type="email" placeholder="Enter Email" name="CEmail"></td></tr>
                                <tr><td>
                                    </td>
                                    <td>
                                    
                                    </td>
                                </tr>
                                <tr><td></td><td></td></tr>
                            </table>
                            <input type="reset"> 
                            <input type="submit" value="Register"> 
                            <hidden value="SAdd"></hidden> 
                        </form>
                    </div>
                  
                </div>
            </div>
        </div>
      </body>
</html>
