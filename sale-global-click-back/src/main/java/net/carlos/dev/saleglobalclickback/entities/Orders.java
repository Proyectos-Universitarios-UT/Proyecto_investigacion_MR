package net.carlos.dev.saleglobalclickback.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_orders", nullable = false)
    private UUID idOrders;

    @Column(name = "date_order", nullable = false)
    private Date dateOrder;

    @Column(name = "state_order", nullable = false)
    private String stateOrder;

    @Column(name = "value_order")
    private BigDecimal valueOrder;

    @Column(name = "id_client", nullable = false)
    private String idClient;

}
