package net.carlos.dev.saleglobalclickback.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_order_detail", nullable = false)
    private UUID idOrderDetail;

    @Column(name = "id_orders", nullable = false)
    private String idOrders;

    @Column(name = "id_products", nullable = false)
    private String idProducts;

    @Column(name = "quantity_product", nullable = false)
    private Long quantityProduct;

    @Column(name = "prize_product", nullable = false)
    private BigDecimal prizeProduct;

}
