package br.com.chromatec.cache.professional;

import java.io.Serializable;
import java.util.List;

import br.com.chromatec.cache.patient.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Professional implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8669041838179319866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ProfessionalOptions profession;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
	private List<Patient> patients;
}
