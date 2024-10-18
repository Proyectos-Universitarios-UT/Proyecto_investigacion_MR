package net.carlos.dev.saleglobalclickback.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrdersUpdateVO extends OrdersVO implements Serializable {
    private static final long serialVersionUID = 1L;
}