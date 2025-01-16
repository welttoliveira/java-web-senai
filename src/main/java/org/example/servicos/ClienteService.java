package org.example.servicos;

import org.example.entidades.Cliente;
import org.example.entidades.Contato;
import org.example.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    public ClienteRepository clienteRepository;

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente inserir(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado){
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNomeCliente(clienteAtualizado.getNomeCliente());
            cliente.setContato(clienteAtualizado.getContato());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public void deletePorID(Long id){
        clienteRepository.deleteById(id);
    }
}
