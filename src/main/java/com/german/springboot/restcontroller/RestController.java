package com.german.springboot.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/")	
	public ResponseEntity<String> hello(){
		return new ResponseEntity<String>("Hello, Welcome to Rest Controller Api	",HttpStatus.ACCEPTED);
	}
	
}
