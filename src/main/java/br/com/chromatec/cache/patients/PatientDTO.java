package br.com.chromatec.cache.patients;

import java.time.LocalDateTime;

public record PatientDTO (Long id, String name, String documentNumber, LocalDateTime registrationDateTime) { }
