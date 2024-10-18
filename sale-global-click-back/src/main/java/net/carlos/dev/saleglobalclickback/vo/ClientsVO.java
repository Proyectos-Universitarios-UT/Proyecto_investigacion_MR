package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.sql.Date;



@Data
@NoArgsConstructor
public class ClientsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idClient;

    @Nonnull
    private String nameClient;

    @Nonnull
    private String lastNameClient;

    @Nonnull
    private String address;

    private Date birthdate;

    @Nonnull
    private String idUser;

}
