package com.example.ejonespringboot.Service;


import com.example.ejonespringboot.DTO.PersonaDTO;
import com.example.ejonespringboot.Model.Persona;
import com.example.ejonespringboot.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    public Persona crearPersona(Persona persona){

        return personaRepo.save(persona);
    }

    public void borrarPersona(Long id){

        personaRepo.deleteById(id);
    }

    public List<Persona> listarPersonas(){

        return personaRepo.findAll();
    }

    public Persona buscarPersonaId(Long id){

        return personaRepo.findById(id).orElse(null);
    }

    public void modificarPersona(Persona persona) {
        // Se busca la persona en la base de datos por su ID
        Optional<Persona> personaEncontrada =
                personaRepo.findById(persona.getId());

        if(personaEncontrada.isPresent()) {
            // Si se encontró la persona, se actualizan sus datos
            Persona personaActualizada = personaEncontrada.get();
            personaActualizada.setFullName(persona.getFullName());
            personaActualizada.setUbication(persona.getUbication());
            personaActualizada.setPosition(persona.getPosition());
            personaActualizada.setImage(persona.getImage());
            personaActualizada.setUser(persona.getUser());
            personaActualizada.setPassword(persona.getPassword());

            // Aquí se pueden actualizar más campos según la necesidad
            personaRepo.save(personaActualizada);
        } else {
            // Si no se encontró la persona, se puede lanzar una excepción o manejar el error de otra forma
            throw new NoSuchElementException("No se encontró la persona con ID " + persona.getId());
        }
    }

    //Este metodo es sin DTO
    /*public Persona login(String user, String password){
      return personaRepo.findByUserAndPassword(user, password);
    }*/

    //Este metodo es con DTO
    public PersonaDTO login(String user, String password){

        Persona persona =  personaRepo.findByUserAndPassword(user, password);
        PersonaDTO personaDTO = new PersonaDTO(persona.getId(), persona.getUbication(), persona.getPosition(), persona.getFullName(), persona.getImage());

        return personaDTO;
    }
}
