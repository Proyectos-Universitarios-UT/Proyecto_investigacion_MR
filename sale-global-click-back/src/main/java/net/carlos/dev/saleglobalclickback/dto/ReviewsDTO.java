package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReviewsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idReview;

    private String commentReview;

    private Long rate;

    private Date dateReview;

    private String idSeller;

}
