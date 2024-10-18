package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idSeller;

    private String nameSeller;

    private String lastNameSeller;

    private String addressSeller;

    private Date birthdate;

    private String idUser;

}
