<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<header>
<nav class="navbar navbar-inverse navbar-fixed-top" id="navbottom"> 
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-offset-3 col-md-6 col-md-offset-3">
							<div class="navbar-header">
                                <div class = "grace">
                                    <a href="/">GRACE</a>
                                </div>
								<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse"
								data-target="#one"
								aria-expanded="false">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span> 
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div>
							<div class="collapse navbar-collapse" id="one">
                                <ul class="nav navbar-nav navbar-left">
                                    <li>
                                         <a href="/" id="white">HOME <span class="sr-only">(current)</span> </a>
                                    </li>
                                    <li class="dropdown">  
										<a role="button" class="dropdown-toggle"
										data-toggle="dropdown"
										aria-haspopup="true"
										aria-expanded="false">
										<span aria-hidden="true" id="white">WOMEN</span>
										</a>
										<ul class="dropdown-menu">
											<c:forEach items="${typesOfClothingWomen}" var="type">
												 <li class="menu__item"><a href="/shopWomen/${type.itemType}">${type.getItemType()}</a></li>                       	
											</c:forEach>
										</ul>	
									</li>
                                    <li class="dropdown"> 
										<a role="button" class="dropdown-toggle"
										data-toggle="dropdown"
										aria-haspopup="true"
										aria-expanded="false">
										<span aria-hidden="true" id="white">MEN</span>
										</a>
										<ul class="dropdown-menu">	
                                            <c:forEach items="${typesOfClothingMen}" var="type">
												 <li class="menu__item"><a href="/shopMen/${type.itemType}">${type.getItemType()}</a></li>                       	
											</c:forEach>
										</ul>
									</li>
                                    <li>
                                         <a href="/sale" id="white">SALE</a>
                                    </li>
                                    <li>
                                         <a href="/customerCare" id="white">CUSTOMER CARE</a>
                                    </li>
							     </ul>
                                <!-- /.nav navbar-nav navbar-left -->
                                <ul class="nav navbar-nav navbar-right"> <!-- navbar-right щоб елементи розташовувалися справа-->
                                     <li class="searching">
<%--                                         <form class="form-inline">
                                             <input class="form-control" id="search" type="text" placeholder="What are you looking for?">
                                             <button class="btn" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>..
                                        </form>  --%>                                                                                                                    
                                    </li>                                      
                                    <sec:authorize access="!isAuthenticated()">
										<!-- <a href="/login">Login</a> -->
										<li>
                                         	<a href="/login" id="white">Sign in</a>
                                    	</li>
									</sec:authorize>
                                    <sec:authorize access="isAuthenticated()">											    
												<sec:authorize access="hasRole('ROLE_ADMIN')">
													<li><a href="/admin" id="white">A</a></li>
												</sec:authorize>												
											<li><form:form action="/logout" method="POST">
												.<button type="submit" class="btn btn-default lower"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></button>.
											</form:form></li>
									</sec:authorize>
                                    <li>
                                    	<a href="/cart/${shoppingCart}" id="upper"><button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></button></a>
                                    </li>
								</ul>
                                <!-- /.nav navbar-nav navbar-right -->
							</div>
                            <!-- /.collapse navbar-collapse -->
						</div>
                        <!-- /.col-md-6 -->
					</div>
                    <!-- /.row -->
				</div>
                <!-- /.container-fluid -->
			</nav>
            <!-- /.navbar navbar-default  -->
</header>