<%-- 
    Document   : Header
    Created on : Feb 28, 2015, 10:47:52 AM
    Author     : shimaa azmy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>shopping website</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        
        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="../css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> 
        
        <!--//fonts-->
        <script src="js/jquery.min.js"></script>
        <!--script-->
    </head>
    <body>
        <!--header-->
        <div class="header">
            <div class="top-header">
                <div class="container">
                    <div class="top-header-left">
                        <ul class="support">
                            <li><a href="#"><label> </label></a></li>
                            <li><a href="#">24x7 live<span class="live"> support</span></a></li>
                        </ul>
                        <ul class="support">
                            <li class="van"><a href="#"><label> </label></a></li>
                            <li><a href="#">Free shipping <span class="live">on order over 500</span></a></li>
                        </ul>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="top-header-right">


                        <!---->
                        <div class="clearfix"> </div>	
                    </div>
                    <div class="clearfix"> </div>		
                </div>
            </div>
            <div class="bottom-header">
                <div class="container">
                    <div class="header-bottom-left">
                        <div class="logo">
                            <a href="/E_Commerce/HomePage"><img src="images/logo.png" alt=" " /></a>
                        </div>

                        <div class="clearfix"> </div>
                    </div>
                    <div class="header-bottom-right">
                        <c:if test="${user.status == '0' || user == null}">
                            <ul class="login" style="margin-left: 300px">
                                <li><a href="login.jsp"><span> </span>LOGIN</a></li> |
                                <li ><a href="register.html">SIGNUP</a></li>
                            </ul>
                        </c:if>
                        
                        <c:if test="${user.status == '1'}">
                            <div class="account"><a href="login.jsp"><span> </span>YOUR ACCOUNT</a></div>
                            <div class="cart"><a href="ShopCartDetails.jsp"><span> </span>CART</a></div>
                            <div class="close"><a href="/E_Commerce/Logout"><span></span>Logout</a></div>
                        </c:if>
                        

                        <div class="clearfix"> </div>
                    </div>
                    <div class="clearfix"> </div>	
                </div>
            </div>
        </div
        
        
        
    </body>
</html>

