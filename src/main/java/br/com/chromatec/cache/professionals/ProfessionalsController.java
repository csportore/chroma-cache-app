package br.com.chromatec.cache.professionals;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professionals", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfessionalsController {
	
	private ProfessionalsService professionalsService;
	
	public ProfessionalsController(@Autowired ProfessionalsService professionalsService) {
		this.professionalsService = professionalsService;
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(this.professionalsService.findAll());
	}
	
	@GetMapping("/{id}")
	@Cacheable("professionals-cache")
	public ResponseEntity<?> findOneById(@PathVariable("id") Long id) {
		return ResponseEntity.ok("User ID: " + id + " @" + LocalDateTime.now());
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ProfessionalRegistrationVO vo) {
		this.professionalsService.insert(ProfessionalsMapper.INSTANCE.toDTO(vo));
		return ResponseEntity.ok("Professional " + vo.getName() + " was registered.");
	}
}
