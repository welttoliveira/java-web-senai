package org.example.entidades;

import javax.persistence.*;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Long idFornecedor;

    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

    @Column(name = "email_fornecedor")
    private String email;

    public Fornecedor() {

    }

    public Fornecedor(Long idFornecedor, String nomeFornecedor, String email) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.email = email;
    }

    //get retorna o valor
    public Long getIdFornecedor() {
        return idFornecedor;
    }

    //set cadastra, altera, atualiza
    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
