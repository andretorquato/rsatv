package com.produtos.main;

import com.produtos.entity.Produto;
import com.produtos.entity.Cliente;
import com.produtos.repository.InMemoryRepository;
import com.produtos.repository.InFileRepository;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Produto> produtoRepo = new InMemoryRepository<>();
        Produto p1 = new Produto("pc", 3000.0);
        Produto p2 = new Produto("pod", 50.0);
        produtoRepo.save(p1);
        produtoRepo.save(p2);
        
        System.out.println("Produtos armazenados em memoria:");
        List<Produto> produtos = produtoRepo.findAll();
        for (Produto p : produtos) {
            System.out.println(p);
        }
        
        InFileRepository<Cliente> clienteRepo = new InFileRepository<>("clientes.dat");
        Cliente c1 = new Cliente("João Silva", "joao@example.com");
        Cliente c2 = new Cliente("Maria Souza", "maria@example.com");
        clienteRepo.save(c1);
        clienteRepo.save(c2);
        
        System.out.println("\nClientes armazenados no arquivo:");
        List<Cliente> clientes = clienteRepo.findAll();
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
