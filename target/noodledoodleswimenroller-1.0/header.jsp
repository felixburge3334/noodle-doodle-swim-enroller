<%-- 
    Document   : header
    Author     : 
--%>

<%@page import="uts.asd.model.Student"%>
<%@page import="uts.asd.model.CustomerBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row h-10  no-gutters" style="">
    <div class="h-100 h-100 col-sm-6 col-md-3 " style="height: 150px; background-image: url('logo.png'); background-repeat: no-repeat; background-size: cover; background-size:100% 100%;"> 
        <a href="index.jsp"><img src="logotitle.png" style="height: 150px; "  border="0"></a>
    </div>
    <div class="w-100 h-100 col-sm-6 col-md-6 d-none d-sm-block"> 
        <div  style="height: 150px; width:100%; background-image: url('stretchbanner.png'); background-repeat: no-repeat; background-size: cover; background-size:100% 100%;"></div>
    </div>
    <%
        CustomerBean cust = new CustomerBean();
        Student student= new Student();
        Object accountsesh = session.getAttribute("login");
        String profilelink= "#";
        String name="Guest";
        if(accountsesh!=null){
            
            if(accountsesh instanceof CustomerBean){
                cust = (CustomerBean)accountsesh;
                name= cust.getName();
            }else{
                student = (Student)accountsesh;
                name=student.getFullName();
            }
            profilelink="profile.jsp";
            
        }

        
    %>
    <div class="h-100 col-sm-12 col-md-3 bg-dark text-white p-3">
        <div class="container" style = "width:200px">
        <div class=" row"  style="height: 80px; ">
            <h4>Welcome <a href="<%=profilelink%>"><b id="USERNAME"> <%=name%> </b></a></h4>
            <% if(accountsesh==null){ %>
                <p>Login to save ur details</p>
            <% } %>
        </div>
        <div class="row">
            <% if(accountsesh==null){ %>
            <a href="register.jsp" class="btn btn-primary"  role="button" >Register</a>
            <a href="login.jsp" class="btn btn-secondary ml-2"  role="button" >Login</a>
            <% } else { %>
            <a href="loginauth" class="btn btn-danger ml-2"  role="button" >Logout</a>
            <% } %>
        </div>
        </div>
    </div>
</div>
