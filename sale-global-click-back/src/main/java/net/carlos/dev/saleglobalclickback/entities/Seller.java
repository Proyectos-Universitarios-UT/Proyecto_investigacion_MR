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
@Table(name = "seller")
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_seller", nullable = false)
    private UUID idSeller;

    @Column(name = "name_seller", nullable = false)
    private String nameSeller;

    @Column(name = "last_name_seller", nullable = false)
    private String lastNameSeller;

    @Column(name = "address_seller", nullable = false)
    private String addressSeller;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "id_user", nullable = false)
    private String idUser;

}
