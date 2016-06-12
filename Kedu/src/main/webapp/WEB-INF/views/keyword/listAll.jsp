<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
  <title>Kedu System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
	  background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Kedu</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/">Home</a></li>
        <li class ="active"><a href="#">Keyword</a></li>
        <li><a href="#">Site</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container text-center" >
    <h2>Kedu System</h2>      
  </div>
</div>

<div class="container-fluid bg-3">    
  
  <div  id = "contents" style= "padding-left:40px">
  	<h4>Keywords List</h4><br>
  </div>
  
 <div class="container">  

<table class="table table-hover text-center">
<thead>
	<tr>
		<th style="width: 10px">KNO</th>
		<th style="text-align:center">WARD</th>
		<th style="text-align:center">REGDATE</th>
		<th style="text-align:center">CRAWLING</th>
		<th style="text-align:center">EXTRACTING</th>
	</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="KeywordVO">

	<tr>
		<td>${KeywordVO.kno}</td>
		<td><a href='/keyword/read?kno=${KeywordVO.kno}' 
			data-toggle="modal" data-target="#readKeyword" >${KeywordVO.word}</a></td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${KeywordVO.regdate}" /></td>
		<td>${KeywordVO.crawling}</td>
		<td>${KeywordVO.extracting}</td>
	</tr>

</c:forEach>
</tbody>
</table>


<!-- registration button	 -->
<a class="btn btn-primary pull-right" href="/keyword/register" 
			data-toggle="modal" data-target="#register">키워드 등록</a>

<!-- 
<button type="button" id=keywordReg data-toggle="modal"  onclick="location.href='/keyword/register'" 
	class="btn btn-primary pull-right">키워드 등록</button>
	
	
-->

<!--  register modal -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

        </div>
    </div>
</div>

<!--  read modal -->
<div class="modal fade" id="readKeyword" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

        </div>
    </div>
</div>




</div>
  </div>
  

<script>
    
    var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("처리가 완료되었습니다.");
    }
    
</script>

</body>
</html>




