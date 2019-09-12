<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DONOR DETAILS</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h2>Fund Donated Details</h2>
<form>
<script type="text/javascript">
function maninmenu()
{
alert("Donor List");
window.location.href = "mainmenu.jsp";
}
</script>

<label>Enter Request ID:</label>
<input type="text" name="UserName" id="UserName"   required autofocus />
<br/>

<input type = "button" value = "Submit" class="btn btn-success" onclick= maninmenu()>
<button type="submit" value="clear">clear </button>
</form>
</body>
</html>