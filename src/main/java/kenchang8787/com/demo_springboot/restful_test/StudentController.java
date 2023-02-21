package kenchang8787.com.demo_springboot.restful_test;

import kenchang8787.com.demo_springboot.restful_test.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class StudentController {

  // http://localhost:8080/api/student
  @GetMapping(path = "student")
  public Student getStudent() {

    return new Student(1, "Ken", "Chang");
  }

  // http://localhost:8080/api/students
  @GetMapping("students")
  public List<Student> getStudents() {

    List<Student> students = new ArrayList<>();

    students.add(new Student(1, "Ken", "Chang"));
    students.add(new Student(2, "Vera", "Lin"));
    students.add(new Student(3, "Bob", "Cheng"));

    return students;
  }

  // http://localhost:8080/api/student/Ken/Chang
  // @PathVariable:
  // we could bind the request URL template path variable {firstName}, {lastName}
  // to the method variable.
  @GetMapping("student/{firstName}/{lastName}")
  public Student getStudentByFullName(
      @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
    return new Student(0, firstName, lastName);
  }

  // http://localhost:8080/api/student/query?id=1
  @GetMapping("student/query")
  public Student queryStudent(@RequestParam(name = "id") int id) {
    return new Student(id, "", "");
  }
}
