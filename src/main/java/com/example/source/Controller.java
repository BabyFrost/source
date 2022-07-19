package com.example.source;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/date")
	public String getDate(  ) {
		String response = "Nous sommes le "+ new Date();
		return response;
	}

}