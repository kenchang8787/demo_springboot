package kenchang8787.com.demo_springboot.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceAlreadyExistedException extends RuntimeException {

  private final String resourceName;

  private final String fieldName;

  private final Object fieldValue;

  public ResourceAlreadyExistedException(String resourceName, String fieldName, Object fieldValue) {
    super(String.format("%s is duplicate with %s: '%s'", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }
}
