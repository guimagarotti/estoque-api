package facens.magnumti.gerenciamento_estoque.estoqueapi.services;

import facens.magnumti.gerenciamento_estoque.estoqueapi.enums.CategoryType;
import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Produto;
import java.util.List;

public interface ProdutoService {

    List<Produto> getAllProducts();
    Produto getProductById(Long id);
    Produto createProduct(Produto produto);
    Produto updateProduct(Long id, Produto produto);
    void removeProduct(Long id);

    List<Produto> getProductsByCategory(CategoryType category);
    List<Produto> getProductsByName(String productName);
    List<Produto> getProductsByNameContaining(String parcialProductName);
    List<Produto> getProductsByStatus(boolean status);
}
