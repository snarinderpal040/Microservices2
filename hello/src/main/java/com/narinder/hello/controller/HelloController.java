package com.narinder.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.narinder.hello.Models.HelloWorldBean;

@RestController
public class HelloController {
	
	@GetMapping("hello-world")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Hello World!!!");
	}
	
	@GetMapping("hello-world/pathvariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello world, " + name);
	}

}
