package facens.magnumti.gerenciamento_estoque.estoqueapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facens.magnumti.gerenciamento_estoque.estoqueapi.enums.CategoryType;
import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Produto;
import facens.magnumti.gerenciamento_estoque.estoqueapi.services.ProdutoService;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getAllProducts() {
        return produtoService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Produto getProductById(@PathVariable Long id) {
        return produtoService.getProductById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Produto createdProduct = produtoService.createProduct(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/edit/{id}")
    public Produto editProduct(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.updateProduct(id, produto);
    }

    @DeleteMapping("/remove/{id}")
    public void removeProduct(@PathVariable Long id) {
        produtoService.removeProduct(id);

        /*
         * try {
         * produtoService.removeProduct(id);
         * return ResponseEntity.ok("Produto deletado com sucesso!");
         * } catch (ProductNotFoundException e) {
         * return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
         * }
         */
    }

    @GetMapping("/byCategory/{category}")
    public List<Produto> getProductsByCategory(@PathVariable CategoryType category) {
        return produtoService.getProductsByCategory(category);
    }

    @GetMapping("/byName/{productName}")
    public List<Produto> getProductsByName(@PathVariable String productName) {
        return produtoService.getProductsByName(productName);
    }

    @GetMapping("/byNameContaining/{parcialProductName}")
    public List<Produto> getProductsByNameContaining(@PathVariable String parcialProductName) {
        return produtoService.getProductsByNameContaining(parcialProductName);
    }

    @GetMapping("/byStatus/{status}")
    public List<Produto> getProductsByStatus(@PathVariable boolean status) {
        return produtoService.getProductsByStatus(status);
    }
}