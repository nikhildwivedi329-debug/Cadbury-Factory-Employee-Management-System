<%@ page import="java.util.*,com.cadbury.model.Employee" %>
<%
List<Employee> list = (List<Employee>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>

<head>
  <title>View Employees</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>

<body>

  <h2>Employee List</h2>
  <table border="1" cellspacing="0">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th><th>Action</th></tr>
    <%
      if (list != null) {
        for (Employee e : list) {
    %>
    <tr>
      <td><%= e.getId() %></td>
      <td><%= e.getName() %></td>
      <td><%= e.getEmail() %></td>
      <td><%= e.getDepartment() %></td>
      <td><%= e.getSalary() %></td>
      <td><a href="DeleteEmployeeServlet?id=<%= e.getId() %>">Delete</a></td>
    </tr>
    <%
        }
      }
    %>
  </table>
  
</body>
</html>
