package br.com.chromatec.cache.professionals;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalsService {
	
	private ProfessionalsRepository repository;
	
	public ProfessionalsService(
			@Autowired ProfessionalsRepository repository) {
		this.repository = repository;
	}
	
	// CREATE
	public ProfessionalDTO insert(ProfessionalDTO professionalDTO) {
		return ProfessionalsMapper.INSTANCE.toDTO(this.repository.save(ProfessionalsMapper.INSTANCE.toEntity(professionalDTO)));
	}
	
	// READ
	public ProfessionalDTO findById(Long id) throws NoSuchElementException {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		return ProfessionalsMapper.INSTANCE.toDTO(this.repository.findById(id).orElseThrow());
	}

	public List<ProfessionalDTO> findAll() {
		return ProfessionalsMapper.INSTANCE.toDTOList(this.repository.findAll());
	}
	
	// UPDATE
	public ProfessionalDTO update(ProfessionalDTO professionalDTO) {
		return ProfessionalsMapper.INSTANCE.toDTO(this.repository.save(ProfessionalsMapper.INSTANCE.toEntity(professionalDTO)));
	}
	
	// DELETE
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
