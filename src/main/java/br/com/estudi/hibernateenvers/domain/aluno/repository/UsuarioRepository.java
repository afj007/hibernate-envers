package br.com.estudi.hibernateenvers.domain.aluno.repository;

import br.com.estudi.hibernateenvers.domain.aluno.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, RevisionRepository<Usuario, Long, Long> {
}
