<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br>
<div class="row">
<br>
<br>
	<div class="col-md-offset-3 col-md-6 col-md-offset-3">
    <!-- якщо неправильно введений пароль буде вказувати про це -->
    <c:if test="${param.fail}">
	 	<div class="col-md-8 text-center">
	 		<h4><b>Failed to authorize!</b></h4>
	 	</div>
    </c:if>
    <br>
    <div class="row">
	<div class="col-sm-8 col-xs-8">
		<form:form class="form-horizontal" action="/login" method="POST">
			<div class="form-group">
    			<label for="login" class="col-sm-2 control-label">Login</label>
    			<div class="col-sm-10">
      				<input class="form-control" name="login" id="login" placeholder="Enter your email">
    			</div>
  			</div>
			<div class="form-group">
    			<label for="password" class="col-sm-2 control-label">Password</label>
    			<div class="col-sm-10">
      				<input class="form-control" name="password" id="password" type="password">
    			</div>
  			</div>
  			<div class="form-group">
  				<div class="col-sm-offset-2 col-sm-10">
  					<div class="checkbox">
  						<label>
  							<input name="remember-me" type="checkbox"> Remember me
  						</label>
  					</div>
  				</div>
  			</div>
  			<div class="form-group">
    			<div class="col-sm-offset-2 col-sm-10">
      				<button type="submit" class="btn btn-default">Sign in</button>
    			</div>
  			</div>
		</form:form>
	</div>
	<div class="col-sm-4 col-xs-4">
		<a href="/registration"><button type="submit" class="btn btn-info">Registration</button></a>
	</div>
	</div>
	</div>
</div>