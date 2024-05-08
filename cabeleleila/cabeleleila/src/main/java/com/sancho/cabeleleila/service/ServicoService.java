package com.sancho.cabeleleila.service;

import com.sancho.cabeleleila.entity.Servico;
import com.sancho.cabeleleila.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public Servico create(Servico obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Servico getId(Long id) {
        Optional<Servico> obj = repository.findById(id);
        return obj.get();
    }

    public List<Servico> getAllServicos() {
        return repository.findAll();
    }

    public Servico update(Servico obj) {
        Optional<Servico> newObj = repository.findById(obj.getCodigoServico());
        updateServico(newObj, obj);
        return repository.save(newObj.get());
    }

    private void updateServico(Optional<Servico> newObj, Servico obj) {
        newObj.get().setTipoServico(obj.getTipoServico());
        newObj.get().setPrice(obj.getPrice());
    }
}
