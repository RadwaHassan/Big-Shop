<%-- 
    Document   : test
    Created on : Mar 1, 2015, 10:24:43 PM
    Author     : yomna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        </br></br>
        <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?productid=1" id="1">bottle</a></br>
        <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?productid=2" id="2">bag</a></br>
        <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?buyproducts=true" id="1000">buy</a></br>
        <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?showproducts=true" id="1000">show products</a></br>
        <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?deleteproduct=1">delete bottle from cart</a>
        <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?deleteproduct=2">delete bag from cart</a>
    </body>
</html>
