package java_spring_challenge.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Construtores, getters e setters
    public Pedido() {}

    public Pedido(Long id, String descricao, LocalDate data, Cliente cliente) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}