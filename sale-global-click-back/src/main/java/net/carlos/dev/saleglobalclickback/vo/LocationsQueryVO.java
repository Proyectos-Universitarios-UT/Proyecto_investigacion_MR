package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Locations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Date;

@Data
public class LocationsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idLocation;

    private Double latitude;

    private Double length;

    private Date dateLocation;

    private String idSeller;

    public Specification<Locations> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and();
        };
    }

    public Pageable toPageable(Integer page, Integer size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
