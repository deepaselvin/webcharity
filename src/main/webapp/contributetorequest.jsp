<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN DETAILS</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body style="text-align: center">
	<br>
	<br>
	<br>
	<jsp:include page="Header.jsp"></jsp:include>
	<h2>Fund Needed Details</h2>

	<a href="donoractivity.jsp">BACK</a>
	<br />
	<br>
	<form onsubmit="login()">


		<label>Enter The Amount :</label> <input type="text" name="amount"
			id="Fundname" required autofocus /> <br /> <input type="submit"
			value="Submit" class="btn btn-success">
		<button type="reset" value="clear">clear</button>

	</form>

	<script>
		function login() {
			event.preventDefault();
			alert(' Thank You ');
			console.log(window.location.href);
			window.location.href = "index.jsp";
		}
	</script>


</body>
</html>