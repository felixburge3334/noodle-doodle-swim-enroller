<%-- 
    Document   : Supplier
    Author     : mood35-Laptop
--%>

<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    Object supplyTest = request.getAttribute("SupplierInfo2");
    Supplier current= null;
                        if(supplyTest !=null){
                            current = (Supplier )supplyTest;
                        }else{
                              current = new Supplier();
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
                     <jsp:include page="SupplierNavBar.jsp" />
                 </div>
                <div class="col-sm-12 col-md-9 p-4">
                    <h1>Update</h1> 
                    <div class="jumbotron">
                        <form method="POST" action="SupplierEdit">
                            <input type="hidden" id="SID" name="SupplierID" value="<%= current.getSupplierID()%>">
                        <table>
                            
                            <tr><td>Teacher/Stuff Name: </td><td><input type="text" value= "<%= current.getCompanyName().toString() %>" placeholder="Enter Company Name" name="CName"></td></tr>
                            <tr><td>Address: </td><td><input type="text" value= "<%= current.getCompanyAddress().toString() %>" placeholder="Enter Address" name="CAddress"></td></tr>
                            <tr><td>Position: </td><td><input type="text" value= "<%=current.getCompanyType().toString()%>" placeholder="Enter Company Type" name="CType"></td></tr>
                            <tr><td>Email: </td><td><input type="email" value= "<%=current.getCompanyEmail().toString()%>" placeholder="Enter Email" name="CEmail"></td></tr>
                            <tr><td>Status: </td><td><input type="checkbox" value= "<%=current.getCompanyStatus() == 0 ? "Activate":"Deactivate"  %>" placeholder="" name="CStatus"></td></tr>   
                        </table>
                               <input class="btn  btn-secondary btn-lg" type="reset" role="button" > <input class="btn  btn-primary btn-lg" type="submit" value="Update" role="button" > 
                            
                        </form>
                    </div>
                </div>
            </div>  
        </div>
      </body>
</html>
