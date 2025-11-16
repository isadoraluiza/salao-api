package com.example.demo.service;


import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    // Cadastrar novo cliente
    public Cliente cadastrar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        return clienteRepository.save(cliente);

    }

    // Listar todos os clientes (ativos)
    public List<Cliente> listarAtivos() {
        // Se você tiver um campo "ativo" no Cliente, pode filtrar aqui.
        // Por enquanto, retorna todos:
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }


   // Atualizar cliente

    public Cliente atualizar(Long id, Cliente cliente) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        existente.setNome(cliente.getNome());
        existente.setTelefone(cliente.getTelefone());
        existente.setEmail(cliente.getEmail());

        return clienteRepository.save(existente);
    }

    // Inativar cliente
    public void inativar(Long id) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        clienteRepository.delete(existente);


    }
}