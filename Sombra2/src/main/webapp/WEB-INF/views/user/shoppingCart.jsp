<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <div class="row">
     <div class="col-md-offset-3 col-md-6 col-md-offset-3">
     <div class="row">
     <div class="col-md-offset-2 col-md-10">
      		<br>
            <div><b>You've got ${shoppingBag.getCount()} item(s) in your bag</b></div>
            <br>                                 
			<c:forEach items="${list}" var="itemOfClothing">
				<div class="row">
                    <div class="col-md-2 col-xs-2">
                    <a href="/item/${itemOfClothing.getItemOfClothing().id}">
                    	<img src="/images/clothes/${itemOfClothing.getItemOfClothing().id}.jpg?version=${itemOfClothing.getItemOfClothing().version}" width="100%">
                    </a>	
                    </div>
                    <div class="col-md-3 col-xs-3">                         
							<div><b>${itemOfClothing.getItemOfClothing().itemName.name}</b></div>
							<br>
							<div><b>Price:</b> ${itemOfClothing.getItemOfClothing().price} USD</div>
							<div><b>Brand:</b> ${itemOfClothing.getItemOfClothing().brand.brandName}</div>
							<div><b>Size:</b> ${itemOfClothing.getItemOfClothing().size.size}</div>
							<div><b>Color:</b> ${itemOfClothing.getItemOfClothing().color.color}</div>
							<br>
							<div><a class="btn btn-warning" href="/cart/${itemOfClothing.cartId}/delete/${itemOfClothing.getItemOfClothing().id}">Delete from the bag</a></div> 
					</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-default" href="/cart/${itemOfClothing.cartId}/minus/${itemOfClothing.getItemOfClothing().id}"><i class="glyphicon glyphicon-minus"></i></a>
						${itemOfClothing.quantity}
						<a class="btn btn-default" href="/cart/${itemOfClothing.cartId}/plus/${itemOfClothing.getItemOfClothing().id}"><i class="glyphicon glyphicon-plus"></i></a>
					</div>					
				</div>
				<br>
			</c:forEach>
 <div class="row">
     <div class="col-md-8 col-xs-12 text-right"> 
          <h3>Total price : ${total} USD</h3>
          <a class="btn btn-danger" href="/confirm"><div style="width:100px; font-size:18px;"><b> Buy </b></div></a>
     </div>
</div>
<br>
	</div> 
 </div>
 </div> 
 </div>
 