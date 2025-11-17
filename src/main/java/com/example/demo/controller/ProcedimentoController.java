package com.example.demo.controller;

import com.example.demo.model.Procedimento;
import com.example.demo.service.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

        @Autowired
        private ProcedimentoService service;

        @PostMapping
        public Procedimento criar(@RequestBody Procedimento procedimento) {
            return service.criar(procedimento);
        }

        @GetMapping
        public List<Procedimento> listar() {
            return service.listar();
        }

        @GetMapping("/{id}")
        public Procedimento buscar(@PathVariable Long id) {
            return service.buscarPorId(id);
        }

        @PutMapping("/{id}")
        public Procedimento atualizar(@PathVariable Long id, @RequestBody Procedimento procedimento) {
            return service.atualizar(id, procedimento);
        }

        @DeleteMapping("/{id}")
        public void deletar(@PathVariable Long id) {
            service.deletar(id);
        }
    }