package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idProducts;

    private String nameProduct;

    private String description;

    private BigDecimal price;

    private String imageUrl;

    private Date dateRegister;

    private String idSeller;

    private String idCategory;

}
