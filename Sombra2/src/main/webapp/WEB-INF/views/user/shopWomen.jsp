<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
 	.filter .control-label{
 		text-align: left;
 	}
 </style>
        <content>
        <br>
        <div class="row">
            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                <div class="row">
                    <div class="col-md-2">
                        <h3 class="zero-padding">WOMEN</h3>
                        <div class="clothing">                                           
                           <c:forEach items="${typesOfClothingWomen}" var="type">
								<a href="/shopWomen/${type.itemType}">${type.getItemType()}</a> <br>                      	
						   </c:forEach>
                           <br>
                        </div>
                        <br>
                                       <!-- filter -->
                       <form:form class="form-horizontal filter" action="/shopWomen/${type}" method="GET" modelAttribute="filter">
							<div class="form-group">
								<label class="control-label col-sm-12"><h4>Price <span class="light-grey">(USD)</span></h4></label>
									<div class="col-sm-6">
										<form:input path="min" class="form-control" placeholder="from"/>
									</div>
							    	<div class="col-sm-6">
										<form:input path="max" class="form-control" placeholder="to"/>
									</div>
							</div>

										<div class="form-group">
											<label class="control-label col-sm-12"><h4>Brands</h4></label>
											<div class="col-sm-12">
												<form:checkboxes element="div" path="brandId" items="${brands}" itemValue="id" itemLabel="brandName"/>
											</div>
										</div> 	
	
										<div class="form-group">
											<label class="control-label col-sm-12"><h4>Colors</h4></label>
											<div class="col-sm-12">
												<form:checkboxes element="div" path="colorId" items="${colors}" itemValue="id" itemLabel="color"/>
											</div>
										</div>	
										<div class="form-group">
											<label class="control-label col-sm-12"><h4>Sizes</h4></label>
											<div class="col-sm-12">
												<form:checkboxes element="div" path="sizeId" items="${sizes}" itemValue="id" itemLabel="size"/>
											</div>
										</div>				
										<button type="submit" class="btn btn-default">Ok</button> 
						</form:form> 									
                    </div>        
                                    
                    <div class="col-md-10">
                        <div class="row">
                            <div class="col-md-12"> 
                            	<div class="row">
	                            	<div class="col-md-9 text-left">
	                            			<p><b>Items per page: </b></p>
					 						<custom:size posibleSizes="3,6,9,12" size="${page.size}" />
					 				</div>                            
	                                <div class="col-md-3 float-right">                                
	                                        <b>Order by price</b>
	                                         <custom:sort innerHtml="Low to High" paramValue="price" />
	                                         <custom:sort innerHtml="High to Low" paramValue="price,desc" />
									</div>
									
								</div>
                            </div>
                            <div class="col-md-12">
                                <div class="row dresses-pics"> 
						          <c:forEach items="${page.content}" var="itemOfClothing">
										<div class="col-md-4">
						 				<a href="/item/${itemOfClothing.id}"><img src="/images/clothes/${itemOfClothing.id}.jpg?version=${itemOfClothing.version}" width="100%"></a>
						                <p class="itemName">${itemOfClothing.itemName.name} <span class="itemBrand">${itemOfClothing.brand.brandName}</span></p>  
										<p class="itemPrice">USD ${itemOfClothing.price}   
											<a href="/shopWomen/${itemOfClothing.typeOfClothing.itemType}/addToCart/${itemOfClothing.id}<custom:allParams/>"><span class="itemBrand">Add <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span></span></a>
										</p>	
										</div>																		
								  </c:forEach>
                                </div>
                            </div>
                            
                            <div class="col-md-12">                             
							 	<div class="col-md-12 col-xs-12 text-center">
							 		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
							 	</div>
                            </div> 
                            
                        </div>                    
                    </div>
                    <!-- /.clothes representation -->
                </div>
            </div>
            <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
        <br>
        </content>
        
        
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>