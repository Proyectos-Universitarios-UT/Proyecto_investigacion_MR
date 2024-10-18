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
@Table(name = "locations")
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_location", nullable = false)
    private UUID idLocation;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "length", nullable = false)
    private Double length;

    @Column(name = "date_location", nullable = false)
    private Date dateLocation;

    @Column(name = "id_seller", nullable = false)
    private String idSeller;

}
