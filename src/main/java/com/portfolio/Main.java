package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication // Anotação para declarar que é uma aplicação SpringBoot
@RestController // Configurar que todo @Mapping será um rest endpoint para clientes possam chamar.
@RequestMapping("api/v1/clientes")
public class Main {

    private final ClienteRepository clienteRepository;
    public Main(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Método Main
    public static void main (String[] args){
        System.out.println("Inicializando o projeto!");
        SpringApplication.run(Main.class, args);
        System.out.println("Projeto inicializado!");
    } // Fim do método main
    // Métodos
    @GetMapping
    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
} // Fim da classe Main
