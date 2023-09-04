package br.com.chromatec.cache.professionals;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(this.professionalsService.findById(id));
		} catch (NoSuchElementException nsee) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(nsee.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ProfessionalRepresentation representation) {
		this.professionalsService.insert(
				ProfessionalsMapper.INSTANCE.toDTO(representation));
		return ResponseEntity.ok("Professional " + representation.getName() + " was registered.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProfessionalRepresentation representation) {
		return ResponseEntity.ok(
				this.professionalsService.update(id,
				ProfessionalsMapper.INSTANCE.toDTO(representation)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		this.professionalsService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Professional with id: " + id + " was deleted.");
	}
	

}
