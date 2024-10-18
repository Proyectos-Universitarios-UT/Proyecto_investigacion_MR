package net.carlos.dev.saleglobalclickback.repository;

import net.carlos.dev.saleglobalclickback.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsRepository extends JpaRepository<Products, String>, JpaSpecificationExecutor<Products> {

}