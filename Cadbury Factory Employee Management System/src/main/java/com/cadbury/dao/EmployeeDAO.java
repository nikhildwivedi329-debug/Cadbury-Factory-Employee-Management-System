package com.cadbury.dao;
import java.sql.*;
import java.util.*;
import com.cadbury.model.Employee;

public class EmployeeDAO {
	
    private static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:33601/cadbury_factory", "root", "root");
    }

    public static int addEmployee(Employee e) throws Exception {
    	
        String sql = "INSERT INTO employees(name,email,department,salary) VALUES (?,?,?,?)";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, e.getName());
        ps.setString(2, e.getEmail());
        ps.setString(3, e.getDepartment());
        ps.setDouble(4, e.getSalary());
        
        return ps.executeUpdate();
    }

    public static List<Employee> getAllEmployees() throws Exception {
    	
        List<Employee> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM employees");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	
            list.add(new Employee(
            		
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("department"),
                rs.getDouble("salary")
            ));
        }
        
        return list;
    }

    public static void deleteEmployee(int id) throws Exception {
    	
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id=?");
        
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
