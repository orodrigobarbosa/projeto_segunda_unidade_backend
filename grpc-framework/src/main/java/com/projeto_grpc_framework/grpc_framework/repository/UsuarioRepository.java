package com.projeto_grpc_framework.grpc_framework.repository;

import com.projeto_grpc_framework.grpc_framework.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
