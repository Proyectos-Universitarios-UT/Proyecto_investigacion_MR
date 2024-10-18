package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Reviews;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReviewsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idReview;

    private String commentReview;

    private Long rate;

    private Date dateReview;

    private String idSeller;

    public Specification<Reviews> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idReview == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idReview"), idReview),
                    commentReview == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("commentReview"), commentReview),
                    rate == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("rate"), rate),
                    dateReview == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("dateReview"), dateReview),
                    idSeller == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idSeller"), idSeller)
            );
        };
    }

    public Pageable toPageable(Integer page, Integer size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
