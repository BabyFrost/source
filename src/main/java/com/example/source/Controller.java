package com.example.source;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/date")
	public String getDate(  ) {
		String response = " Service Indisponible ";
		return response;
	}
	
	@GetMapping("/**")
	public String redirectToGetDate(  ) {
		return "Hello world";
	}

}