package com.spring.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyFirstSpringProjectApplication {

	private final AtomicLong  id =  new AtomicLong() ;
	private final String welcome = "Welcome to here ~  %s" ;
	
	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringProjectApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value="name",defaultValue="World") String name){
		return String.format("Hello %s!!", name);
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="content",required=false) String content) {
		return new Greeting(id.incrementAndGet() , String.format(welcome,content));
	}
	
}
