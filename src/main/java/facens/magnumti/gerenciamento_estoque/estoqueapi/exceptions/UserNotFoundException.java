package facens.magnumti.gerenciamento_estoque.estoqueapi.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String mensagem) {
        super(mensagem);
    }
    
    public UserNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
