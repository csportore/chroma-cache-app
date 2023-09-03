package br.com.chromatec.cache.patients;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientsController {
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok("Get All: @" + LocalDateTime.now());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOneById(@PathVariable("id") Long id) {
		return ResponseEntity.ok("User ID: " + id + " @" + LocalDateTime.now());
	}
	
	@PostMapping
	public ResponseEntity<?> insert() {
		return ResponseEntity.noContent().build();
	}
}
