package facens.magnumti.gerenciamento_estoque.estoqueapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import facens.magnumti.gerenciamento_estoque.estoqueapi.enums.CategoryType;
import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    /* Query Methods */
    List<Produto> findByCategory(CategoryType category);
    List<Produto> findByName(String productName);
    List<Produto> findByNameContaining(String productName);
    List<Produto> findByStatus(boolean status);
}
