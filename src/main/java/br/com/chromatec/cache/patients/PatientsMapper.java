package br.com.chromatec.cache.patients;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientsMapper {
	
	PatientsMapper INSTANCE = Mappers.getMapper(PatientsMapper.class);
	
	PatientDTO toDTO(Patient p);
	List<PatientDTO> toDTOList(Iterable<Patient> p);
	PatientDTO toDTO(PatientRepresentation p);
	List<PatientDTO> toDTOList(List<PatientRepresentation> p);
	
	PatientRepresentation toRepresentation(PatientDTO p);
	List<PatientRepresentation> toRepresentationList(List<PatientDTO> p);
	
	Patient toEntity(PatientDTO p);
	List<Patient> toEntityList(Iterable<PatientDTO> p);
}
