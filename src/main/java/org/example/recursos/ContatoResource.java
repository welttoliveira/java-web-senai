package org.example.recursos;

import org.example.entidades.Contato;
import org.example.servicos.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoResource {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> findAll(){
        return contatoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id){
        return contatoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato){
        return contatoService.inserir(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato){
        return contatoService.buscarPorId(id).map(existingContato -> {
            contato.setIdContato(existingContato.getIdContato());
            return ResponseEntity.ok(contatoService.inserir(contato));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return contatoService.buscarPorId(id).map(existingContato -> {
            contatoService.deletePorId(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
