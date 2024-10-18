package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idOrders;

    private Date dateOrder;

    private String stateOrder;

    private BigDecimal valueOrder;

    private String idClient;

}
