package br.com.chromatec.cache.professionals;

import java.util.NoSuchElementException;

import br.com.chromatec.cache.shared.CommonService;
import br.com.chromatec.cache.shared.CommonServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalsService extends CommonService<ProfessionalDTO, Professional, Long> {

	public ProfessionalsService(@Autowired ProfessionalsRepository repository) {
		super(ProfessionalsMapper.INSTANCE, repository);
	}

}
