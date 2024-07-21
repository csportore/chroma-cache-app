package br.com.chromatec.cache.professionals;

import br.com.chromatec.cache.shared.CommonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

// RestController is not @Inherited
@RequestMapping(value = "/professionals", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfessionalsController extends
		CommonController<ProfessionalDTO, ProfessionalRepresentation, Professional, Long> {

	public ProfessionalsController(@Autowired ProfessionalsService service) {
		super(ProfessionalsMapper.INSTANCE, service);
	}
}
