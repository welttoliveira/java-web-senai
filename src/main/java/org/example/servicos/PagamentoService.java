package org.example.servicos;

import org.example.entidades.Pagamento;
import org.example.entidades.Usuario;
import org.example.repositorios.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    public PagamentoRepository pagamentoRepository;

    public List<Pagamento> buscarTodos(){
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPorId(Long id){
        return pagamentoRepository.findById(id);
    }

    public Pagamento inserir(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizar(Long id, Pagamento pagamentoAtualizado){
        return pagamentoRepository.findById(id).map(pagamento -> {
            pagamento.setTipoPagamento(pagamentoAtualizado.getTipoPagamento());
            pagamento.setValorPagamento(pagamentoAtualizado.getValorPagamento());
            pagamento.setProduto(pagamentoAtualizado.getProduto());
            return pagamentoRepository.save(pagamento);
        }).orElseThrow(()-> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public void deletePorId(Long id){
        pagamentoRepository.deleteById(id);
    }
}
