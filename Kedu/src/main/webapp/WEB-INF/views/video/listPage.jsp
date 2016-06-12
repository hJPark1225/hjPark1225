<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
  <title>News List</title>
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
  
  	<c:forEach items="${list}" var= "VideoVO">

		<div class=col-sm-3>
			<img src= "${VideoVO.thumbnail_url}" width='170' height='150'>
			<p><p>
			<p><a href='#' onclick="window.open('${VideoVO.url}', '_blank', 'toolbar=yes, scrollbars=yes, fullscreen=yes resizable=yes')">${VideoVO.title}</a></p>
		</div>	
	</c:forEach>
	
  </div>
  <ul class="pagination" id = page>

		<c:if test="${pageMaker.prev}">
			<li><a href="${pageMaker.makeQuery(pageMaker.startPage - 1) }&tab=video">&laquo;</a></li>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
			<li
				<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
				<a href="${pageMaker.makeQuery(idx)}&tab=video" id= index> ${idx} </a>
			</li>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="${pageMaker.makeQuery(pageMaker.endPage +1)}&tab=video">&raquo;</a></li>
		</c:if>

 </ul>
 
</div>

<script>	


</script>
	
</body>
</html>

