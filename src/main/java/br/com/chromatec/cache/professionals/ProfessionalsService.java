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
	
	public ProfessionalDTO findById(Long id) throws NoSuchElementException {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		return ProfessionalsMapper.INSTANCE.toDTO(this.repository.findById(id).orElseThrow());
	}

	public List<ProfessionalDTO> findAll() {
		return ProfessionalsMapper.INSTANCE.toDTOList(this.repository.findAll());
	}
	
	public void insert(ProfessionalDTO professionalDTO) {
		this.repository.save(ProfessionalsMapper.INSTANCE.toEntity(professionalDTO));
	}
	  
	public ProfessionalDTO update(Long id, ProfessionalDTO professionalDTO) {
		var dto = this.repository.save(ProfessionalsMapper.INSTANCE.toEntity(professionalDTO));
		dto.setId(id);
		return ProfessionalsMapper.INSTANCE.toDTO(dto);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
