package com.example.jenkins_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/jenkins")
public class JenkinsSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsSampleApplication.class, args);
	}


	@GetMapping("/sample")
	public String sample(){
		return "Spring Boot app deployed using jenkins";
	}

}
