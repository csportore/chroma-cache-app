package br.com.chromatec.cache.professionals;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalsService {
	
	private ProfessionalsRepository professionalsRepository;
	
	public ProfessionalsService(
			@Autowired ProfessionalsRepository professionalsRepository) {
		this.professionalsRepository = professionalsRepository;
	}
	
	// CREATE
	public ProfessionalDTO insert(ProfessionalDTO dto) {
		return ProfessionalsMapper.INSTANCE.toDTO(
				this.professionalsRepository.save(ProfessionalsMapper.INSTANCE.toEntity(dto)));
	}
	
	// READ
	public ProfessionalDTO findById(Long id) throws NoSuchElementException {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		return ProfessionalsMapper.INSTANCE.toDTO(
				this.professionalsRepository.findById(id).orElseThrow());
	}

	public List<ProfessionalDTO> findAll() {
		return ProfessionalsMapper.INSTANCE.toDTOList(
				this.professionalsRepository.findAll());
	}
	
	// UPDATE
	public ProfessionalDTO update(Long id, ProfessionalDTO dto) {
		dto.setId(id);
		return ProfessionalsMapper.INSTANCE.toDTO(
				this.professionalsRepository.save(ProfessionalsMapper.INSTANCE.toEntity(dto)));
	}
	
	// DELETE
	public void delete(Long id) {
		this.professionalsRepository.deleteById(id);
	}
}
