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
                            <a class="now-get get-cart-in" href="#">ADD TO CART</a> 
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
                        <li class="item1"><a href="#">Curabitur sapien<img class="arrow-img" src="images/arrow1.png" alt=""/> </a>
                            <ul class="cute">
                                <li class="subitem1"><a href="product.html">Cute Kittens </a></li>
                                <li class="subitem2"><a href="product.html">Strange Stuff </a></li>
                                <li class="subitem3"><a href="product.html">Automatic Fails </a></li>
                            </ul>
                        </li>
                        <li class="item2"><a href="#">Dignissim purus <img class="arrow-img " src="images/arrow1.png" alt=""/></a>
                            <ul class="cute">
                                <li class="subitem1"><a href="product.html">Cute Kittens </a></li>
                                <li class="subitem2"><a href="product.html">Strange Stuff </a></li>
                                <li class="subitem3"><a href="product.html">Automatic Fails </a></li>
                            </ul>
                        </li>
                        <li class="item3"><a href="#">Ultrices id du<img class="arrow-img img-arrow" src="images/arrow1.png" alt=""/> </a>
                            <ul class="cute">
                                <li class="subitem1"><a href="product.html">Cute Kittens </a></li>
                                <li class="subitem2"><a href="product.html">Strange Stuff </a></li>
                                <li class="subitem3"><a href="product.html">Automatic Fails</a></li>
                            </ul>
                        </li>
                        <li class="item4"><a href="#">Cras iacaus rhone <img class="arrow-img img-left-arrow" src="images/arrow1.png" alt=""/></a>
                            <ul class="cute">
                                <li class="subitem1"><a href="product.html">Cute Kittens </a></li>
                                <li class="subitem2"><a href="product.html">Strange Stuff </a></li>
                                <li class="subitem3"><a href="product.html">Automatic Fails </a></li>
                            </ul>
                        </li>
                        <li>
                            <ul class="kid-menu">
                                <li><a href="product.html">Tempus pretium</a></li>
                                <li ><a href="product.html">Dignissim neque</a></li>
                                <li ><a href="product.html">Ornared id aliquet</a></li>
                            </ul>
                        </li>
                        <ul class="kid-menu ">
                            <li><a href="product.html">Commodo sit</a></li>
                            <li ><a href="product.html">Urna ac tortor sc</a></li>
                            <li><a href="product.html">Ornared id aliquet</a></li>
                            <li><a href="product.html">Urna ac tortor sc</a></li>
                            <li ><a href="product.html">Eget nisi laoreet</a></li>
                            <li><a href="product.html">Faciisis ornare</a></li>
                            <li class="menu-kid-left"><a href="contact.html">Contact us</a></li>
                        </ul>

                    </ul>
                </div>
                <!--initiate accordion-->
                <script type="text/javascript">
                    $(function () {
                        var menu_ul = $('.menu > li > ul'),
                                menu_a = $('.menu > li > a');
                        menu_ul.hide();
                        menu_a.click(function (e) {
                            e.preventDefault();
                            if (!$(this).hasClass('active')) {
                                menu_a.removeClass('active');
                                menu_ul.filter(':visible').slideUp('normal');
                                $(this).addClass('active').next().stop(true, true).slideDown('normal');
                            } else {
                                $(this).removeClass('active');
                                $(this).next().stop(true, true).slideUp('normal');
                            }
                        });

                    });
                </script>

                <a class="view-all all-product" href="product.html">VIEW ALL PRODUCTS<span> </span></a> 	
            </div>
            <div class="clearfix"> </div>			
        </div>
        <!---->
        <jsp:include page="footer.jsp" />
    </body>
</html>