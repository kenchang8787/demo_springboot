package kenchang8787.com.demo_springboot.controllers;

import kenchang8787.com.demo_springboot.entitis.Employee;
import kenchang8787.com.demo_springboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController 幫你把 @Controller, @ResponseBody 都添加好了
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  // POST api/employees
  // @RequestBody
  // annotation allows us to retrieve the request's body and automatically convert it to Java Object
  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
  }

  // PUT api/employees/1
  @PutMapping("{id}")
  public ResponseEntity<Employee> updateEmployee(
      @RequestBody Employee employee, @PathVariable long id) {
    return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
  }

  // DELETE api/employees/1
  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteEmployee(@PathVariable long id) {

    employeeService.deleteEmployee(id);

    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  // GET api/employees/1
  @GetMapping("{id}")
  public Employee getEmployeeById(@PathVariable(name = "id") long id) {
    return employeeService.getEmployeeById(id);
  }

  // GET api/employees
  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }
}
