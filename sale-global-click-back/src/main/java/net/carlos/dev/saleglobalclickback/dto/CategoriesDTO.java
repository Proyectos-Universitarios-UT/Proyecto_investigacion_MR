package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idCategory;

    private String nameCategory;

    private String description;

}
