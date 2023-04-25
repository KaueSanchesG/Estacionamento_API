package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "tb_marcas", schema = "estacionamento")
public class Marca extends AbstractEntity {
    @Getter @Setter
    @Column (name = "nome", length = 50,unique = true, nullable = false)
    private String nome;

}
