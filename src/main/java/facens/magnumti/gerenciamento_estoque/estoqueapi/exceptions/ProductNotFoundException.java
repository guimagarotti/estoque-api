package facens.magnumti.gerenciamento_estoque.estoqueapi.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String mensagem) {
        super(mensagem);
    }
    
    public ProductNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}