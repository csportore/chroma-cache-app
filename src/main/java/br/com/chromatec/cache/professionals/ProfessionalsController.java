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
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ProfessionalRepresentation representation) {
		try {
			var dto = this.professionalsService.insert(ProfessionalsMapper.INSTANCE.toDTO(representation));
			return ResponseEntity.ok().body(ProfessionalsMapper.INSTANCE.toRepresentation(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - POST");
		}
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(ProfessionalsMapper.INSTANCE.toRepresentationList(
					this.professionalsService.findAll()));
		} catch (NoSuchElementException nsee) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - GET ALL");
		}
	}
	
	@GetMapping("/{id}")
	@Cacheable("professionals-cache")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(ProfessionalsMapper.INSTANCE.toRepresentation(
					this.professionalsService.findById(id)));
		} catch (NoSuchElementException nsee) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records found for " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - GET");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProfessionalRepresentation representation) {
		try {
			var dto = this.professionalsService.update(id, ProfessionalsMapper.INSTANCE.toDTO(representation));
			return ResponseEntity.ok().body(ProfessionalsMapper.INSTANCE.toRepresentation(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - PUT");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			this.professionalsService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Professional with id: " + id + " was deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - DELETE");
		}
	}
	

}
