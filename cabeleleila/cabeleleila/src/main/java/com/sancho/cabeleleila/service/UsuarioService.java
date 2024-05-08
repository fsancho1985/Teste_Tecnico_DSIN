package com.sancho.cabeleleila.service;

import com.sancho.cabeleleila.entity.Usuario;
import com.sancho.cabeleleila.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario obj) {
        return usuarioRepository.save(obj);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
    public Usuario getId(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.get();
    }

    public List<Usuario> getAllClientes() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Usuario obj) throws NoSuchAlgorithmException {
        Optional<Usuario> newObj = usuarioRepository.findById(obj.getCodigoUsuario());
        updateUsuario(newObj, obj);
        return usuarioRepository.save(newObj.get());
    }

    private void updateUsuario(Optional<Usuario> newObj, Usuario obj) throws NoSuchAlgorithmException {

        newObj.get().setNome(obj.getNome());
        newObj.get().setEmail(obj.getEmail());
        newObj.get().setPassword(obj.getPassword());
    }
}
