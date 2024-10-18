package net.carlos.dev.saleglobalclickback.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LocationsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idLocation;

    private Double latitude;

    private Double length;

    private Date dateLocation;

    private String idSeller;

}
