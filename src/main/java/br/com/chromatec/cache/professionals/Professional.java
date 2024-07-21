package br.com.chromatec.cache.professionals;

import java.io.Serializable;
import java.util.Objects;

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
public class Professional implements Serializable {
	
	/**
	 * The serial version UID
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
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professional")
//	private List<Patient> patients;

	public Professional() {}

	public Professional(Long id, String name, ProfessionalOptions profession) {
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Professional that = (Professional) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name) && profession == that.profession;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, profession);
	}
}
