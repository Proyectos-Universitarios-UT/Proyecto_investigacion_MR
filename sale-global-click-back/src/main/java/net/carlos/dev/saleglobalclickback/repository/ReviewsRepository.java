package net.carlos.dev.saleglobalclickback.repository;

import net.carlos.dev.saleglobalclickback.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReviewsRepository extends JpaRepository<Reviews, String>, JpaSpecificationExecutor<Reviews> {

}