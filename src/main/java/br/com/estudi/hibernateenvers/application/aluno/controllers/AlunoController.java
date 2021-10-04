package br.com.estudi.hibernateenvers.application.aluno.controllers;

import br.com.estudi.hibernateenvers.domain.aluno.entity.Aluno;
import br.com.estudi.hibernateenvers.domain.aluno.entity.Usuario;
import br.com.estudi.hibernateenvers.domain.aluno.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public void criar(@RequestBody Aluno aluno){
        alunoService.criar(aluno);
    }


    @GetMapping("/ultima/{id}")
    public ResponseEntity<Aluno> buscarUltimaAlteracao(@PathVariable("id") Long id){
        final Aluno aluno = alunoService.buscarUltimaAlteracao(id);
        return ResponseEntity.ok(aluno);
    }
}
