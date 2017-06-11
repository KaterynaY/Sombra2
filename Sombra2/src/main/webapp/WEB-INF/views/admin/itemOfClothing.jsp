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
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				    <li><a href="/admin/itemName">Item name</a></li>
					<li><a href="/admin/brand">Brand</a></li>
					<li><a href="/admin/toc">Type of clothing</a></li>
					<li><a href="/admin/targeta">Target audience</a></li>
					<li><a href="/admin/color">Color</a></li>
					<li><a href="/admin/size">Size</a></li>
					<li class="active"><a href="/admin/ioc<custom:allParams/>">Item of clothing</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
 <div class="row">
            <div class="col-md-offset-1 col-md-10 col-md-offset-1">
<div class="row">                       
	<div class="col-md-3 col-xs-12">
		
				<div class="row">
 					<div class="col-md-3 col-xs-3 text-center">
 						<div class="dropdown">
 							<button class="btn btn-primary dropdown-toggle" type="button"
 								data-toggle="dropdown">
 								Sort <span class="caret"></span>
 							</button>
 							<ul class="dropdown-menu">
 								<custom:sort innerHtml="Price asc" paramValue="price" />
 								<custom:sort innerHtml="Price desc" paramValue="price,desc" />
 								<custom:sort innerHtml="Item name asc" paramValue="itemName.name" />
 								<custom:sort innerHtml="Item name desc" paramValue="itemName.name,desc" />
 								<custom:sort innerHtml="Color asc" paramValue="color.color" />
 								<custom:sort innerHtml="Color desc" paramValue="color.color,desc" />
 							</ul>
 						</div>
 					</div>
 					<div class="col-md-3 col-xs-3 text-center">
 						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
 					</div>
 				</div>
	
	
	
  		 <form:form class="form-horizontal filter" action="/admin/ioc" method="GET" modelAttribute="filter">
			<div class="form-group">
			    <label class="control-label col-sm-12"><h4>Marking</h4></label>
				<div class="col-sm-5">
					<form:input path="minM" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-5">
					<form:input path="maxM" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
			    <label class="control-label col-sm-12"><h4>Price</h4></label>
				<div class="col-sm-5">
					<form:input path="min" class="form-control" placeholder="Min"/>
				</div>
				<div class="col-sm-5">
					<form:input path="max" class="form-control" placeholder="Max"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-12"><h4>Target Audience</h4></label>
				<div class="col-sm-12">
					<form:checkboxes element="div" path="targetAudienceId" items="${targetAudiences}" itemValue="id" itemLabel="category"/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-sm-12"><h4>Brands</h4></label>
						<div class="col-sm-12">
							<form:checkboxes element="div" path="brandId" items="${brands}" itemValue="id" itemLabel="brandName"/>
						</div>
					</div> 
				</div>
				<div class="col-md-6">	
					<div class="form-group">
						<label class="control-label col-sm-12"><h4>Sizes</h4></label>
						<div class="col-sm-12">
							<form:checkboxes element="div" path="sizeId" items="${sizes}" itemValue="id" itemLabel="size"/>
						</div>
					</div>	
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">	
				<div class="form-group">
					<label class="control-label col-sm-12"><h4>Types</h4></label>
					<div class="col-sm-12">
						<form:checkboxes element="div" path="typeOfClothingId" items="${typesOfClothing}" itemValue="id" itemLabel="itemType"/>
					</div>
				</div>
				</div>
				<div class="col-md-6">
				<div class="form-group">
					<label class="control-label col-sm-12"><h4>Colors</h4></label>
					<div class="col-sm-12">
						<form:checkboxes element="div" path="colorId" items="${colors}" itemValue="id" itemLabel="color"/>
					</div>
				</div>
				</div>
			</div>				
			<button type="submit" class="btn btn-primary">Ok</button>
		</form:form>  
	</div>
	<div class="col-md-8 col-xs-12">
	    <div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/ioc" method="POST" modelAttribute="itemOfClothing" enctype="multipart/form-data">
				<custom:hiddenInputs excludeParams="itemName, marking, price, brand, targetAudience, typeOfClothing, color, size"/>				    
				    <div class="form-group">
						<label for="itemName" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="itemName"/></label>
					</div>
				    <div class="form-group">
    					<label for="itemName" class="col-sm-2 control-label">Item Name</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="itemName" id="itemName" items="${itemNames}" itemValue="id" itemLabel="name"/>
    					</div>
  					</div> 					
  					<div class="form-group">
 						<label for="marking" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="marking"/></label>
 					</div> 					
  					<div class="form-group">
    					<label for="marking" class="col-sm-2 control-label">Marking</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="marking" id="marking"/>
    					</div>
  					</div>  					
  					<div class="form-group">
 						<label for="price" style="color:red;text-align:left;" class="col-sm-offset-2 col-sm-10 control-label"><form:errors path="price"/></label>
 					</div>
  					<div class="form-group">
    					<label for="price" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="price" id="price"/>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="brand" class="col-sm-2 control-label">Brand</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="brand" id="brand" items="${brands}" itemValue="id" itemLabel="brandName"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="targetAudience" class="col-sm-2 control-label">Target Audience</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="targetAudience" id="targetAudience" items="${targetAudiences}" itemValue="id" itemLabel="category"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="typeOfClothing" class="col-sm-2 control-label">Type Of Clothing</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="typeOfClothing" id="typeOfClothing" items="${typesOfClothing}" itemValue="id" itemLabel="itemType"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="color" class="col-sm-2 control-label">Color</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="color" id="color" items="${colors}" itemValue="id" itemLabel="color"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="size" class="col-sm-2 control-label">Size</label>
    					<div class="col-sm-10">
      						<form:select class="form-control" path="size" id="size" items="${sizes}" itemValue="id" itemLabel="size"/>
    					</div>
  					</div>
  					<div class="form-group">
      					<label for="file" class="col-sm-2 control-label">Image</label>
      					<div class="col-sm-10">
        						<input name="file" id="file" type="file">
     					</div>
    				</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		
		<div class="row">
		    <div class="col-md-2 col-xs-2"><h4>Image</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Item name</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Marking</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Price</h4></div>			
			<div class="col-md-1 col-xs-1"><h4>Brand</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Target audience</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Type</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Color</h4></div>
			<div class="col-md-1 col-xs-1"><h4>Size</h4></div>
			<div class="col-md-2 col-xs-2"><h4>Options</h4></div>
		</div>

			<c:forEach items="${page.content}" var="itemOfClothing">
				<div class="row">

                    <div class="col-md-2 col-xs-2"><img src="/images/clothes/${itemOfClothing.id}.jpg?version=${itemOfClothing.version}" width="100%"></div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.itemName.name}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.marking}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.price}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.brand.brandName}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.targetAudience.category}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.typeOfClothing.itemType}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.color.color}</div>
					<div class="col-md-1 col-xs-1">${itemOfClothing.size.size}</div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/ioc/update/${itemOfClothing.id}<custom:allParams/>">update</a>
					                               <a class="btn btn-danger" href="/admin/ioc/delete/${itemOfClothing.id}<custom:allParams/>">delete</a>
					</div>
				</div>
			</c:forEach>
	</div>

 </div>
 <div class="row">
 	<div class="col-md-12 col-xs-12 text-center">
 		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
 	</div>
</div>
</div>
</div>
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>