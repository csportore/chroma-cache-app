package br.com.chromatec.cache.professionals;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionalsMapper {
	
	ProfessionalsMapper INSTANCE = Mappers.getMapper(ProfessionalsMapper.class);
	
	ProfessionalDTO toDTO(Professional p);
	ProfessionalDTO toDTO(ProfessionalRegistrationVO p);
	
	Professional toEntity(ProfessionalDTO p);
	
	List<ProfessionalDTO> toDTOList(List<Professional> p);
	List<Professional> toEntityList(List<ProfessionalDTO> p);
}
