package br.com.chromatec.cache.patient;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.chromatec.cache.professional.Professional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
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
	
	@Column(nullable = false)
	private LocalDateTime registrationDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Professional professional;
}
