package br.com.chromatec.cache.professionals;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.chromatec.cache.patients.Patient;
import jakarta.persistence.*;

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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "professionals_patients",
			joinColumns = @JoinColumn(name = "professional_id"),
			inverseJoinColumns = @JoinColumn(name = "patient_id")
	)
	private List<Patient> patients;

	@Column(nullable = false)
	private LocalDateTime lastUpdated;

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

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
