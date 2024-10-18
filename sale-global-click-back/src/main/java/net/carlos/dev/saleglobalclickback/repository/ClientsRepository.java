package net.carlos.dev.saleglobalclickback.repository;

import net.carlos.dev.saleglobalclickback.entities.Clients;
import net.carlos.dev.saleglobalclickback.vo.ClientsQueryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID>, JpaSpecificationExecutor<Clients> {
}