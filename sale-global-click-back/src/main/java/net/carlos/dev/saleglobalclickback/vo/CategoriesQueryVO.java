package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import net.carlos.dev.saleglobalclickback.entities.Categories;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoriesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idCategory;

    private String nameCategory;

    private String description;

    public Specification<Categories> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            if (idCategory != null) {
                return criteriaBuilder.equal(root.get("idCategory"), idCategory);
            }
            if (nameCategory != null) {
                return criteriaBuilder.like(root.get("nameCategory"), "%" + nameCategory + "%");
            }
            if (description != null) {
                return criteriaBuilder.like(root.get("description"), "%" + description + "%");
            }
            return null;
        };
    }
}
