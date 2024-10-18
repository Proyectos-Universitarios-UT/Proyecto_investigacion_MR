package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.OrderDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderDetailQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idOrderDetail;

    private String idOrders;

    private String idProducts;

    private Long quantityProduct;

    private BigDecimal prizeProduct;

    public Specification<OrderDetail> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idOrderDetail == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idOrderDetail"), idOrderDetail),
                    idOrders == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idOrders"), idOrders),
                    idProducts == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idProducts"), idProducts),
                    quantityProduct == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("quantityProduct"), quantityProduct),
                    prizeProduct == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("prizeProduct"), prizeProduct)
            );
        };
    }

    public Pageable toPageable(int page, int size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
