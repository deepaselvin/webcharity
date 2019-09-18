<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REQUEST DETAILS</title>
<body style="text-align:center">
<br><br><br>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>



<script>

function loadBooks (){
//alert('table content');        
    var url = "http://localhost:8080/webcharityapp/userlist";
   $.getJSON(url, function(response){
		var books = response;
		//alert(response);
	
    document.getElementById("tbody").innerHTML = "";
    var content = "";
    var i = 0;
    for(let us of books){
        console.log(books);
        content += "<tr>";
        content += "<td>" + ++i + "</td>";
        content += "<td>" + us.name + "</td>";
        content += "<td>" + us.phone_no + "</td>";
        content += "</tr>";
    }
    console.log(content);
    
    document.getElementById("tbody").innerHTML =  content;

});
}
</script>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>
	
	<h2>Donor List</h2>
	<form>
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					
					<table border="1" class="table table-condensed" id="tbl">
						<thead>
							<tr>
								<th>Sno</th>
								<th>Donor Name</th>
								<th>phone_no</th>

							</tr>
						</thead>
						<tbody id="tbody">

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script>
loadBooks();
</script>
	</form>
</body>
</html>