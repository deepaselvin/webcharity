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

<h2>Register For New Admin</h2>
<form>
<script type="text/javascript">

function login()
{
alert("Registered successfully");
window.location.href = "adminlogin.jsp";
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
<a  href="adminlogin.jsp">Existing user</a>
 </form>
<script>
function register()
{
	//alert('admin register');
	event.preventDefault(); 	
   
   var adminName = document.getElementById("UserName").value;
   var phone_no=document.getElementById("PhoneNo").value;
   var formData = "UserName=" + adminName+ "&PhoneNo="+phone_no;
   console.log(formData);
  // alert(formData);

    var url="http://localhost:8080/webcharityapp/AdminRegister?"+ formData;    
    console.log(url);
    //alert(url);
    var formData = {};
    $.get(url,function(response){
        console.log(response);
    	//alert(response);  

        if (response == null || response == "null") {
            alert("Invalid Username/Password");
        }
            else{
			window.location.href="adminlogin.jsp";
            }
	      
    });
}
</script>
</body>
</html>