<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h2>Register For Admin</h2>
<form>
<script type="text/javascript">
function login()
{
alert("login successfully");
window.location.href = "mainmenu.jsp";
}
</script>
<label>UserName:</label>
<input type="text" name="UserName" id="UserName"   required autofocus />
<br/>
<label>PhoneNo:</label>
<input type="text" name="PhoneNo" id="PhoneNo"   required  />
<br/>

<input type = "button" value = "Submit" class="btn btn-success" onclick=login()>
<button type="submit" class="btn btn-danger" value="clear">clear </button>
<br/>
<a  href="login.jsp">Existing user</a>
</form>

</body>
</html>