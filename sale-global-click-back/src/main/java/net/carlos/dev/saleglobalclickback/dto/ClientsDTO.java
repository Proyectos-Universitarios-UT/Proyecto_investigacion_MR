package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class ClientsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idClient;

    private String nameClient;

    private String lastNameClient;

    private String address;

    private Date birthdate;

    private String idUser;

}
