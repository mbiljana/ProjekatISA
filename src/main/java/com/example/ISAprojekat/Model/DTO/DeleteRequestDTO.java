package com.example.ISAprojekat.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRequestDTO {
    private Integer id;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String phoneNumber;
    private String role;
    private String reason;


}
