package net.carlos.dev.saleglobalclickback.vo;


import lombok.Data;
import net.carlos.dev.saleglobalclickback.entities.Notifications;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Date;

@Data
public class NotificationsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idNotification;

    private String message;

    private Date dateNotification;

    private String readNotification;

    private String idUser;

    public Specification<Notifications> toSpecification() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.and(
                    idNotification == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idNotification"), idNotification),
                    message == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("message"), message),
                    dateNotification == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("dateNotification"), dateNotification),
                    readNotification == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("readNotification"), readNotification),
                    idUser == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("idUser"), idUser)
            );
        };
    }

    public Pageable toPageable(int page, int size) {
        return Pageable.ofSize(size).withPage(page);
    }
}
