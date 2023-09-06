package br.com.chromatec.cache.patients;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientsService {
	
	private PatientsRepository patientsRepository;
	
	public PatientsService(
			@Autowired PatientsRepository patientsRepository) {
		this.patientsRepository = patientsRepository;
	}

	public PatientDTO insert(PatientDTO dto) {
		dto.setRegistrationDateTime(LocalDateTime.now());
		return PatientsMapper.INSTANCE.toDTO(
				this.patientsRepository.save(PatientsMapper.INSTANCE.toEntity(dto)));
	}

	public List<PatientDTO> findAll() {
		return PatientsMapper.INSTANCE.toDTOList(this.patientsRepository.findAll());
	}

	public PatientDTO findById(Long id) throws NoSuchElementException {   
		return PatientsMapper.INSTANCE.toDTO(
				this.patientsRepository.findById(id).orElseThrow());
	}

	public PatientDTO update(Long id, PatientDTO dto) {
		dto.setId(id);
		dto.setRegistrationDateTime(LocalDateTime.now());
		return PatientsMapper.INSTANCE.toDTO(
				this.patientsRepository.save(PatientsMapper.INSTANCE.toEntity(dto)));
	}

	public void delete(Long id) {
		this.patientsRepository.deleteById(id);
	}
	
	

}
