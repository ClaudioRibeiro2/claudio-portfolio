package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication // Anotação para declarar que é uma aplicação SpringBoot
@RestController // Configurar que todo @Mapping será um rest endpoint para clientes possam chamar.
public class Main {
    // Método Main
    public static void main (String[] args){
        System.out.println("Inicializando o projeto!");
        SpringApplication.run(Main.class, args);
        System.out.println("Projeto inicializado!");
    } // Fim do método main

    // Métodos
    @GetMapping("/API") // Para expor o método para ser um rest endpoint para clientes conseguirem utilizar get requests
    public Resposta resp (){
        Resposta response = new Resposta(
                "Sedan",
                List.of("Bmw","Mercedes","Rolls Royce"),
                new Potencia(2.4, 200,15)
        );
        return response;
    } // Fim do método resp(), resp recebe o record Resposta()

    record Potencia(double cilindrada, int cavalos, int KMporLitro){}
    record Resposta (
            String veiculo,
            List<String> Marcas,
            Potencia potencia
    ){} // Fim do record Resposta
} // Fim da classe Main
