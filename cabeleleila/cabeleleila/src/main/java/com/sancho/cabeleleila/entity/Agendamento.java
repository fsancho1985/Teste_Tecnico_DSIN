package com.sancho.cabeleleila.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "tb_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;


    public Agendamento() {}

    public Agendamento(Long idAgendamento, String dateString, Usuario usuario, Servico servico) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.idAgendamento = idAgendamento;
        this.date = formato.parse(dateString);
        this.usuario = usuario;
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "idAgendamento=" + idAgendamento +
                ", date=" + date +
                ", usuario=" + usuario +
                ", servico=" + servico +
                '}';
    }
}
