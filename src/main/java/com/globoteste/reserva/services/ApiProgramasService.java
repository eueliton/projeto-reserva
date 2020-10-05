package com.globoteste.reserva.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiProgramasService {

	public String getAllIds() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://127.0.0.1:8080/programa/allId";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		return response.getBody();
	}

}
