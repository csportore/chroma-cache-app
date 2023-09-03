package br.com.chromatec.cache.professionals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalsRepository extends JpaRepository<Professional, Long> {

}
