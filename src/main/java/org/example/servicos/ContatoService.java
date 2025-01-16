package org.example.servicos;

import org.example.entidades.Contato;
import org.example.repositorios.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    public ContatoRepository contatoRepository;

    public List<Contato> buscarTodos(){
        return contatoRepository.findAll();
    }

    public Optional<Contato> buscarPorId(Long id){
        return contatoRepository.findById(id);
    }

    public Contato inserir(Contato contato){
        return contatoRepository.save(contato);
    }

    public void deletePorId(Long id){
        contatoRepository.deleteById(id);
    }
}