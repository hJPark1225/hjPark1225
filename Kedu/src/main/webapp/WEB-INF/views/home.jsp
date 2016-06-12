<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" %>

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
    ul#keyword li {
    	display:inline;
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
        <li class="active"><a href="/">Home</a></li>
        <li><a href="/keyword/listPage">Keyword</a></li>
        <li><a href="#">Site</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron">
  <div class="container text-center">
    <h1>Kedu System</h1>      
  </div>
</div>

 <!-- KewordList  -->
<div class="container">
 <h3>자동수집 키워드</h3>
 <ul id = "keyword">
	<c:forEach items="${list}" var= "KeywordVO">
	<li>
		<button id = "${KeywordVO.kno}" type="button" class="btn btn-link" 
		onclick="location.href='/'" value= "${KeywordVO.kno}">${KeywordVO.word}</button>
	</li>	
	</c:forEach>
 </ul> 
</div>

 <div class="container">
  
  <ul class="nav nav-tabs" id = "tabs">
    <li class="active"><a data-toggle="tab" href="#news">News</a></li>
    <li><a data-toggle="tab" href="#video" data-target="#video">Video</a></li>
  </ul>
	
		
<div class="tab-content">
	<div id="news" class="tab-pane fade in active">
		<h3>news</h3>
	</div>
	<div id="video" class="tab-pane fade">
		<h3>video</h3>
		
	</div>
</div>


	</div>
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

<script>
$(document).ready(function(){
	
    $(".nav-tabs a").click(function(){
        //$(this).tab('show');

    });
   
    
    <%
    String page_index = request.getParameter("page");
    String tab_page = request.getParameter("tab");
    String tab_page2 = "#" + tab_page;
    
    if(page_index == null)
    	page_index = "1";
    
    if(tab_page == null){
    	tab_page = "news";
    	tab_page2 = "#news";
    }
    %>
     
    //window.alert(getCookie('ckno'));
    if(getCookie('ckno') == ''){
    	//window.alert('${list.get(0).kno}');
    	var a = '${list.get(0).kno}';
    	setCookie('ckno', a);	//쿠키생성
    } 
    
 
    var kno_coockie = getCookie('ckno');  
    $('<%=tab_page2%>').load('<%=tab_page%>' + "/listPage/" + kno_coockie + "?page=" + '<%=page_index%>' + "&perPageNum=8");
   
   
    if(getCookie('ckno') != ''){
    	 var name = "#" + kno_coockie;
    	$(name).css("border", "2px solid #008CBA");
    }
    
	$(".btn-link").on("click", function(){
		
		if(getCookie('ckno') != ''){
			setCookie('ckno', '');		//쿠키 삭제
		}
		
		setCookie('ckno', $(this).val());
	});
	
	
});

	$(function() {
		$("#tabs a").click(function() {
			
			var tab = this.hash.substr(1);	
			var tab_kno = getCookie('ckno');
			$(this.hash).load(tab + "/listPage/" + tab_kno + "?page=1&perPageNum=8");
			
		})
	})

    // 쿠키 생성
    function setCookie(cName, cValue){
        var expire = new Date();
        cookies = cName + '=' + escape(cValue) + '; path=/ ;'; // 한글 깨짐을 막기위해 escape(cValue)를 합니다.
        document.cookie = cookies;
    }
 
    // 쿠키 가져오기
    function getCookie(cName) {
        cName = cName + '=';
        var cookieData = document.cookie;
        var start = cookieData.indexOf(cName);
        var cValue = '';
        if(start != -1){
            start += cName.length;
            var end = cookieData.indexOf(';', start);
            if(end == -1)end = cookieData.length;
            cValue = cookieData.substring(start, end);
        }
        return unescape(cValue);
    }
   
</script>


</body>
</html>
