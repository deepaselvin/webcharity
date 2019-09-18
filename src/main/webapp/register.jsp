<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRATION PAGE</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>

</head>
<body style="text-align:center">
<br><br><br>
<jsp:include page="Header.jsp"></jsp:include>

<h2>Register For New User</h2>
<form>
<script type="text/javascript">
function login()
{
alert("Registered successfully");
window.location.href = "login.jsp";
}
</script>



</form>
<form  onsubmit="register()">

<label>UserName:</label>
<input type="text" name="UserName" id="UserName"   required autofocus />
<br/>
<label>PhoneNo:</label>
<input type="text" name="PhoneNo" id="PhoneNo"   required  />

<br/>

<input type = "submit" value = "Submit" class="btn btn-success"  >
<button type="reset" class="btn btn-danger" value="clear">clear </button>
<br/>
<a  href="login.jsp">Existing user</a>
 </form>
<script>
function register()
{
	//alert(' register');
	event.preventDefault(); 	
   
   var name = document.getElementById("UserName").value;
   var phone_no=document.getElementById("PhoneNo").value;
   var formData = "UserName=" + name+ "&PhoneNo="+phone_no;
   console.log(formData);

    var url="http://localhost:8080/webcharityapp/Register?"+ formData;
    console.log(url);
    //alert(url);
    var formData = {};
    $.get(url, function(response){
            console.log(response);
            //alert(response);

            if (response == null || response == "null") {
                alert("Invalid Username/Password");
            }
                else{
				window.location.href="login.jsp";
                }

            });
}
</script>
</body>
</html>