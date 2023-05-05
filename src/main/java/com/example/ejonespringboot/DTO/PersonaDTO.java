package com.example.ejonespringboot.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    Long id;
    private String ubication;
    private String position;
    private String fullName;
    private String image;


}
