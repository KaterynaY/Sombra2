<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-8 col-xs-12">
		<p>Please, <a href="/login"> sign in </a> in order to be able to add items to the shopping cart or <a href="/buy"> buy now</a></p>
		<a class="btn btn-success" href="/login">Sign in</a>
		<a class="btn btn-success" href="/buy/${itemId}">Buy now</a>
	</div>
	
</div>