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
					
					<!-- construct update link with customer id -->
					<c:url var="updateLink" value="/users/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id }" />
					</c:url>
					
					<!-- construct delete link with customer id -->
					<c:url var="deleteLink" value="/users/delete">
						<c:param name="userId" value="${tempUser.id }" />
					</c:url>
					<tr>
						<td> ${tempUser.firstName } </td>
						<td> ${tempUser.lastName } </td>
						<td> ${tempUser.email } </td>
						
						<!--  -->
						<td> <a href="${updateLink } ">Update</a>
						|
						<a href="${deleteLink }"
						onclick="if(!(confirm('Are you sure you wont to delete this user?'))) return false">Delete</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
	</body>
</html>