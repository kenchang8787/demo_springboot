package kenchang8787.com.demo_springboot.services;

import kenchang8787.com.demo_springboot.entitis.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

  Employee createEmployee(Employee employee);

  Employee updateEmployee(Employee employee, long id);

  void deleteEmployee(long id);

  Employee getEmployeeById(long id);

  List<Employee> getAllEmployees();
}
