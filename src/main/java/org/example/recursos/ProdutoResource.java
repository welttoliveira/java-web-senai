package org.example.recursos;

import org.example.entidades.Produto;
import org.example.servicos.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll(){
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        return produtoService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.buscarPorId(id).map(existingProduto -> {
            produto.setIdProduto(existingProduto.getIdProduto());
            return ResponseEntity.ok(produtoService.inserir(produto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        return produtoService.buscarPorId(id).map(existingProduto -> {
            produtoService.deletePorId(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
