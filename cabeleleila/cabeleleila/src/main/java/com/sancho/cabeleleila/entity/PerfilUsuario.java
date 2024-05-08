package com.sancho.cabeleleila.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_perfil")
@Getter
@Setter
public class PerfilUsuario {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil id_descricao;

    public PerfilUsuario() {}

    public PerfilUsuario(Long id, Usuario id_usuario, Perfil id_descricao) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_descricao = id_descricao;
    }
}
