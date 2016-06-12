<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Kedu System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid bg-3 text-center">    
  <h3>Contents</h3><br>
  <div id = "contents" class="row">
  		
  </div>
</div>

<script>	

	$(document).ready(function(){
	//function abs() {
	
	var test = "";
	var a = "";
	var divTest = document.getElementById("contents");
	
	<c:forEach items="${list}" var= "NewsVO">
	
		test= ${NewsVO.thumbnail_flag};
		a += "<div class=col-sm-3>";
				
		if(test == true){
			a += "<img src='" + "${NewsVO.thumbnail_url}" + "' width='170' height='150'>";
		}
		else {
			a += "<p>" + "${NewsVO.contents}" + "</p> ";
		}
	
		a += "<p><a href='#'" + " onclick=\"" + "window.open('" + "${NewsVO.url}" + "', '_blank', 'toolbar=yes, scrollbars=yes, fullscreen=yes resizable=yes')\">" + "${NewsVO.news_title}" + "</a></p></div>";
	
	</c:forEach>

		divTest.innerHTML = a;
		//window.alert(a);
	});
	
</script>
</body>
</html>

