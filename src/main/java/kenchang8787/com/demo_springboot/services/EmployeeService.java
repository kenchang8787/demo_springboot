package kenchang8787.com.demo_springboot.services;

import kenchang8787.com.demo_springboot.entitis.Employee;
import kenchang8787.com.demo_springboot.exceptions.ResourceAlreadyExistedException;
import kenchang8787.com.demo_springboot.exceptions.ResourceNotFoundException;
import kenchang8787.com.demo_springboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @Transactional // Spring Data JPA providers these annotation for its methods
public class EmployeeService implements EmployeeServiceInterface {

  @Autowired private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee createEmployee(Employee employee) {

    // check exists
    if (employeeRepository.existsById(employee.getId()))
      throw new ResourceAlreadyExistedException("Employee", "Id", employee.getId());

    // save
    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(Employee employee, long id) {

    // check exists
    Employee existedEmployee =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employee.getId()));

    // update
    existedEmployee.setFirstName((employee.getFirstName()));
    existedEmployee.setLastName(employee.getLastName());
    existedEmployee.setEmail(employee.getEmail());

    // save
    return employeeRepository.save(existedEmployee);
  }

  @Override
  public void deleteEmployee(long id) {

    // check exists
    if (!employeeRepository.existsById(id))
      throw new ResourceNotFoundException("Employee", "Id", id);

    employeeRepository.deleteById(id);
  }

  @Override
  public Employee getEmployeeById(long id) {
    return employeeRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }
}
