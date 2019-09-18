<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN DETAILS</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
</head>
<body style="text-align:center">
<br><br><br>
<jsp:include page="Header.jsp"></jsp:include>
<h2>Fund Needed Details</h2>
<form>
<script type="text/javascript">
function maninmenu()
{
alert("Admin User");
window.location.href = "mainmenu.jsp";
}
</script>
</form>

<form  onsubmit="register()">

<label>Enter New Fund :</label>
<input type="text" name="Fundname" id="Fundname"   required autofocus />
<br/>
<script>
function register()
{
	//alert('ENTER INTO METHOD');
	event.preventDefault(); 	
   
   var name = document.getElementById("Fundname").value;
   var formData = "Fundname=" + name;
   console.log(formData);
  //alert(formData);
    var url="http://localhost:8080/webcharityapp/addrequest?"+ formData;
    console.log(url);
    //alert(url);
    var formData = {};
    $.get(url, function(response){
            console.log(response);
            //alert(response);

            if (response == null || response == "null") {
                alert("Invalid fund");
            }
                else{
				window.location.href="login.jsp";
                }

            });
}
</script>

<label>Enter Fund Needed:</label>
<input type="text" name="Fund" id="Fund"   required autofocus />
<br/>

<input type = "submit" value = "Submit" class="btn btn-success" >
<button type="submit" value="clear">clear </button>
<br>
<a href="donoractivity.jsp">BACK</a> <br/><br>
<a href="reqlistorg.jsp"> REQUEST LIST</a> <br/>

</form>

</body>
</html>