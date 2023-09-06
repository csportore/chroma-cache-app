package br.com.chromatec.cache.patients;

public class PatientRepresentation {
	
	private String name;
	private String documentNumber;
	
	public PatientRepresentation(String name, String documentNumber) {
		this.name = name;
		this.documentNumber = documentNumber;
	}

	public String getName() {
		return name;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}	
	
}
