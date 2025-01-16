package org.example.entidades;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @ManyToOne
    @JoinColumn(name = "id_contato", nullable = false)
    private Contato contato;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "email_cliente")
    private String emailCliente;

    @Column(name = "tel_cliente")
    private String telCliente;

    public Cliente(){

    }

    public Cliente(Long idCliente, Contato contato, String nomeCliente, String emailCliente, String telCliente) {
        this.idCliente = idCliente;
        this.contato = contato;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telCliente = telCliente;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(String telCliente) {
        this.telCliente = telCliente;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
