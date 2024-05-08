package com.sancho.cabeleleila.controller;

import com.sancho.cabeleleila.entity.Perfil;
import com.sancho.cabeleleila.entity.PerfilUsuario;
import com.sancho.cabeleleila.service.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/perfil-usuario")
@CrossOrigin
public class PerfilUsuarioController {

    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @PostMapping
    public ResponseEntity<PerfilUsuario> create(@RequestBody PerfilUsuario obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilUsuarioService.create(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        perfilUsuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuario> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(perfilUsuarioService.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<PerfilUsuario>> getAll() {
        return ResponseEntity.ok().body(perfilUsuarioService.getAllPerfilUsuario());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PerfilUsuario> update(@PathVariable Long id, @RequestBody PerfilUsuario obj) {
        obj.getId_usuario();
        return ResponseEntity.ok().body(perfilUsuarioService.update(obj));
    }
}
