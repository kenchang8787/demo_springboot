package kenchang8787.com.demo_springboot.repositories;

import kenchang8787.com.demo_springboot.entitis.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository - 不須添加, 因為Spring Data JPA本身內部(SimpleJpaRepository)就提供此註解
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
