package com.sancho.cabeleleila.controller;

import com.sancho.cabeleleila.entity.Usuario;
import com.sancho.cabeleleila.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok().body(usuarioService.getAllClientes());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) throws NoSuchAlgorithmException {
        obj.setCodigoUsuario(id);
        return ResponseEntity.ok().body(usuarioService.update(obj));

    }
}
