package org.example.entidades;

import javax.persistence.*;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

    @ManyToOne
    @JoinColumn(name = "id_prod", nullable = false)
    private Produto produto;

    @Column(name = "tipo_pagamento")
    private String tipoPagamento;

    @Column(name = "valor_pagamento")
    private Double valorPagamento;

    public Pagamento(){

    }

    public Pagamento(Long idPagamento, Produto produto, String tipoPagamento, Double valorPagamento) {
        this.idPagamento = idPagamento;
        this.produto = produto;
        this.tipoPagamento = tipoPagamento;
        this.valorPagamento = valorPagamento;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
