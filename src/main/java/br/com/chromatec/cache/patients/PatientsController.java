package br.com.chromatec.cache.patients;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

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

	private final Logger LOGGER = Logger.getLogger(PatientsController.class.getName());
	private final PatientsService patientsService;

	public PatientsController(@Autowired PatientsService patientsService) {
		this.patientsService = patientsService;
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody PatientRepresentation representation) {
		try {
			var dto = this.patientsService.insert(PatientsMapper.INSTANCE.representationToDTO(null, representation));
			return ResponseEntity
					.ok().body(PatientsMapper.INSTANCE.dtoToRepresentation(dto));
		} catch (Exception e) {
			LOGGER. severe(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - POST");
		}
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity
					.ok(PatientsMapper.INSTANCE.dtoToRepresentationList(this.patientsService.findAll()));
		} catch (NoSuchElementException nsee) {
			LOGGER. severe(nsee.getMessage());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records found");
		} catch (Exception e) {
			LOGGER. severe(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - GET ALL");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity
					.ok(PatientsMapper.INSTANCE.dtoToRepresentation(this.patientsService.findById(id)));
		} catch (NoSuchElementException nsee) {
			LOGGER. severe(nsee.getMessage());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No records found for " + id);
		} catch (Exception e) {
			LOGGER. severe(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - GET");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,
			@RequestBody PatientRepresentation representation) {
		try {
			var dto = this.patientsService.update(PatientsMapper.INSTANCE.representationToDTO(id, representation));
			return ResponseEntity
					.ok().body(PatientsMapper.INSTANCE.dtoToRepresentation(dto));
		} catch (Exception e) {
			LOGGER. severe(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - PUT");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			this.patientsService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Professional with id: " + id + " was deleted.");
		} catch (Exception e) {
			LOGGER. severe(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("OMG - DELETE");
		}
	}
}
