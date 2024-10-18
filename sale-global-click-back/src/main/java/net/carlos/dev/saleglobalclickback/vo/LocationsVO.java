package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class LocationsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idLocation;

    @Nonnull
    private Double latitude;

    @Nonnull
    private Double length;

    @Nonnull
    private Date dateLocation;

    @Nonnull
    private String idSeller;

}
