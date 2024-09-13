package br.com.chromatec.cache.professionals;

import br.com.chromatec.cache.shared.CustomMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionalsMapper extends CustomMapper<ProfessionalDTO, Professional, ProfessionalRepresentation, Long> {
	
	ProfessionalsMapper INSTANCE = Mappers.getMapper(ProfessionalsMapper.class);

}
