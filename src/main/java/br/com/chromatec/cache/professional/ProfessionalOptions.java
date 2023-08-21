package br.com.chromatec.cache.professional;

public enum ProfessionalOptions {
	NUTRITIONIST ("Nutritionist"),
	DIETITIAN ("Dietitian");
	
	private String name;
	
	private ProfessionalOptions(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
 }
