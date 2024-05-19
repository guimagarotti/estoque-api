package facens.magnumti.gerenciamento_estoque.estoqueapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import facens.magnumti.gerenciamento_estoque.estoqueapi.enums.CategoryType;
import facens.magnumti.gerenciamento_estoque.estoqueapi.exceptions.ProductNotFoundException;
import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Produto;
import facens.magnumti.gerenciamento_estoque.estoqueapi.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public List<Produto> getAllProducts() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto getProductById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public Produto createProduct(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto updateProduct(Long id, Produto produto) {
        Produto produtoAtual = getProductById(id);
        
        if (produtoAtual == null)
            throw new ProductNotFoundException("O produto com ID: " + id + " não foi encontrado.");

        produto.setId(produtoAtual.getId());
        return produtoRepository.save(produto);
    }

    @Override
    public void removeProduct(Long id) {        
        Produto produto = getProductById(id);
       
       if (produto == null)
           throw new ProductNotFoundException("O produto com ID: " + id + " não foi encontrado.");

       produtoRepository.deleteById(id);
    }

    /* Query Methods */
    @Override
    public List<Produto> getProductsByCategory(CategoryType category) {
        return produtoRepository.findByCategory(category);
    }

    @Override
    public List<Produto> getProductsByName(String productName) {
        return produtoRepository.findByName(productName);
    }

    @Override
    public List<Produto> getProductsByNameContaining(String parcialProductName) {
        return produtoRepository.findByNameContaining(parcialProductName);
    }

    @Override
    public List<Produto> getProductsByStatus(boolean status) {
        return produtoRepository.findByStatus(status);
    }
}