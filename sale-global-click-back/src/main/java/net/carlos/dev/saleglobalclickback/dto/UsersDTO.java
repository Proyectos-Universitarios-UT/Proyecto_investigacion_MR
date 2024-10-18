package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class UsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID idUser;

    private String nameUser;

    private String email;

    private String phone;

    private String role;

    private Date dateRegister;

}
