package org.example.entidades;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod")
    private Long idProduto;


    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @Column(name = "nome_prod")
    private String nomeProduto;

    @Column(name = "preco_prod")
    private Double precoProduto;

    @Column(name = "quantidade_prod")
    private Long quantidadeProduto;

    @Column(name = "descricao_prod")
    private String descricaoProduto;

    @Column(name = "fabricante_prod")
    private String fabricanteProduto;

    public Produto() {
    }

    //construtor
    //public Produto(Long idProduto, String nomeProduto, Double precoProduto, Long quantidadeProduto, String descricaoProduto) {
   //     this.idProduto = idProduto;
    //    this.nomeProduto = nomeProduto;
      //  this.precoProduto = precoProduto;
     //   this.quantidadeProduto = quantidadeProduto;
     //   this.descricaoProduto = descricaoProduto;
    //}


    public Produto(Long idProduto, Fornecedor fornecedor, String nomeProduto, Double precoProduto, Long quantidadeProduto, String descricaoProduto, String fabricanteProduto) {
        this.idProduto = idProduto;
        this.fornecedor = fornecedor;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.descricaoProduto = descricaoProduto;
        this.fabricanteProduto = fabricanteProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Long quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getFabricanteProduto() {
        return fabricanteProduto;
    }

    public void setFabricanteProduto(String fabricanteProduto) {
        this.fabricanteProduto = fabricanteProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
