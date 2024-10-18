package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class ProductsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idProducts;

    @Nonnull
    private String nameProduct;

    @Nonnull
    private String description;

    @Nonnull
    private BigDecimal price;

    private String imageUrl;

    @Nonnull
    private Date dateRegister;

    @Nonnull
    private String idSeller;

    private String idCategory;

}
