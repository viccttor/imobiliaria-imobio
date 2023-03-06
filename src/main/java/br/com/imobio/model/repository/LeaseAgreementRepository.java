package br.com.imobio.model.repository;

import br.com.imobio.model.entity.LeaseAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseAgreementRepository extends JpaRepository<LeaseAgreement, Long> {
}