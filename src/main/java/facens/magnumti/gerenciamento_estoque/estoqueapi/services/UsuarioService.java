package facens.magnumti.gerenciamento_estoque.estoqueapi.services;

import org.springframework.stereotype.Service;

import facens.magnumti.gerenciamento_estoque.estoqueapi.exceptions.UserNotFoundException;
import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Usuario;
import facens.magnumti.gerenciamento_estoque.estoqueapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario getUserByEmailAndPassword(String email, String password) {
        return usuarioRepository.findUserByEmailAndPassword(email, password);
    }

    public void removeUser(Long id) {
        Usuario usuario = getUserById(id);

        if (usuario == null)
            throw new UserNotFoundException("O usuário com ID: " + id + " não foi encontrado.");

        usuarioRepository.deleteById(id);
    }
}