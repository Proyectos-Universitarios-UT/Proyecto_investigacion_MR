package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class NotificationsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idNotification;

    private String message;

    private Date dateNotification;

    private String readNotification;

    private String idUser;

}
