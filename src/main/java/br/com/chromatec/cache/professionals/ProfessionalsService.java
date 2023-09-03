package br.com.chromatec.cache.professionals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalsService {
	
	private ProfessionalsRepository professionalsRepository;
	
	public ProfessionalsService(
			@Autowired ProfessionalsRepository professionalsRepository) {
		
		this.professionalsRepository = professionalsRepository;
	}

	public List<ProfessionalDTO> findAll() {
		return ProfessionalsMapper.INSTANCE.toDTOList(professionalsRepository.findAll());
	}
	
	public void insert(ProfessionalDTO professionalDTO) {
		this.professionalsRepository.save(ProfessionalsMapper.INSTANCE.toEntity(professionalDTO));
	}
}
