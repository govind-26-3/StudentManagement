<!doctype html>
<%@page import="com.ty.entity.Student"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<%
	List<Student> students = (List<Student>) request.getAttribute("students");
	%>

	<div class="container">

		<h4>${msg}</h4>
		<h1>Home Page</h1>


		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Student student : students) {
				%>
				<tr>
					<td><%=student.getName()%></td>
					<td><%=student.getEmail()%></td>
					<td><%=student.getPhone()%></td>
					<td><a href="<%=request.getContextPath() %>/update?Id=<%=student.getId()%>"><button class="btn btn-primary">Update</button></a></td>
					<td><a href="<%=request.getContextPath() %>/delete?Id=<%=student.getId()%>"><button  class="btn btn-danger">Delete</button></a></td>
				</tr>

				<%
				}
				%>
			</tbody>
		</table>

		<a href="add"><button class="btn btn-primary">Add</button></a><br>
		<br>
		<br>
		 <a href="email"><button class="btn btn-primary">Send Email</button></a><br>
		<a href="/">Logout</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>