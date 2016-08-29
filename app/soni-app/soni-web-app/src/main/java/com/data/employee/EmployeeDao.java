package com.data.employee;

import java.util.List;


/**
 * @author Hari Soni
 *
 */
public interface EmployeeDao {
 
 public void addEmployee(Employee employee);

 public List<Employee> listEmployeess();
 
 public Employee getEmployee(int empid);
 
 public void deleteEmployee(Employee employee);
}