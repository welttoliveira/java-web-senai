package org.example.recursos;

import org.example.entidades.Cliente;
import org.example.entidades.Usuario;
import org.example.servicos.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return usuarioService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.inserir(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.buscarPorId(id).map(existingUsuario ->{
            usuario.setIdUsuario(existingUsuario.getIdUsuario());
            return ResponseEntity.ok(usuarioService.inserir(usuario));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return usuarioService.buscarPorId(id).map(existingUsuario -> {
            usuarioService.deletePorId(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
