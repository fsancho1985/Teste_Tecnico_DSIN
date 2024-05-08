package com.sancho.cabeleleila.service;

import com.sancho.cabeleleila.entity.Agendamento;
import com.sancho.cabeleleila.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento create(Agendamento obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Agendamento getId(Long id) {
        Optional<Agendamento> obj = repository.findById(id);
        return obj.get();
    }

    public List<Agendamento> getAllAgendamentos() {
        return repository.findAll();
    }

    public Agendamento update(Agendamento obj) {
        Optional<Agendamento> newObj = repository.findById(obj.getIdAgendamento());
        updateAgendamento(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateAgendamento(Optional<Agendamento> newObj, Agendamento obj) {
        newObj.get().setDate(obj.getDate());
    }
}
