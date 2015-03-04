

<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Home :: w3layouts</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <!--//fonts-->
        <script src="js/jquery.min.js"></script>
        <!--script-->
    </head>
    <!--header-->
    <jsp:include page="Header.jsp" />

    <div class="container">

        <div class="shoes-grid">

            <c:forEach items="${categories}" var="cat" begin="0" end="4">

                <div class="products">
                    <h5 class="latest-product">${cat.name}</h5>	
                    <a class="view-all" href="product.html">VIEW ALL<span> </span></a> 		     
                </div>

                <div class="product-left">

                    <c:forEach items="${cat.products}" var="product" begin="0" end="2">
                        <div class="col-md-4 chain-grid" style="margin-right: 15px; margin-left: 6px; margin-bottom: 20px">
                            <a href="/E_Commerce/ProductDetails?productCode=${product.code}"><img class="img-responsive chain" src="${product.imagePath}" style="height: 310px" alt=" " /></a>
                            <span class="star"> </span>
                            <div class="grid-chain-bottom">
                                <h6><a href="single.html">${product.name}</a></h6>
                                <div class="star-price">
                                    <div class="dolor-grid"> 
                                        <span class="actual">$${product.price}</span>

                                    </div>
                                    <a class="now-get get-cart" href="#">ADD TO CART</a> 
                                    <div class="clearfix"> </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </c:forEach>

        </div>
        <div class="sub-cate">
            <div class=" top-nav rsidebar span_1_of_left">
                <h3 class="cate">CATEGORIES</h3>
                <ul class="menu">

                    <c:forEach items="${categories}" var="cat" >
                        
                        <li class="item1"><a href="/E_Commerce/CategoryOfProduct?categoryId=${cat.id}">${cat.name}</a>
                        </li>
                        
                    </c:forEach>

                </ul>
            </div>
        </div>
    </body>
</html>
