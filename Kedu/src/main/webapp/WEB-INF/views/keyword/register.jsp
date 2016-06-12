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
  <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Registration Keyword</h4>
      </div>
     <!--  
      <form role="form" method="post">
		<input type='hidden' name='kno' value="${keywordVO.kno}">
	  </form>
	 --> 
	  <form role="form" method="post" action="/keyword/register">
		<div class="modal-body">
		<div class="form-group">
			<label for="inputKeyword">Keyword</label> 
			<input type="text"
				class="form-control" placeholder="Enter Keyword" name='word'>
		</div>
		</div>

		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>

    </div>  
	  
<script>
				
$(document).ready(function(){
		
	// Show the Modal on load
    //$("#RegistrationModal").modal({backdrop: true});
   // $("#myModal").modal({backdrop: true}
	/*
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/keyword/modify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	*/
});

</script>

</body>
</html>
