package net.carlos.dev.saleglobalclickback.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "reviews")
public class Reviews implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_review", nullable = false)
    private UUID idReview;

    @Column(name = "comment_review")
    private String commentReview;

    @Column(name = "rate")
    private Long rate;

    @Column(name = "date_review", nullable = false)
    private Date dateReview;

    @Column(name = "id_seller", nullable = false)
    private String idSeller;

}
