package br.com.chromatec.cache.patients;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientsController {

	private PatientsService patientsService;

	public PatientsController(@Autowired PatientsService patientsService) {
		this.patientsService = patientsService;
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody PatientRepresentation representation) {
		try {
			var dto = this.patientsService.insert(PatientsMapper.INSTANCE.toDTO(representation));
			return ResponseEntity
					.ok().body(PatientsMapper.INSTANCE.toRepresentation(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - POST");
		}
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity
					.ok(PatientsMapper.INSTANCE.toRepresentationList(this.patientsService.findAll()));
		} catch (NoSuchElementException nsee) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records found");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - GET ALL");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity
					.ok(PatientsMapper.INSTANCE.toRepresentation(this.patientsService.findById(id)));
		} catch (NoSuchElementException nsee) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records found for " + id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - GET");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,
			@RequestBody PatientRepresentation representation) {
		try {
			var dto = this.patientsService.update(id, PatientsMapper.INSTANCE.toDTO(representation));
			return ResponseEntity
					.ok().body(PatientsMapper.INSTANCE.toRepresentation(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - PUT");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			this.patientsService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Professional with id: " + id + " was deleted.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - DELETE");
		}
	}
}
