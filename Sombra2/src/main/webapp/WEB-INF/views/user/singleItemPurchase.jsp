<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <div class="row">
     <div class="col-md-offset-3 col-md-6 col-md-offset-3">
     <form:form class="form-horizontal" action="/singleBuy/${itemOfClothing.id}" method="POST" modelAttribute="orders">
      		<br>
            
				<div class="row">
                    <div class="col-md-2 col-xs-2">
                    <a href="/item/${itemOfClothing.id}">
                    	<img src="/images/clothes/${itemOfClothing.id}.jpg?version=${itemOfClothing.version}" width="100%">
                    </a>	
                    </div>
                    <div class="col-md-3 col-xs-3">                         
							<div><b>${itemOfClothing.itemName.name}</b></div>
							<br>
							<div><b>Price:</b> ${itemOfClothing.price} USD</div>
							<div><b>Brand:</b> ${itemOfClothing.brand.brandName}</div>
							<div><b>Size:</b> ${itemOfClothing.size.size}</div>
							<div><b>Color:</b> ${itemOfClothing.color.color}</div>
					</div>
					<div class="col-md-7 col-xs-2">
						<p style="text-align:center"><b> Please, fill in this form to make a purchase </b></p>				
						<div class="form-group">
			 				<label for="email" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="name"/></label>
			 			</div> 
						<div class="form-group">
			    			<label for="email" class="col-sm-2 control-label">Name</label>
			    			<div class="col-sm-10">
			      				<form:input class="form-control" path="name" id="name"/>
			    			</div>
			  			</div>
			  			<div class="form-group">
			 				<label for="email" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="surname"/></label>
			 			</div> 
						<div class="form-group">
			    			<label for="email" class="col-sm-2 control-label">Surname</label>
			    			<div class="col-sm-10">
			      				<form:input class="form-control" path="surname" id="surname"/>
			    			</div>
			  			</div>
			  			<div class="form-group">
			 				<label for="email" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="email"/></label>
			 			</div> 
						<div class="form-group">
			    			<label for="email" class="col-sm-2 control-label">Email</label>
			    			<div class="col-sm-10">
			      				<form:input class="form-control" path="email" id="emailu"/>
			    			</div>
			  			</div>
			  			<div class="form-group">
			 				<label for="email" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="phoneNumber"/></label>
			 			</div> 
						<div class="form-group">
			    			<label for="email" class="col-sm-2 control-label">Phone Number</label>
			    			<div class="col-sm-10">
			      				<form:input class="form-control" path="phoneNumber" id="phoneNumber"/>
			    			</div>
			  			</div>
			  			<div class="form-group">
							<label for="email" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="address"/></label>
						</div>
						<div class="form-group">
			    			<label for="address" class="col-sm-2 control-label">Address</label>
			    			<div class="col-sm-10">
			      				<form:input class="form-control" path="address" id="address" placeholder="Enter the address where your purchase should be delivered"/>
			    			</div>
			  			</div>
			  			<div class="form-group">
			    			<div class="col-sm-offset-2 col-sm-10">
			      				<button type="submit" class="btn btn-danger"><div style="width:100px; font-size:18px;"><b> Buy </b></div></button>
			    			</div>
			  		  </div>			  		
					</div>					
				</div>
				<br>
 <div class="row">
     <div class="col-md-8 col-xs-12 text-right">                  
     </div>
</div>
<br>
	</form:form>
	</div> 
</div>
 