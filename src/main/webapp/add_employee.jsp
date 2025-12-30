<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Add Employee</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>

<body>

  <div class="form-container">
    <h2>Add New Employee</h2>
    
    <form action="AddEmployeeServlet" method="post">
      <input type="text" name="name" placeholder="Full Name" required><br>
      <input type="email" name="email" placeholder="Email" required><br>
      <input type="text" name="department" placeholder="Department" required><br>
      <input type="number" name="salary" placeholder="Salary" required><br>
      <button type="submit">Add Employee</button>
    </form>
    
  </div>
  
</body>
</html>
