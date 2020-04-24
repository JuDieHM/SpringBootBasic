package com.banking.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class ControllerBasic {
	
	@RequestMapping()
	public String defecto() {
		return "Home Page";
	}
	
	@RequestMapping(value="/seccion")
	public String showGeneral(@RequestParam("seccion") String seccionPage) {
		System.out.println("La seccion es: " + seccionPage);
		return "Hello from seccion " + seccionPage;
	}
}
