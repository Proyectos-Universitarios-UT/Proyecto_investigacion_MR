package net.carlos.dev.saleglobalclickback.repository;

import net.carlos.dev.saleglobalclickback.entities.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationsRepository extends JpaRepository<Locations, String>, JpaSpecificationExecutor<Locations> {

}