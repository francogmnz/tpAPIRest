package com.example.demo.services;


import com.example.demo.entities.Autor;
import com.example.demo.repositories.AutorRepoository;
import com.example.demo.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService{

    @Autowired
    private AutorRepoository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepoository autorRepository) {
        super(baseRepository);
        this.autorRepository = autorRepository;
    }
}
