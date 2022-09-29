package com.ciclo3.TodoCompleto.Service;

import com.ciclo3.TodoCompleto.Models.Employee;

import java.util.List;

public interface EmployeeManagerInterface {
    public List<Employee> getEmployees();
    public Employee getEmployee(Long idEmployee) throws Exception;
    public String setEmployee (Employee Employees) throws Exception;
    public Employee UpdateEmployeeAll(Employee EmployeeUpdate, Long id) throws Exception;
    public Employee UpdateEmployee(Employee EmployeeUpdate, Long id) throws Exception;
    public String DeleteEmployee(Long idEmployee) throws Exception;
}
