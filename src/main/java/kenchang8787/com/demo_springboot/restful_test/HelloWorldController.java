package kenchang8787.com.demo_springboot.restful_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 中主要由以下兩個Annotation組成
// - @Controller
// -- 跟 spring 表達此類是一個 controller 實例
// - @ResponseBody
// -- 使用HTTP Message converters 將回傳值轉為 HTTP response body,
// -- 像是 XML, json, 基於 content-type header.
// -- 備註: 此 Converter 預設使用 MappingJackson2HttpMessageConverter
@RestController
@RequestMapping(value = "api/")
public class HelloWorldController {

  /**
   * GET HTTP Method
   *
   * @return String of "Hello World!"
   */
  @GetMapping("hello-world")
  public String helloWorld() {
    return "Hello World!";
  }
}
