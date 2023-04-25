package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "tb_modelos", schema = "estacionamento")
public class Modelo extends AbstractEntity {
    @Getter@Setter
    @Column(name = "nome", nullable = false, length = 50, unique = true)
    private String nome;
    @Getter@Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "marca", nullable = false)
    private Marca marca;
}
