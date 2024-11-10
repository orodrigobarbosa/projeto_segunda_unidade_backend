package com.projeto_grpc_framework.grpc_framework.controller;

import com.exemplo.grpc.*;
import com.projeto_grpc_framework.grpc_framework.domain.Usuario;
import com.projeto_grpc_framework.grpc_framework.repository.UsuarioRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class UsuarioController extends UsuarioServiceGrpc.UsuarioServiceImplBase {

    private final UsuarioRepository usuariorepository;

    public UsuarioController(UsuarioRepository usuariorepository) {
        this.usuariorepository = usuariorepository;
    }

    @Override
    public void create(UsuarioReq request, StreamObserver<UsuarioRes> responseObserver) {
        Usuario usuario = new Usuario(request.getName(), request.getEmail());
        Usuario saved = usuariorepository.save(usuario);
        UsuarioRes usuarioRes = UsuarioRes.newBuilder()
                .setId(saved.getId())
                .setName(saved.getNome())
                .setEmail(saved.getEmail())
                .build();
        responseObserver.onNext(usuarioRes);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(EmptyReq request, StreamObserver<UsuarioResList> responseObserver) {
        List<Usuario> usuarios = usuariorepository.findAll();
        List<UsuarioRes> usuarioRes = usuarios.stream()
                .map(user -> UsuarioRes.newBuilder()
                        .setId(user.getId())
                        .setName(user.getNome())
                        .setEmail(user.getEmail())
                        .build())
                .toList();

        UsuarioResList usuarioResList = UsuarioResList.newBuilder().addAllUsuarios(usuarioRes).build();
        responseObserver.onNext(usuarioResList);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllServerStream(EmptyReq request, StreamObserver<UsuarioRes> responseObserver) {
        usuariorepository.findAll().forEach(usuario -> {
            UsuarioRes usuarioRes = UsuarioRes.newBuilder()
                    .setId(usuario.getId())
                    .setName(usuario.getNome())
                    .setEmail(usuario.getEmail())
                    .build();
            responseObserver.onNext(usuarioRes);
        });
        responseObserver.onCompleted();
    }
}
