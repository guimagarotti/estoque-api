package facens.magnumti.gerenciamento_estoque.estoqueapi.Controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}
