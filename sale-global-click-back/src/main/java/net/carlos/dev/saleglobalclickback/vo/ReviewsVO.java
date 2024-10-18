package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class ReviewsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idReview;

    private String commentReview;

    private Long rate;

    @Nonnull
    private Date dateReview;

    @Nonnull
    private String idSeller;

}
