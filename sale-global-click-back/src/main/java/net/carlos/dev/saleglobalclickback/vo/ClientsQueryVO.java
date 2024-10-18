package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import net.carlos.dev.saleglobalclickback.entities.Clients;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class ClientsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idClient;

    private String nameClient;

    private String lastNameClient;

    private String address;

    private Date birthdate;

    private String idUser;

    public Specification<Clients> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idClient == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idClient"), idClient),
                    nameClient == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("nameClient"), nameClient),
                    lastNameClient == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("lastNameClient"), lastNameClient),
                    address == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("address"), address),
                    birthdate == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("birthdate"), birthdate),
                    idUser == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idUser"), idUser)
            );
        };
    }
}
