<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REQUEST DETAILS</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/model/user.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h2>Request List Details</h2>
<form>
<script type="text/javascript">
function maninmenu()
{
alert("Request list");
window.location.href = "mainmenu.jsp";
}
</script>
<script>
function getBooks(){
		
	var users = [ {"name" : "deepa" , "phone_no": 123 }, {"name" : "h" , "phone_no": 123 } ];
	return users;
	//let books = [ { "name":"Java" , "price": 500},{ "name":"C" , "price": 300}];
	//for ( var i=0; i< books.length; i++){
	  //  var book = books[i];
	   // console.log(book);
}

function loadBooks (){
        
    
    //let books = [ {"id": 1, "name":"Java" , "price": 500},{"id": 2, "name":"C" , "price": 300}];
   //let users = getBooks();

    var url = "http://localhost:8080/webcharityapp/userlist";
   $.get(url, function(response)){
		var books = response;
	
        }
        
    
    document.getElementById("tbody").innerHTML = "";
    var content = "";
    var i = 0;
    for(let user of books){
        console.log(books);
        content += "<tr>";
        content += "<td>" + ++i + "</td>";
        content += "<td>" + user.name + "</td>";
        content += "<td>" + user.phone_no + "</td>";
        content += "</tr>";
    }
    console.log(content);
    
    document.getElementById("tbody").innerHTML =  content;

}

</script>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <h3>Donor List</h3>
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