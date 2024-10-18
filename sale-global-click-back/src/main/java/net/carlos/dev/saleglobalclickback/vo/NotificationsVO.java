package net.carlos.dev.saleglobalclickback.vo;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class NotificationsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Nonnull
    private String idNotification;

    @Nonnull
    private String message;

    @Nonnull
    private Date dateNotification;

    @Nonnull
    private String readNotification;

    @Nonnull
    private String idUser;

}
