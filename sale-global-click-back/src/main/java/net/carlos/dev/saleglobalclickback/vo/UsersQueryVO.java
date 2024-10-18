package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsersQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idUser;

    private String nameUser;

    private String email;

    private String phone;

    private String role;

    private Date dateRegister;

    public Specification<Users> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idUser == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idUser"), idUser),
                    nameUser == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("nameUser"), nameUser),
                    email == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("email"), email),
                    phone == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("phone"), phone),
                    role == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("role"), role),
                    dateRegister == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("dateRegister"), dateRegister)
            );
        };
    }

    public Pageable toPageable() {
        return Pageable.unpaged();
    }
}
