package com.portfolio;

import jakarta.persistence.*;
import java.util.Objects;

// comando para entrar no docker -> docker exec -it postgres bash
// comando para entrar no sql    -> psql -U (db server)
// listar os databases           -> /l
// entrar em um database         -> \c\ (nome do db)
// listar as relações            -> \d
// você consegue fazer comandos neste bash.
@Entity
public class Cliente {
    // Atributos
    @Id
    @SequenceGenerator(
            name = "cliente_id_sequence",
            sequenceName = "cliente_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_id_sequence"
    )
    private Integer id;
    private String nome;
    private String email;
    private Integer idade;

    // Construtor
    public Cliente(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.nome = name;
        this.email = email;
        this.idade = age;
    }
    public Cliente() {
    }

    // Getter's & Setter's
    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String name) {
        this.nome = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer age) {
        this.idade = age;
    }

    // Equals & Hash Code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(idade, cliente.idade);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, idade);
    }

    // To string
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", age=" + idade +
                '}';
    }
}
