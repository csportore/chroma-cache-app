package br.com.chromatec.cache.patients;

import br.com.chromatec.cache.shared.CustomMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientsMapper extends CustomMapper<PatientDTO, Patient, PatientRepresentation, Long> {
	
	PatientsMapper INSTANCE = Mappers.getMapper(PatientsMapper.class);

}
