package br.com.infotech.usecase.usuario.impl;

import br.com.infotech.database.entity.UsuarioEntity;
import br.com.infotech.database.repository.UsuarioRepository;
import br.com.infotech.model.Usuario;
import br.com.infotech.usecase.usuario.UsuarioUseCase;
import org.springframework.stereotype.Service;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public UsuarioUseCaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
       UsuarioEntity entity = new UsuarioEntity();
       entity.setNome(usuario.getNome());
       entity.setGmail(usuario.getEmail());
       entity.setSenha(usuario.getSenha());
       usuarioRepository.save(entity);
    }

}