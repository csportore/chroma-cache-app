package br.com.chromatec.cache.professionals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalsService {
	
	private final ProfessionalsRepository professionalsRepository;
	
	public ProfessionalsService(
			@Autowired ProfessionalsRepository professionalsRepository) {
		this.professionalsRepository = professionalsRepository;
	}
	
	// CREATE
	public ProfessionalDTO insert(ProfessionalDTO dto) {
		return ProfessionalsMapper.INSTANCE.entityToDTO(
				this.professionalsRepository.save(ProfessionalsMapper.INSTANCE.dtoToEntity(dto, LocalDateTime.now())));
	}

	// READ
	public ProfessionalDTO findById(Long id) throws NoSuchElementException {
		return ProfessionalsMapper.INSTANCE.entityToDTO(
				this.professionalsRepository.findById(id).orElseThrow());
	}

	public List<ProfessionalDTO> findAll() {
		return ProfessionalsMapper.INSTANCE.entityListToDTOList(
				this.professionalsRepository.findAll());
	}

	// UPDATE
	public ProfessionalDTO update(ProfessionalDTO dto) {
		return ProfessionalsMapper.INSTANCE.entityToDTO(
				this.professionalsRepository.save(ProfessionalsMapper.INSTANCE.dtoToEntity(dto, LocalDateTime.now())));
	}
	
	// DELETE
	public void delete(Long id) {
		this.professionalsRepository.deleteById(id);
	}
}
