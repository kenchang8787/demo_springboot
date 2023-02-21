package kenchang8787.com.demo_springboot.restful_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Student entity */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  /** Student id */
  private int Id;

  /** Student first name */
  private String firstName;

  /** Student last name */
  private String lastName;
}
