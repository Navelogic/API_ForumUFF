package br.com.apiuff.controller;


import br.com.apiuff.controller.dto.DataAuth;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid DataAuth dataAuth){
        var token = new UsernamePasswordAuthenticationToken(dataAuth.email(), dataAuth.password());
        var auth = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
