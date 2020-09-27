<%-- 
    Document   : store
    Author     : 
--%>

<%@page import="java.util.ArrayList"%>
<%@ page import="uts.asd.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Products</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.min.css">
         <script src="lib/jquery/jquery-3.5.0.min.js"></script>
        <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
    </head>
    
    <% 
        
        
        
        
        ArrayList productlist = new ArrayList();
        
        for(int i =  0;i<30;i++){
            ProductBean pb = new ProductBean();
            pb.setName("test "+(int)(Math.random()*200)+"GB");
            pb.setCategory(Math.random()>0.5?"computers":"accessories");
            pb.setPrice(2.50+ (int)(Math.random()*200)*0.5);
            pb.setID(i);
            productlist.add(pb);
        }
        
     %>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
             <div class="row" >
                 <div class="col-sm-12 col-md-3">
                     <jsp:include page="navbar.jsp" />
                 </div>
                 <div class="col-sm-12 col-md-9 p-4">
                    <div id="myBtnContainer row">
                       <button class="btn active" onclick="filterSelection('all')"> Show all</button>
                       <button class="btn" onclick="filterSelection('computers')"> Computers</button>
                       <button class="btn" onclick="filterSelection('accessories')"> Accessories</button>
                       <button class="btn" onclick="filterSelection('cables')"> Cables</button>
                       <button class="btn" onclick="filterSelection('cases')"> Cases</button>
                       <button class="btn" onclick="filterSelection('books')"> Books</button>
                       
                   </div>
                    
                     <div class="row justify-content-start">
                         
                         <%for(int j = 0;j<(productlist.size());j++){
                             ProductBean pb = (ProductBean)productlist.get(j);
                         %>
                         <jsp:include page="ProductDiv.jsp" flush="true">
                            <jsp:param name="product" value="<%=pb.getName() %>"/>
                            <jsp:param name="productcat" value="<%=pb.getCategory() %>"/>
                            <jsp:param name="productprice" value="<%=pb.getPrice() %>"/>
                            <jsp:param name="productid" value="<%=pb.getID() %>"/>
                            <jsp:param name="canEdit" value="<%=true%>"/>
                        </jsp:include>
                        <%}%>
                     </div>
                    
                 </div>
                <script type="text/javascript">
                    filterSelection("all")
                    function filterSelection(c) {
                      var x, i;
                      x = document.getElementsByClassName("filterDiv");
                      if (c == "all") c = "";
                      // Add the "show" class (display:block) to the filtered elements, and remove the "show" class from the elements that are not selected
                      for (i = 0; i < x.length; i++) {
                        w3RemoveClass(x[i], "show");
                        if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
                      }
                    }

                    // Show filtered elements
                    function w3AddClass(element, name) {
                      var i, arr1, arr2;
                      arr1 = element.className.split(" ");
                      arr2 = name.split(" ");
                      for (i = 0; i < arr2.length; i++) {
                        if (arr1.indexOf(arr2[i]) == -1) {
                          element.className += " " + arr2[i];
                        }
                      }
                    }

                    // Hide elements that are not selected
                    function w3RemoveClass(element, name) {
                      var i, arr1, arr2;
                      arr1 = element.className.split(" ");
                      arr2 = name.split(" ");
                      for (i = 0; i < arr2.length; i++) {
                        while (arr1.indexOf(arr2[i]) > -1) {
                          arr1.splice(arr1.indexOf(arr2[i]), 1);
                        }
                      }
                      element.className = arr1.join(" ");
                    }

                    // Add active class to the current control button (highlight it)
                    var btnContainer = document.getElementById("myBtnContainer");
                    var btns = btnContainer.getElementsByClassName("btn");
                    for (var i = 0; i < btns.length; i++) {
                      btns[i].addEventListener("click", function() {
                        var current = document.getElementsByClassName("active");
                        current[0].className = current[0].className.replace(" active", "");
                        this.className += " active";
                      });
                    }

                </script>
            </div>
        </div>
                         
            
      </body>
</html>
