package br.com.chromatec.cache.professional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class ProfessionalController {
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneById() {
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> postPatient() {
		return ResponseEntity.noContent().build();
	}
}
