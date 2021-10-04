package br.com.estudi.hibernateenvers.domain.aluno.repository;

import br.com.estudi.hibernateenvers.domain.aluno.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>, RevisionRepository<Aluno, Long , Long> {
}
