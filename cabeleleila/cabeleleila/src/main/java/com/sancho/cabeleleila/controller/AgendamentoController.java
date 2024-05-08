package com.sancho.cabeleleila.controller;

import com.sancho.cabeleleila.entity.Agendamento;
import com.sancho.cabeleleila.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;

    @PostMapping
    public ResponseEntity<Agendamento> create(@RequestBody Agendamento obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> getAllAgendamentos() {
        return ResponseEntity.ok().body(service.getAllAgendamentos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getId(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento obj) {
        obj.setIdAgendamento(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}
