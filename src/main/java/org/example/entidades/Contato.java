package org.example.entidades;

import javax.persistence.*;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long idContato;

    @Column(name = "cel_contato")
    private String celContato;

    @Column(name = "email_contato")
    private String emailContato;

    @Column(name = "endereco_contato")
    private String endereco_contato;

    public Contato() {
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getCelContato() {
        return celContato;
    }

    public void setCelContato(String celContato) {
        this.celContato = celContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getEndereco_contato() {
        return endereco_contato;
    }

    public void setEndereco_contato(String endereco_contato) {
        this.endereco_contato = endereco_contato;
    }
}