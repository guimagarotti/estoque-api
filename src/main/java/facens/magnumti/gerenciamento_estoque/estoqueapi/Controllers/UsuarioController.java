package facens.magnumti.gerenciamento_estoque.estoqueapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import facens.magnumti.gerenciamento_estoque.estoqueapi.Controllers.dto.LoginRequestDto;
import facens.magnumti.gerenciamento_estoque.estoqueapi.exceptions.UserNotFoundException;
import facens.magnumti.gerenciamento_estoque.estoqueapi.models.Usuario;
import facens.magnumti.gerenciamento_estoque.estoqueapi.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario getUserById(@PathVariable Long id) {
        return usuarioService.getUserById(id);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            usuarioService.removeUser(id);
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequestDto loginRequestDto) {
        Usuario existingUser = usuarioService.getUserByEmailAndPassword(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());

        if (existingUser != null && existingUser.getPassword().equals(loginRequestDto.getPassword()))
            return ResponseEntity.ok("Login successful");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}