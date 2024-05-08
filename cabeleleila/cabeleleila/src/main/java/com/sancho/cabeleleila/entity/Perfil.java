package com.sancho.cabeleleila.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_perfil")
@Setter
@Getter
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    public Perfil() {}

    public Perfil(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
