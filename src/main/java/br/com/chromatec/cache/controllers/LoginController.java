package br.com.chromatec.cache.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public ResponseEntity<?> processDefault() {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping
	public ResponseEntity<String> processLogin(@RequestParam("user") String user, 
			@RequestParam("password") String password) {
		
		return ResponseEntity.ok("User " + user + " logged at " + LocalDateTime.now());
	}
}
