package com.example.ejonespringboot.Repository;

import com.example.ejonespringboot.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona,Long> {

        public Persona findByUserAndPassword(String user, String Password);

}
