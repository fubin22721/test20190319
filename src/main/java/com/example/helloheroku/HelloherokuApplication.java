package com.example.helloheroku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class HelloherokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloherokuApplication.class, args);
	}
	
	  @RequestMapping("/")
	  String index() {
	    return "index.html";
	  }
	
	

}
