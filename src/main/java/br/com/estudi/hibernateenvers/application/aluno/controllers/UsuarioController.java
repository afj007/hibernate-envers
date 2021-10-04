package br.com.estudi.hibernateenvers.application.aluno.controllers;

import br.com.estudi.hibernateenvers.domain.aluno.entity.Aluno;
import br.com.estudi.hibernateenvers.domain.aluno.entity.Usuario;
import br.com.estudi.hibernateenvers.domain.aluno.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public void criar(@RequestBody Usuario usuario){
        usuarioService.criar(usuario);
    }

    @GetMapping("/ultima/{id}")
    public ResponseEntity<Usuario> buscarUltimaAlteracao(@PathVariable("id") Long idUsuario){
        final Usuario usuario = usuarioService.buscarUltimaAlteracao(idUsuario);
        return ResponseEntity.ok(usuario);
    }
}
