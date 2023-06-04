package br.com.apiuff.controller;


import br.com.apiuff.controller.dto.DataAuth;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid DataAuth dataAuth){
        return ResponseEntity.ok().build();
    }

}
