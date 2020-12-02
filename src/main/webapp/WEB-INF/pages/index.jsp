<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online Library</title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nivo-slider.css" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ddsmoothmenu.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ddsmoothmenu.js">

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

</head>

<body>

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="#">Online Library</a></h1></div>
        <div id="header_right">

        	<p>
                   .
            </p>

            <p>
                       .             <a href="#">My Account</a>  | <a href="#">Log In</a>
			</p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="/" class="selected">Home</a></li>
            </ul>
            <br style="clear: left" />
        </div>

        <!-- end of ddsmoothmenu -->

    <!-- !!!!! -->
        <div id="templatemo_search">
            <form action="/search" method="get">
              <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div>

    <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Жанры</h3>
                <div class="content">
                    <ul class="sidebar_list">
                    <c:forEach var="tempGenre" items="${genres}">
                        <c:url var="findByGenre" value="/genre/books">
                            <c:param name="genreId" value="${tempGenre.id}"/>
                        </c:url>
                        <li class="first"><a href="${findByGenre}">${tempGenre.name}</a></li>
                    </c:forEach>
                        <li class="last"><a href="#">Все жанры</a></li>
                    </ul>
                </div>
            </div>

            <!-- !!!! -->
            <div class="sidebar_box"><span class="bottom"></span>
            	<h3>Авторы </h3>
                <div class="content">
                    <ul class="sidebar_list">
                        <c:forEach var="tempAuthor" items="${authors}">
                            <c:url var="findByAuthor" value="/author/books">
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
        	<div id="slider-wrapper">
                <div id="slider" class="nivoSlider">
                    <img src="images/slider/02.jpg" alt="" />
                    <a href="#"><img src="images/slider/01.jpg" alt="" title="This is an example of a caption" /></a>
                    <img src="images/slider/03.jpg" alt="" />
                    <img src="images/slider/04.jpg" alt="" title="#htmlcaption" />
                </div>
                <div id="htmlcaption" class="nivo-html-caption">
                    <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.
                </div>
            </div>
            <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
            <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
            </script>

        	<h1>Коллекция книг</h1>
            <c:forEach var="tempBook" items="${authors}" varStatus="counter">
                <c:choose>
                    <c:when test="${counter.count % 3 > 0}">
                        <div class="product_box">
                            <h3>Ut eu feugiat</h3>
                            <a href="productdetail.jsp"><img src="images/product/01.jpg" alt="Shoes 1" /></a>
                            <p>Nulla rutrum neque vitae erat condimentum eget malesuada.</p>
                            <p class="product_price">$ 100</p>
                            <a href="shoppingcart.html" class="addtocart"></a>
                            <a href="productdetail.jsp" class="detail"></a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="product_box no_margin_right">
                            <h3>Mauris consectetur</h3>
                            <a href="productdetail.jsp"><img src="images/product/03.jpg" alt="Shoes 3" /></a>
                            <p>Morbi non risus vitae est vestibulum tincidunt ac eget metus.</p>
                            <p class="product_price">$ 60</p>
                            <a href="shoppingcart.html" class="addtocart"></a>
                            <a href="productdetail.jsp" class="detail"></a>
                        </div>
                        <div class="cleaner"></div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
            <!--
            <div class="product_box">
	            <h3>Ut eu feugiat</h3>
            	<a href="productdetail.jsp"><img src="images/product/01.jpg" alt="Shoes 1" /></a>
                <p>Nulla rutrum neque vitae erat condimentum eget malesuada.</p>
                <p class="product_price">$ 100</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
            <div class="product_box">
            	<h3>Curabitur et turpis</h3>
            	<a href="productdetail.jsp"><img src="images/product/02.jpg" alt="Shoes 2" /></a>
                <p>Sed congue, erat id congue vehicula. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow">XHTML</a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow">CSS</a>.</p>
              <p class="product_price">$ 80</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
            <div class="product_box no_margin_right">
            	<h3>Mauris consectetur</h3>
            	<a href="productdetail.jsp"><img src="images/product/03.jpg" alt="Shoes 3" /></a>
                <p>Morbi non risus vitae est vestibulum tincidunt ac eget metus.</p>
              <p class="product_price">$ 60</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>   
            
            <div class="cleaner"></div>
                 	
            <div class="product_box">
            	<h3>Proin volutpat</h3>
           	<a href="productdetail.jsp"><img src="images/product/04.jpg" alt="Shoes 4" /></a>
            <p>Sed semper euismod dolor sit amet interdum. Phasellus in mi eros.</p>
      <p class="product_price">$ 220</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
            <div class="product_box">
	            <h3>Aenean tempus</h3>
            	<a href="productdetail.jsp"><img src="images/product/05.jpg" alt="Shoes 5" /></a>
                <p>Maecenas porttitor erat quis leo pellentesque molestie.</p>
              <p class="product_price">$ 180</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
            <div class="product_box no_margin_right">
            	<h3>Nulla luctus urna</h3>
            	<a href="productdetail.jsp"><img src="images/product/06.jpg" alt="Shoes 6" /></a>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                <p class="product_price">$ 160</p>
                <a href="shoppingcart.html" class="addtocart"></a>
                <a href="productdetail.jsp" class="detail"></a>
            </div>        	
        </div>
        -->
        <div class="cleaner"></div>

    </div>
            <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p>
		</p>

    	Copyright © 2072 <a href="#">Your Company Name</a> <!-- Credit: www.templatemo.com --></div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>