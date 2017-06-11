<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
    <div class="col-md-8 col-xs-12">
            <div>${item.itemName.name} Hello</div>  
            
            <div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/save" method="POST">
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<input type="text" class="form-control" name="name" id="name">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="surname" class="col-sm-2 control-label">Surname</label>
    					<div class="col-sm-10">
      						<input type="text" class="form-control" name="surname" id="surname">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="address" class="col-sm-2 control-label">Address</label>
    					<div class="col-sm-10">
      						<input type="text" class="form-control" name="address" id="address">
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Confirm</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
            
                     
	</div> 
 </div>