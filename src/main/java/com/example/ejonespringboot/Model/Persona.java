package com.example.ejonespringboot.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    private String ubication;
    private String position;
    private String fullName;
    private String image;
    private String user;
    private String password;

    public Persona(Long id, String ubication, String position, String fullName,
                   String image, String user, String password) {
        this.id = id;
        this.ubication = ubication;
        this.position = position;
        this.fullName = fullName;
        this.image = image;
        this.user = user;
        this.password = password;
    }

    public Persona(){}


}
