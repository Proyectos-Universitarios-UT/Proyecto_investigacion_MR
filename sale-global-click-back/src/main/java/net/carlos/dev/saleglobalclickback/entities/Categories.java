package net.carlos.dev.saleglobalclickback.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

/**
 * $table.getTableComment()
 */
@Data
@Entity
@Accessors(chain = true)
@Table(name = "categories")
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_category", nullable = false)
    private UUID idCategory;

    @Column(name = "name_category", nullable = false)
    private String nameCategory;

    @Column(name = "description")
    private String description;

}
