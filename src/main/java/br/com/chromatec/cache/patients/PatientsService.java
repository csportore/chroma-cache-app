package br.com.chromatec.cache.patients;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientsService {
	
	private final PatientsRepository patientsRepository;
	
	public PatientsService(
			@Autowired PatientsRepository patientsRepository) {
		this.patientsRepository = patientsRepository;
	}

	public PatientDTO insert(PatientDTO dto) {
		var entity = this.patientsRepository.save(PatientsMapper.INSTANCE.dtoToEntity(dto, LocalDateTime.now()));
		return PatientsMapper.INSTANCE.entityToDTO(entity);
	}

	public List<PatientDTO> findAll() {
		return PatientsMapper.INSTANCE.entityListToDTOList(this.patientsRepository.findAll());
	}

	public PatientDTO findById(Long id) throws NoSuchElementException {
		var entity = this.patientsRepository.findById(id).orElseThrow();
		return PatientsMapper.INSTANCE.entityToDTO(entity, id);
	}

	public PatientDTO update(PatientDTO dto) {
		var entity = this.patientsRepository.save(PatientsMapper.INSTANCE.dtoToEntity(dto, LocalDateTime.now()));
		return PatientsMapper.INSTANCE.entityToDTO(entity);
	}

	public void delete(Long id) {
		this.patientsRepository.deleteById(id);
	}
	
	

}
