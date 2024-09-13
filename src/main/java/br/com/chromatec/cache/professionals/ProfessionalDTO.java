package br.com.chromatec.cache.professionals;

import java.util.List;

import br.com.chromatec.cache.patients.Patient;

public record ProfessionalDTO(Long id, String name, ProfessionalOptions profession, List<Patient> patients) {
}
