package com.sancho.cabeleleila.service;

import com.sancho.cabeleleila.entity.Perfil;
import com.sancho.cabeleleila.entity.PerfilUsuario;
import com.sancho.cabeleleila.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;


    public PerfilUsuario create(PerfilUsuario p1) {
       return perfilUsuarioRepository.save(p1);
    }
    public void delete(Long id) {
        perfilUsuarioRepository.deleteById(id);
    }

    public PerfilUsuario getId(Long id) {
        Optional<PerfilUsuario> obj = perfilUsuarioRepository.findById(id);
        return obj.get();
    }

    public List<PerfilUsuario> getAllPerfilUsuario() {
        return perfilUsuarioRepository.findAll();
    }

    public PerfilUsuario update(PerfilUsuario obj) {
        Optional<PerfilUsuario> newObj = perfilUsuarioRepository.findById(obj.getId());
        updatePerfilUsuario(newObj, obj);
        return perfilUsuarioRepository.save(newObj.get());
    }

    private void updatePerfilUsuario(Optional<PerfilUsuario> newObj, PerfilUsuario obj) {
        newObj.get().setId_usuario(obj.getId_usuario());
        newObj.get().setId_descricao(obj.getId_descricao());
    }

}
