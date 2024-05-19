package facens.magnumti.gerenciamento_estoque.estoqueapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findUserByEmail(String email);
    Usuario findUserByEmailAndPassword(String email, String password);
}
