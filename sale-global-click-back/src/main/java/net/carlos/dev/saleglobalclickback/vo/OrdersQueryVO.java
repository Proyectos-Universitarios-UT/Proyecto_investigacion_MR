package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Orders;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idOrders;

    private Date dateOrder;

    private String stateOrder;

    private BigDecimal valueOrder;

    private String idClient;

    public Specification<Orders> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idOrders == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idOrders"), idOrders),
                    dateOrder == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("dateOrder"), dateOrder),
                    stateOrder == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("stateOrder"), stateOrder),
                    valueOrder == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("valueOrder"), valueOrder),
                    idClient == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idClient"), idClient)
            );
        };
    }

    public Pageable toPageable(int page, int size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
