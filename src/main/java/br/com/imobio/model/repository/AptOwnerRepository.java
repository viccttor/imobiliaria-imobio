package br.com.imobio.model.repository;

import br.com.imobio.model.entity.AptOwner;
import br.com.imobio.model.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptOwnerRepository extends JpaRepository<AptOwner, Long> {
}