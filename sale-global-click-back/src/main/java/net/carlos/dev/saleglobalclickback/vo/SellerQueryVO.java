package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Seller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.sql.Date;

@Data
public class SellerQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idSeller;

    private String nameSeller;

    private String lastNameSeller;

    private String addressSeller;

    private Date birthdate;

    private String idUser;

    public Specification<Seller> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idSeller == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idSeller"), idSeller),
                    nameSeller == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("nameSeller"), nameSeller),
                    lastNameSeller == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("lastNameSeller"), lastNameSeller),
                    addressSeller == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("addressSeller"), addressSeller),
                    birthdate == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("birthdate"), birthdate),
                    idUser == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idUser"), idUser)
            );
        };
    }

    public Pageable toPageable(Integer page, Integer size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
