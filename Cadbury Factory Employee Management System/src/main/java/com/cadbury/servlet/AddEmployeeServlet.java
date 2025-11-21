package com.cadbury.servlet;

import com.cadbury.dao.EmployeeDAO;
import com.cadbury.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddEmployeeServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	
            String cachedAllowHeaderValue = null;
			Employee e = new Employee(0, cachedAllowHeaderValue, cachedAllowHeaderValue, cachedAllowHeaderValue, 0);
            e.setName(req.getParameter("name"));
            e.setEmail(req.getParameter("email"));
            e.setDepartment(req.getParameter("department"));
            e.setSalary(Double.parseDouble(req.getParameter("salary")));

            EmployeeDAO.addEmployee(e);
            resp.sendRedirect("view_employee.jsp");
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
            resp.getWriter().println("Error adding employee!");
        }
    }
}
