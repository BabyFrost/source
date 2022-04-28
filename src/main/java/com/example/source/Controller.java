package com.example.source;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/date")
	public String getDate(  ) {
		String response = " Source responds with "+ new Date();
		return response;
	}

}
