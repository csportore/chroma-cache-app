package br.com.chromatec.cache.professionals;

import java.util.List;

import br.com.chromatec.cache.patients.Patient;

public class ProfessionalDTO {
	private Long id;
	private String name;
	private ProfessionalOptions profession;
	private List<Patient> patients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProfessionalOptions getProfession() {
		return profession;
	}

	public void setProfession(ProfessionalOptions profession) {
		this.profession = profession;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
