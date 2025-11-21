package com.cadbury.servlet;

import com.cadbury.dao.EmployeeDAO;
import com.cadbury.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ViewEmployeeServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Employee> list = EmployeeDAO.getAllEmployees();
            req.setAttribute("list", list);
            RequestDispatcher rd = req.getRequestDispatcher("view_employee.jsp");
            rd.forward(req, resp);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
