<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
</head>
<body style="text-align:center">
<br><br><br>
<jsp:include page="Header.jsp"></jsp:include>
<h2>LOGIN DETAILS</h2>


<script type="text/javascript">
function login()
{
alert("login successfully");
window.location.href = "requestlist.jsp";
}
</script>

<form  onsubmit="register()">

<label>UserName:</label>
<input type="text" name="UserName" id="UserName" placeholder="Enter Username"  required autofocus />
<br/>
<label>PhoneNo:</label>
<input type="text" name="PhoneNo" id="PhoneNo"   required  />
<br/>
<input type = "submit" value = "Submit" class="btn btn-success"  >
<button type="reset" class="btn btn-danger" value="clear">clear </button>
</form>

<script>
function register()
{
	//alert('register');
	event.preventDefault(); 	
   
   var name = document.getElementById("UserName").value;
   var phone_no=document.getElementById("PhoneNo").value;
   var formData = "UserName=" + name+ "&PhoneNo="+phone_no;
   console.log(formData);
   //alert(formData);
    var url="http://localhost:8080/webcharityapp/Login?"+ formData;
    console.log(url);
    //alert(url);
    var formData = {};

    $.get(url, function(response){
            console.log(response);
            var data = JSON.parse(response);
//          alert(data.errorMessage);

            if ( data.errorMessage != null ) {
                alert("Invalid Username/Password");
            }
                else{
				window.location.href="donoractivity.jsp";
                }
    });
}
</script>
</body>
</html>
