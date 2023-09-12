package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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
    // API GET
    @GetMapping
    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    // API SEND
    record NovoClienteRequest(
            String nome,
            String email,
            Integer idade
    ){}
    @PostMapping
    public void criarCliente (@RequestBody NovoClienteRequest clienteRequest){
        Cliente addCliente = new Cliente();
        addCliente.setNome(clienteRequest.nome);
        addCliente.setEmail(clienteRequest.email);
        addCliente.setIdade(clienteRequest.idade);
        clienteRepository.save(addCliente);
    }
    // API DELETE
    //                         O q vai receber do cliente
    @DeleteMapping("{clienteId}")
    public void excluirCliente(@PathVariable("clienteId") Integer id){
        clienteRepository.deleteById(id);
    }
} // Fim da classe Main
