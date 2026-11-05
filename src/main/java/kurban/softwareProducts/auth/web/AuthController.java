package kurban.softwareProducts.auth.web;

import kurban.softwareProducts.auth.service.AuthService;
import kurban.softwareProducts.auth.web.request.RegisterRequest;
import kurban.softwareProducts.user.web.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(CsrfToken token){
        return token;
    }
    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }
}