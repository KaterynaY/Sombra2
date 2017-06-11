<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<footer class="navbar navbar-default navbar-fixed-bottom">
            <div class="row footer-main">
                <div class="col-md-offset-3 col-md-6 col-md-offset-3">
                    <div class="row footer-padding">
                        <div class="col-4 col-sm-4 col-md-4">
                            <p>STAY CONNECTED</p>
                            <div class="row icons">
                               <a href=""><img src="/resources/img/footer/facebook.png"></a>
                               <a href=""><img src="/resources/img/footer/twitter2.png"></a>
                               <a href=""><img src="/resources/img/footer/pinterest.png"></a>
                               <a href=""><img src="/resources/img/footer/instagram.png"></a>
                            </div>
                        </div>
                        <div class="col-4 col-sm-4 col-md-4">
                            <p>BE OUR FRIEND</p>
                            
                       		<form:form class="form-horizontal" action="/sendMail" method="POST" modelAttribute="mail">							    		    				
			      				<form:input class="form-control" style="margin-left:47px" id="email" path="mail" type="text" placeholder="Email Address"/>
			      				<button class="btn subscribe" type="submit">Subscribe now</button>				      						      						
							</form:form> 
  
                        </div>
                        <div class="col-4 col-sm-4 col-md-4">
                            <p>NEED ASSISTANCE?</p>
                            <p>123-456-7890 <br> <a href="">grace@gmail.com</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>