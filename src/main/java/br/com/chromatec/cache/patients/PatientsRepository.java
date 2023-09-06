package br.com.chromatec.cache.patients;

import org.springframework.data.repository.CrudRepository;

public interface PatientsRepository extends CrudRepository<Patient, Long> {

}
