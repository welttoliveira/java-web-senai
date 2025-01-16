package org.example.servicos;

import org.example.entidades.Cliente;
import org.example.entidades.Produto;
import org.example.entidades.Usuario;
import org.example.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario inserir(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletePorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
