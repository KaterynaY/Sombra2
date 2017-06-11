<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="content">
<br>
        <div class="row">
            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                <div class="row">
                     <div id="carousel" class="carousel slide">
                           <!-- Індикатори слайдів-->
                            <ol class="carousel-indicators">
                                <li class="active" data-target="#carousel" data-slide-to="0"></li>
                                <li data-target="#carousel" data-slide-to="1"></li>
                                <li data-target="#carousel" data-slide-to="2"></li>
                            </ol>

                            <!-- Слайди -->
                            <div class="carousel-inner">
                                <div class="item active">
                                   <img src="/resources/img/sale/redline.JPG" alt="">
                                    <img src="/resources/img/sale/KA-Cat-SummerSale-dresses.jpg" alt="">
                                    <img src="/resources/img/sale/redline.JPG" alt="">                                  
                                    <div class="carousel-caption">
                                       <h3>Up to 70% off on all dresses!</h3>
                                        <a href="/"><p>SHOP NOW</p></a>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="/resources/img/sale/sale-sh.jpg" alt="">
                                    <div class="carousel-caption">
                                        <h3>Winter Collection</h3>
                                         <a href="#"><p>LAST PRICES</p></a>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="/resources/img/sale/sale2.JPG" alt="">
                                    <div class="carousel-caption black">
                                        <a href="#"><p>MEN: LAST PRICES</p></a>
                                    </div>
                                </div>
                            </div>

                            <!-- Стрілки переключення слайдів-->
                            <a href="#carousel" class="left carousel-control" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a href="#carousel" class="right carousel-control" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                       </div>
                </div>
            </div>
        </div>
        <!-- /.row -->
 </div>