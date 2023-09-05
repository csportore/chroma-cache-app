package br.com.chromatec.cache.professionals;

import java.io.Serializable;

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

//	public List<Patient> getPatients() {
//		return patients;
//	}
//
//	public void setPatients(List<Patient> patients) {
//		this.patients = patients;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name, patients, profession);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Professional other = (Professional) obj;
//		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
//				&& Objects.equals(patients, other.patients) && profession == other.profession;
//	}
//
//	@Override
//	public String toString() {
//		return "Professional [id=" + id + ", name=" + name + ", profession=" + profession + ", patients=" + patients
//				+ "]";
//	}
	
}
