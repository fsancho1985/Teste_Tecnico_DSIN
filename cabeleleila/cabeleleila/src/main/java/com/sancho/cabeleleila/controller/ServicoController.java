package com.sancho.cabeleleila.controller;

import com.sancho.cabeleleila.entity.Servico;
import com.sancho.cabeleleila.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService service;
    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody Servico obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> getId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicos(){
        return ResponseEntity.ok().body(service.getAllServicos());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Servico> update(@PathVariable Long id, @RequestBody Servico obj) {
        obj.setCodigoServico(id);
        return ResponseEntity.ok().body(service.update(obj));
    }
}
