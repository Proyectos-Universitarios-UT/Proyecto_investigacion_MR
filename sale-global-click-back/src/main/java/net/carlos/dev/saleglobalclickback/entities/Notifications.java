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
@Table(name = "notifications")
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_notification", nullable = false)
    private UUID idNotification;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "date_notification", nullable = false)
    private Date dateNotification;

    @Column(name = "read_notification", nullable = false)
    private String readNotification;

    @Column(name = "id_user", nullable = false)
    private String idUser;

}
