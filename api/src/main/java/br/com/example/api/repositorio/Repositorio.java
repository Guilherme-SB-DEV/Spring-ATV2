package br.com.example.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.example.api.models.Pessoa;

@Repository
public interface Repositorio extends  CrudRepository<Pessoa, Integer>{
    
}
