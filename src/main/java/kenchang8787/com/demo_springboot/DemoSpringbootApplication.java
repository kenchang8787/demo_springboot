package kenchang8787.com.demo_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication, 主要是以下三個Annotation合併而成的
// - @SpringBootConfiguration
// -- 繼承自 @Configuration, 標註當前類別是配置類,
// -- 並會將當前類別標記為 @Bean 的實例加入到 Spring 容器中
// - @EnableAutoConfiguration
// -- 啟動自動加入配置, 導入你所需要的jar包,
// -- 例如本專案有用到 spring-boot-starter-web, 而這是 spring 的核心,
// -- 裡面包括了 web mvc, tomcat...etc, 他都會自動幫你導入
// - @ComponentScan
// -- 掃描當前 package 和底下所有 @Controller, @Service, @Component,
// -- @Repository 項目
@SpringBootApplication
public class DemoSpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringbootApplication.class, args);
  }
}
