package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CategoriesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idCategory;

    @Nonnull
    private String nameCategory;

    private String description;

}
