package br.com.chromatec.cache.professionals;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "professionals")
public class Professional implements Serializable{
	
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 8669041838179319866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ProfessionalOptions profession;

	@Column(nullable = false)
	private LocalDateTime registrationDateTime;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
//	private List<Patient> patients;

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

	public LocalDateTime getRegistrationDateTime() {
		return registrationDateTime;
	}

	public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}

	public ProfessionalOptions getProfession() {
		return profession;
	}

	public void setProfession(ProfessionalOptions profession) {
		this.profession = profession;
	}
	
}
