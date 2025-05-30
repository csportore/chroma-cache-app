package br.com.chromatec.cache.professionals;

import java.util.List;

import br.com.chromatec.cache.patients.PatientDTO;

public record ProfessionalDTO(Long id, String name, ProfessionalOptions profession, List<PatientDTO> patients) {
}
