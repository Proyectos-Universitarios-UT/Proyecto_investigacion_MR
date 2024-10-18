package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
public class SellerVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idSeller;

    @Nonnull
    private String nameSeller;

    @Nonnull
    private String lastNameSeller;

    @Nonnull
    private String addressSeller;

    private Date birthdate;

    @Nonnull
    private String idUser;

}
