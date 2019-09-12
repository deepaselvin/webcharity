<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN DETAILS</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
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

<label>Enter Request ID:</label>
<input type="text" name="Request" id="Requestid"   required autofocus />
<br/>

<label>Enter Fund Needed:</label>
<input type="text" name="Fund" id="Fund"   required autofocus />
<br/>

<input type = "button" value = "Submit" class="btn btn-success" onclick= maninmenu()>
<button type="submit" value="clear">clear </button>
</form>

</body>
</html>