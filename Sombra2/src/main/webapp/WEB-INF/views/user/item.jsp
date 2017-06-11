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
        <div class="row">
            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                <div class="row">
                    <div class="col-md-offset-1 col-md-6 bigPic">
                        <a><img src="/images/clothes/${itemOfClothing.id}.jpg?version=${itemOfClothing.version}" width="100%"></a>
                    </div>
                    <!-- discription  -->
                    <div class="col-md-4 description">                           
                            <p class="itemNamen">${itemOfClothing.itemName.name}</p>
                            <p>Ref. ${itemOfClothing.getMarking()}</p>
                            <p class="itemSizen">BRAND: <span class="descrip">${itemOfClothing.brand.brandName}</span></p>
                            <div class="itemColoren clear-fix"><div class="c">COLOR: </div> <div class="bord"><div class="color"><img src="/images/color/${itemOfClothing.color.id}.jpg?version=${itemOfClothing.color.version}" width="100%"></div></div> </div>
                            <br>
                            <p class="itemSizen">SIZE: <span class="descrip">${itemOfClothing.size.size}</span></p>
                            <br>
                            <div class="buy">
                                <p class="pricen"> ${itemOfClothing.getPrice()} USD </p>                              
                                <%-- <a class="btn btn-my btn-lg" role="button" href="/addToCart/${itemOfClothing.id}"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to cart</a> --%>
                                <a class="btn btn-my btn-lg" role="button" href="/addToCart/${itemOfClothing.id}"> Buy </a>
                            </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <!-- /.row -->
     </content>		
		
<script>
	$('label').each(function() {
		if(!$(this).html()) $(this).parent('div').hide();
	});
</script>