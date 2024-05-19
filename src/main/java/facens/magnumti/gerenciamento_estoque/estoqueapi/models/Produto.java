package facens.magnumti.gerenciamento_estoque.estoqueapi.models;

import facens.magnumti.gerenciamento_estoque.estoqueapi.enums.CategoryType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 3, message = "O nome deve possuir mais de 3 caracteres!")
    private String name;

    private boolean status;

    private CategoryType category;

    @NotBlank(message = "O código não pode estar em branco.")
    @Size(min = 3, message = "O código deve possuir mais de 3 caracteres!")
    private String code;

    @NotBlank(message = "O fabricante não pode estar em branco.")
    @Size(min = 3, message = "O nome deve possuir mais de 3 caracteres!")
    private String manufacturer;

    @NotNull
    private int quantity;

    @NotBlank(message = "A data não pode estar em branco.")
    private String date;

    @NotNull
    private int minimumLevel;

    @NotNull
    private int maximumLevel;
}