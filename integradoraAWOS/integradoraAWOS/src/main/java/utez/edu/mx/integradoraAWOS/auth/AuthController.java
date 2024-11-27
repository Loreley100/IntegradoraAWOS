package utez.edu.mx.integradoraAWOS.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.integradoraAWOS.auth.DTO.AuthLoginDTO;

// 10.- Crear el controller para Auth
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody AuthLoginDTO authLoginDTO) {
        return authService.login(authLoginDTO);
    }
}
