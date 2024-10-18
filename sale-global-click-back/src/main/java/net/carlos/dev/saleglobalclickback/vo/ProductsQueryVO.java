package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idProducts;

    private String nameProduct;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private Date dateRegister;

    private String idSeller;

    private String idCategory;

    public Specification<Products> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idProducts == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idProducts"), idProducts),
                    nameProduct == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("nameProduct"), nameProduct),
                    description == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("description"), description),
                    price == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("price"), price),
                    imageUrl == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("imageUrl"), imageUrl),
                    dateRegister == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("dateRegister"), dateRegister),
                    idSeller == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idSeller"), idSeller),
                    idCategory == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idCategory"), idCategory)
            );
        };
    }

    public Pageable toPageable(int page, int size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
