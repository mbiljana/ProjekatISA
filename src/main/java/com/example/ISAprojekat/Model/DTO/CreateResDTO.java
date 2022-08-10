package com.example.ISAprojekat.Model.DTO;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.RegKorisnik;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class CreateResDTO {
    private Integer id;
    private String resName;
    private Date startDate;
    private Date endDate;
    private Integer offerId;
    private Integer korId;
    private int duration;
}
