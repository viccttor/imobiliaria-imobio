package br.com.imobio.model.repository;

import br.com.imobio.model.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

}