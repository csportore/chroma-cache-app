package br.com.chromatec.cache.professionals;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionalsMapper {
	
	ProfessionalsMapper INSTANCE = Mappers.getMapper(ProfessionalsMapper.class);
	
	ProfessionalDTO toDTO(Professional p);
	List<ProfessionalDTO> toDTOList(Iterable<Professional> p);
	ProfessionalDTO toDTO(ProfessionalRepresentation p);
	List<ProfessionalDTO> toDTOList(List<ProfessionalRepresentation> p);
	
	ProfessionalRepresentation toRepresentation(ProfessionalDTO p);
	List<ProfessionalRepresentation> toRepresentationList(List<ProfessionalDTO> p);
	
	Professional toEntity(ProfessionalDTO p);
	List<Professional> toEntityList(Iterable<ProfessionalDTO> p);
}
