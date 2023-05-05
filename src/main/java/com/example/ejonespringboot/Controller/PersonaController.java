package com.example.ejonespringboot.Controller;


import com.example.ejonespringboot.Model.Persona;
import com.example.ejonespringboot.DTO.PersonaDTO;
import com.example.ejonespringboot.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    @ResponseBody
    public List<Persona> listarPersonas(){

        return personaService.listarPersonas();
    }

    @PostMapping("/persona")
    @ResponseBody
    public Persona crearPersona(@RequestBody Persona persona){

        return personaService.crearPersona(persona);
    }

    @DeleteMapping("/persona/{id}")
    public void borrarPersona(@PathVariable Long id){

        personaService.borrarPersona(id);
    }

    @PostMapping("/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@RequestBody Long id){
        return personaService.buscarPersonaId(id);
    }


    @PutMapping("/persona")
    public void modificarPersona(@RequestBody Persona persona){
        personaService.modificarPersona(persona);
    }

    @PostMapping("/login")
    public PersonaDTO login (@RequestBody Persona persona){
        return personaService.login(persona.getUser(), persona.getPassword());
    }




}
