package com.sancho.cabeleleila.controller;

import com.sancho.cabeleleila.entity.Perfil;
import com.sancho.cabeleleila.service.PerfilService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")

public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public ResponseEntity<Perfil> create(@RequestBody Perfil obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.create(obj));
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> getAll() {
        return ResponseEntity.ok().body(perfilService.getAllPerfis());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Perfil> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(perfilService.getId(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Perfil> update(@PathVariable Long id, @RequestBody Perfil obj) {
        obj.setDescricao(obj.getDescricao());
        return ResponseEntity.ok().body(perfilService.update(obj));
    }

}
