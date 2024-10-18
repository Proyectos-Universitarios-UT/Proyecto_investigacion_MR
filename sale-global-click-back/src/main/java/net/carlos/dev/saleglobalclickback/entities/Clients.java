package net.carlos.dev.saleglobalclickback.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "clients")
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_client", nullable = false)
    private UUID idClient;

    @Column(name = "name_client", nullable = false)
    private String nameClient;

    @Column(name = "last_name_client", nullable = false)
    private String lastNameClient;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "id_user", nullable = false)
    private String idUser;

}
