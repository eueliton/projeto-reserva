package com.globoteste.reserva.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class HomeResources {

	@RequestMapping("/")
	public String home() {
		return ("Acesso Negado!");
	}
 
}

 
