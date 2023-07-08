<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 .center{
 display: flex;
 flex-direction: column;
 justify-content:center;
 align-items: center;
 }


</style>

</head>
<body>
	<div class="center">
		<h1>Insert Student</h1>
    	<form action="InsertBook" method="post">
  			<table>
 			<tr>
 				<td>name:</td>
 				<td>
 					<input type="text" name="fullName" required="required"/>
 				</td>
 			</tr>
 			<tr>
 				<td>code:</td>
 				<td>
 					<input type="text" name="Code" required="required"/>
 				</td>
 			</tr>
 			<tr>
 				<td>Image:</td>
 				<td>
 					<input type="text" name="images" required="required"/>
 				</td>
 			</tr>
 			<tr>
 				<td>Price:</td>
 				<td>
 					<input type="text" name="price" required="required"/>
 				</td>
 			</tr>
 			<tr>
					<td><input type="submit" value="Insert" /> <input type="reset"
						value="Clear" /></td>
				</tr>
 			</table>
 			</form>
 
 				<a href="index.jsp">Back</a>
 			</div>
 			
</body>
</html>