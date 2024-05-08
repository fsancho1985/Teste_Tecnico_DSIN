package com.sancho.cabeleleila.service;

import com.sancho.cabeleleila.entity.Perfil;
import com.sancho.cabeleleila.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil create(Perfil obj) {
        return perfilRepository.save(obj);
    }

    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }

    public Perfil getId(Long id) {
        Optional<Perfil> obj = perfilRepository.findById(id);
        return obj.get();
    }

    public List<Perfil> getAllPerfis() {
        return perfilRepository.findAll();
    }

    public Perfil update(Perfil obj) {
        Optional<Perfil> newObj = perfilRepository.findById(obj.getId());
        updatePerfil(newObj, obj);
        return perfilRepository.save(newObj.get());
    }

    private void updatePerfil(Optional<Perfil> newObj, Perfil obj) {
        newObj.get().setDescricao(obj.getDescricao());
    }

}
