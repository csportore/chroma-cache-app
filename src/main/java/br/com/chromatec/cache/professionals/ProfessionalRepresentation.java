package br.com.chromatec.cache.professionals;

public class ProfessionalRepresentation {
	
	private final String name;
	private final ProfessionalOptions profession;
	
	public ProfessionalRepresentation(String name, ProfessionalOptions profession) {
		super();
		this.name = name;
		this.profession = profession;
	}

	public String getName() {
		return name;
	}

	public ProfessionalOptions getProfession() {
		return profession;
	}

}
