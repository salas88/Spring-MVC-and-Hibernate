<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Users list</title>
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath }/resources/css/style.css"/>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer relationship manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="context">
			
			<!-- Add a new button: Add new User -->
			
			<input type="button" value="Add User"
					onClick="window.location.href='showFormForAdd'; return false"
					class="add-button"/>
				<table>
					<tr>
						<th>First name</th>	
						<th>Last name</th>	
						<th>email</th>	
					</tr>
					<c:forEach var="tempUser" items="${users }">
					<tr>
						<td> ${tempUser.firstName } </th>
						<td> ${tempUser.lastName } </th>
						<td> ${tempUser.email } </th>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
	</body>
</html>