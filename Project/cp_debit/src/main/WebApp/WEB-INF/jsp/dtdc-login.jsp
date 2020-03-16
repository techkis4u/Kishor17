<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink" >
	<form:form action="dtdc-login.htm"  modelAttribute="loginCommand">
		<div align="center" id="error-div">
			<span style="color: red">
				<form:errors path="*"/>
			</span>
		</div>
		<h1 align="center">Login</h1>
		
		<div align="center" id="login-info-div">
			<table>
				<tr>
					<td>user name</td>
					<td><form:input path="userName"/></td>
				</tr>
				<tr>
					<td>password</td>
					<td><form:input path="password" type="password"/></td>
				</tr>
				<tr>
					<td>user type</td>
					<td>
					<form:select path="userType">
						<form:option value="">select</form:option>
						<form:option value="corporate">corporate</form:option>
						<form:option value="channel-parttner">channel-parttner</form:option>
						<form:option value="delivery-parttner">delivery-parttner</form:option>
					</form:select>	
					</td>
				</tr>
			</table>
		</div>
		<div align="center" id="submit-div">
			<table>
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><input type="reset" value="reset"></td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
</html>