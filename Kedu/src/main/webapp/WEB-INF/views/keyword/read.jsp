<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>

<body>

<!-- Modal 
<div id="KewordModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
-->
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Read Keyword</h4>
      </div>
      <form role="form" method="post">

		<input type='hidden' name='kno' value="${keywordVO.kno}">

	  </form>
      <div class="modal-body">
        <div class="form-group">
		<label for="exampleInputEmail1">Word</label> <input type="text"
			name='word' class="form-control" value="${keywordVO.word}">
			<!-- readonly="readonly"> -->
		</div>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-warning">Modify</button>
		<button type="submit" class="btn btn-danger">REMOVE</button>
		<button type="submit" class="btn btn-primary">LIST ALL</button>
      </div>
    </div>
    
   <!--  
  </div>
    
</div>
--> 
<script>
				
$(document).ready(function(){
		
	// Show the Modal on load
   // $("#KewordModal").modal("show");
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/keyword/modify");
		formObj.attr("method", "get");		
		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/keyword/remove");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "/keyword/listAll";
	});
	
});

</script>
</body>
</html>




