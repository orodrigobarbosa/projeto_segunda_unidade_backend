package com.projeto_grpc_framework.grpc_framework.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;


@Getter
@Entity(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;

    public Usuario() {
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

}
