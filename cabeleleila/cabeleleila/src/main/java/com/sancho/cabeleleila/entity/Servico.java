package com.sancho.cabeleleila.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tb_servicos")
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoServico;
    private String tipoServico;
    private double price;

    public Servico() {}

    public Servico(Long codigoServico, String tipoServico, double price) {
        this.codigoServico = codigoServico;
        this.tipoServico = tipoServico;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigoServico=" + codigoServico +
                ", tipoServico='" + tipoServico + '\'' +
                ", price=" + price +
                '}';
    }
}
