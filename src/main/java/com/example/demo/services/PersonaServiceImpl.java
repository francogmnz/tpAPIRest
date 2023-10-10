package com.example.demo.services;

import com.example.demo.entities.Persona;
import com.example.demo.repositories.BaseRepository;
import com.example.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            //  List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //Con JPQL

            List<Persona> persona = personaRepository.serach(filtro);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            //  Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageanñe);
            //Con JPQL

            Page<Persona> persona = personaRepository.serach(filtro,pageable);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}