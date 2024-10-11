package br.com.chromatec.cache.patients;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import br.com.chromatec.cache.professionals.Professional;
import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6146177693922439079L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String name;

	@Column(nullable = false, length = 11)
	private String documentNumber;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "patients", cascade = CascadeType.ALL)
	private List<Professional> professionals;

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

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public List<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
