<%-- 
    Document   : ShopCartDetails
    Created on : Feb 28, 2015, 12:21:01 PM
    Author     : yomna
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/shopcart.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <div width="50px" id="col3_content" class="clearfix"><div id="body-column-main"><div id="box-shoppingCart" class="box-container box-container-none   ">
                    <div class="box box-style-none  box-padding-none"><input type="hidden" name="CartUnitsCounter" id="CartUnitsCounter" value="1">

                        <h1 class="cart-section-title">Shopping cart</h1>

                        <table id="shopping-cart-active-table" width="100%" border="0" cellspacing="0" cellpadding="0" class="shopping-cart">
                            <tbody><tr>
                                    <td scope="col" colspan="2" class="cart-btm-table align-l">Items To Buy Now </td>
                                    <td scope="col" class="cart-btm-table width-70 align-c">Qty</td>
                                    <td scope="col" class="cart-btm-table width-120 align-c">Subtotal</td>
                                </tr>
                                <tr id="alert_2_773300010" class="alert" style="display:none;">
                                    <td colspan="4" class="last">
                                        <div class="padt-10">
                                            <div class="bad align-l marb-10 alertmsg">
                                                <strong>Attention: </strong><span id="alert_count_773300010"></span>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <c:forEach var="productMap" items="${requestScope.productQuantityMap}">
                                    
                                    <c:set var="product" value="${productMap.key}"/>
                                    <c:set var="quantity" value="${productMap.value}"/>
                                <tr class="first last units unit_773300010">
                                    <td class="itemList-browse-cover">
                                        <div class="cart-image-top-container-small">
                                            <!--Link of product details-->
                                            <a href="#" title=${product.name}>
                                                <img src=${product.imagePath} class="img-size-small" alt="Please Wait" title=${product.name}>
                                            </a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="phone-width-120">
                                            <a href="#">${product.name}</a>
                                            <div class="mart-5">
                                                <div>
                                                    <span>Seller:</span> <span class="text-black">DOD-EGY</span>
                                                </div>
                                                <div class="txt11">
                                                    <span>Condition:</span> <span class="text-black">New</span><br>
                                                </div>
                                                <div class="txt11">
                                                    <span>Screen Size:</span> <span class="text-black">48 Inch</span>
                                                </div>
                                                <div class="mart-10">
                                                    <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?deleteproduct=${product.code}" class="cart-remove-unit cart-remove-active-unit" data-unit-id="773300010" data-unit-ean="2724291111600">Delete</a>
                                                <!--    |
                                                    <a href="#" class="cart-save-unit-later" data-unit-id="773300010" data-unit-ean="2724291111600">Save for later</a>
                                                --></div>

                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-c txt11">
                                        <img src="#" alt="Please Wait" style="display:none;" id="loading_773300010">
                                        <span id="update_quantity_fields_all_773300010">
                                            <input type="text" id="quantity_773300010" data-unit-id="773300010" class="quantity_input width-30 align-c bord-gray-dark pad-4-2" value="${quantity}" size="3" maxlength="3">
                                            <input type="hidden" id="old_quantity_773300010" value="${quantity}">
                                            <input type="hidden" id="id_cart_unit_773300010" value="77168792">
                                            
                                            <!--update quantity of products-->
                                            <div>
                                                <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?deleteproduct=${product.code}" id="quantity_link_773300010" data-unit-id="773300010" class="quantity_input_link txt9">Delete</a>
                                            </div>
                                        </span>
                                    </td>
                                    <td class="padl-53 align-c txt11">
                                        <strong id="amount_773300010">
                                            ${product.price}</strong><strong> <span class="txt9">EGP</span></strong>
                                        <span style="display:none;" id="price_per_item_int_773300010">688800</span>
                                        <div class="text-small" id="showUnitPrice_773300010">
                                        </div>
                                        <input type="hidden" name="price_per_unit_773300010" id="price_per_unit_773300010" value="6,888.00  EGP">
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody></table>
                        <div class="cls cart-btm-table">
                            <div class="fl">
                                
                                <!--Link to home-->
                                <a href="http://localhost:8084/E_Commerce/HomePage" class="txt10">» Continue shopping</a><p>    </p>
                                <a href="http://localhost:8084/E_Commerce/ShoppingCartDetailsServlet?buyproducts=true" class="txt10">Buy Products</a>
                            </div>
                            <div class="fr">
                                <div class="cart-total align-r">
                                    <strong class="text-dark-grey">Grand total:</strong> <strong class="total_price_after_coupon small-price">${sessionScope.total}</strong> <span class="text-red">EGP</span>
                                </div>
                            </div>
                        </div>
                        <div class="cls"></div>
                        <!-- unitList -->

                    </div>
                </div><div id="box-shoppingCartLater" class="box-container box-container-none   ">
                    <div class="box box-style-none  box-padding-none"></div>
                </div></div></div>
                <c:forEach var="productMap" items="productQuantityMap">

        </c:forEach>

        <jsp:include page="footer.jsp" />
    </body>
</html>
