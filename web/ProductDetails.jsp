<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Single :: w3layouts</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <link rel="stylesheet" href="css/etalage.css" type="text/css" media="all" />
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <!--//fonts-->
        <script src="js/jquery.min.js"></script>

        <script src="js/jquery.etalage.min.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 300,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>

    </head>
    <body> 
        <!--header-->
        <jsp:include page="Header.jsp" />
        <!---->

        <div class="container"> 

            <div class=" single_top">
                <div class="single_grid">
                    <div class="grid images_3_of_2">
                        <ul id="etalage">
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image" src="${product.imagePath}" class="img-responsive" />
                                    <img class="etalage_source_image" src="${product.imagePath}" class="img-responsive" title="" />
                                </a>
                            </li>
                            <li>
                                <img class="etalage_thumb_image" src="${product.imagePath}" class="img-responsive" />
                                <img class="etalage_source_image" src="${product.imagePath}" class="img-responsive" title="" />
                            </li>

                        </ul>
                        <div class="clearfix"> </div>		
                    </div> 
                    <div class="desc1 span_3_of_2">


                        <h4>${product.name}</h4>
                        <div class="cart-b">
                            <div class="left-n ">$${product.price}</div>
                            <a class="now-get get-cart-in" href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?productid=${product.code}">ADD TO CART</a> 
                            <div class="clearfix"></div>
                        </div>
                    <h6>In stock</h6>
                        <p>${product.description}</p>

                    </div>
                    <div class="clearfix"> </div>
                </div>


            </div>

            <!---->
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
            <div class="clearfix"> </div>			
        </div>
        <!---->
        <jsp:include page="footer.jsp" />
    </body>
</html>