package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idOrderDetail;

    private String idOrders;

    private String idProducts;

    private Long quantityProduct;

    private BigDecimal prizeProduct;

}
