package net.carlos.dev.saleglobalclickback.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class NotificationsUpdateVO extends NotificationsVO implements Serializable {
    private static final long serialVersionUID = 1L;
}
