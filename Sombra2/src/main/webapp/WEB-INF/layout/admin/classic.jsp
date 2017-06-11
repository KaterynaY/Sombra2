<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 	переписали через /resources/.. щоб не залежати від нету -->
<!-- <script src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js" ></script> -->
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<link rel="stylesheet" href="/resources/css/style.css">
<script src="/resources/js/chosen.jquery.min.js" ></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
	$(function() {
		$('select').chosen();
	});
</script>
<style type="text/css">
body {
	padding-bottom: 132px; 
	padding-top: 53px;
} 
@media(min-width:768px) and (max-width:1765px) {  
			.navbar-nav>li>a{
					padding:15px 4px;
				}
			}
@media (min-width: 1000px) {
    .navbar .navbar-nav {
        display: inline-block;
        float: none;
        vertical-align: top;
    }
    .navbar .navbar-collapse {
        text-align: center;
    }
}
@media(max-width:1000px)  {
	.nav > li{
	 	float: none;
		position: relative;
		display: block;
	}
    .navbar-collapse.collapse {
        display: none !important;
    }
    .navbar-collapse {
        overflow-x: visible !important;
    }
    .navbar-collapse.in {
      overflow-y: auto !important;
    }
    .collapse.in {
      display: block !important;
    }
    .navbar-toggle {
      display: block;
  }
}
</style>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
    <tiles:insertAttribute name="header" />
    <%-- <tiles:insertAttribute name="subHeader" /> --%>
	<div class="container-fluid">
		<tiles:insertAttribute name="body" />
	</div>
		<tiles:insertAttribute name="footer" />
</body>
</html>