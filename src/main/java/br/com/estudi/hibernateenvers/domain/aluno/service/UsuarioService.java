package br.com.estudi.hibernateenvers.domain.aluno.service;

import br.com.estudi.hibernateenvers.domain.aluno.entity.Usuario;
import br.com.estudi.hibernateenvers.domain.aluno.repository.UsuarioRepository;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void criar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUltimaAlteracao(Long idUsuario) {
        final Optional<Revision<Long, Usuario>> lastChangeRevision = usuarioRepository.findLastChangeRevision(idUsuario);
        return lastChangeRevision.orElseThrow().getEntity();
    }
}
