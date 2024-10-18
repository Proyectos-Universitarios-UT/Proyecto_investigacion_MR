package net.carlos.dev.saleglobalclickback.vo;
import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrdersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idOrders;

    @Nonnull
    private Date dateOrder;

    @Nonnull
    private String stateOrder;

    private BigDecimal valueOrder;

    @Nonnull
    private String idClient;

}
