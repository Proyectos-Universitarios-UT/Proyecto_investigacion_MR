package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OrderDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idOrderDetail;

    @Nonnull
    private String idOrders;

    @Nonnull
    private String idProducts;

    @Nonnull
    private Long quantityProduct;

    @Nonnull
    private BigDecimal prizeProduct;

}
