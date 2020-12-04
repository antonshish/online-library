<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Product Detail</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<script type="text/javascript" src="js/jquery-1-4-2.min.js"></script> 
<link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="js/slimbox2.js"></script> 


</head>

<body>

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="${pageContext.request.contextPath}">Online Library</a></h1></div>
        <div id="header_right">
        	<p>
.
            <p>
            <a href="#">My Account</a> | <a href="#">Log In</a></p>
			</p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="${pageContext.request.contextPath}">Home</a></li>
            </ul>
            <br style="clear: left" />
        </div>

        <!-- end of ddsmoothmenu -->

        <div id="templatemo_search">
            <form action="/search" method="get">
              <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
        <div id="sidebar" class="float_l">
            <div class="sidebar_box"><span class="bottom"></span>
                <h3>Жанры</h3>
                <div class="content">
                    <ul class="sidebar_list">
                        <c:forEach var="tempGenre" items="${genres}">
                            <c:url var="findByGenre" value="/search">
                                <c:param name="genreId" value="${tempGenre.id}"/>
                            </c:url>
                            <li class="first"><a href="${findByGenre}">${tempGenre.name}</a></li>
                        </c:forEach>
                        <li class="last"><a href="#">Все жанры</a></li>
                    </ul>
                </div>
            </div>
            <div class="sidebar_box"><span class="bottom"></span>
                <h3>Авторы </h3>
                <div class="content">
                    <ul class="sidebar_list">
                        <c:forEach var="tempAuthor" items="${authors}">
                            <c:url var="findByAuthor" value="/search">
                                <c:param name="authorId" value="${tempAuthor.id}"/>
                            </c:url>
                            <li class="first"><a href="${findByAuthor}">${tempAuthor.fullName}</a></li>
                        </c:forEach>
                        <li class="last"><a href="#">Все авторы</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="content" class="float_r">
        	<h1>Product Detail</h1>
            <div class="content_half float_l">
                <c:url var="findImage" value="/image">
                    <c:param name="bookId" value="${book.id}"/>
                </c:url>
        	<a  rel="lightbox[portfolio]" href="${findImage}"><img src="${findImage}" width="176" height="272" alt="image" /></a>
            </div>
            <div class="content_half float_r">
                <table>
                    <tr>
                        <td width="160">Название:</td>
                        <td>${book.title}</td>
                    </tr>
                    <tr>
                        <td>Жанр:</td>
                        <td>${book.genre.name}</td>
                    </tr>
                    <tr>
                        <td>Издатель:</td>
                        <td>${book.publisher.name}</td>
                    </tr>
                   <tr>
                        <td>Количество страниц:</td>
                        <td>${book.pageCount}</td>
                    </tr>
                    <!-- <tr>
                    	<td>Quantity</td>
                        <td><input type="text" value="1" style="width: 20px; text-align: right" /></td>
                    </tr> -->
                </table>
                <div class="cleaner h20"></div>

                <a href="shoppingcart.html" class="addtocart"></a>

			</div>
            <div class="cleaner h30"></div>
            
            <h5>Описание</h5>
            <p>${book.description}</p>
            
          <div class="cleaner h50"></div>
            
           <!-- <h3>Related Products</h3>
        	<div class="product_box">
            	<a href="productdetail.jsp"><img src="images/product/01.jpg" alt="" /></a>
                <h3>Ut eu feugiat</h3>
                <p class="product_price">$ 100</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
            <div class="product_box">
            	<a href="productdetail.jsp"><img src="images/product/02.jpg" alt="" /></a>
                <h3>Curabitur et turpis</h3>
                <p class="product_price">$ 200</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
            <div class="product_box no_margin_right">
            	<a href="productdetail.jsp"><img src="images/product/03.jpg" alt="" /></a>
                <h3>Mauris consectetur</h3>
                <p class="product_price">$ 120</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>     -->
        </div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    <!--	<p><a href="#">Home</a> | <a href="#">Products</a> | <a href="#">About</a> | <a href="#">FAQs</a> | <a href="#">Checkout</a> | <a href="#">Contact Us</a>
		</p> -->

		Copyright © 2072 <a href="#">Your Company Name</a> <!-- Credit: www.templatemo.com -->
    	
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>