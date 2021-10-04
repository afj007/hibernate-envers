package br.com.estudi.hibernateenvers.domain.aluno.service;

import br.com.estudi.hibernateenvers.domain.aluno.entity.Aluno;
import br.com.estudi.hibernateenvers.domain.aluno.entity.Usuario;
import br.com.estudi.hibernateenvers.domain.aluno.repository.AlunoRepository;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void criar(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Aluno buscarUltimaAlteracao(Long id) {
        final Optional<Revision<Long, Aluno>> lastChangeRevision = alunoRepository.findLastChangeRevision(id);

        final Revision<Long, Aluno> longAlunoRevision = lastChangeRevision.orElseThrow();
        final Aluno entity = longAlunoRevision.getEntity();
        final Usuario usuario = entity.getUsuario();
        return entity;
    }
}
