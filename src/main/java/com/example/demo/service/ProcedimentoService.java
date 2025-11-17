package com.example.demo.service;

import com.example.demo.model.Procedimento;
import com.example.demo.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

        @Autowired
        private ProcedimentoRepository repository;

        public Procedimento criar(Procedimento procedimento) {
            return repository.save(procedimento);
        }

        public List<Procedimento> listar() {
            return repository.findAll();
        }

        public Procedimento buscarPorId(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Procedimento não encontrado"));
        }

        public Procedimento atualizar(Long id, @org.jetbrains.annotations.NotNull Procedimento procedimento) {
            Procedimento existente = buscarPorId(id);
            existente.setNome(procedimento.getNome());
            existente.setDescricao(procedimento.getDescricao());
            existente.setPreco(procedimento.getPreco());
            existente.setDuracao(procedimento.getDuracao());
            return repository.save(existente);
        }

        public void deletar(Long id) {
            repository.deleteById(id);
        }
    }