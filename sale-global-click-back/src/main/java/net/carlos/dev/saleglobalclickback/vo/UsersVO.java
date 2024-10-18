package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class UsersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idUser;

    @Nonnull
    private String nameUser;

    @Nonnull
    private String email;

    @Nonnull
    private String phone;

    @Nonnull
    private String role;

    @Nonnull
    private Date dateRegister;

}
