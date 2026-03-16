package com.example.springboot.controllers;

import com.example.springboot.dtos.ReponseLoginDto;
import com.example.springboot.infra.security.TokenService;
import com.example.springboot.models.AuthenticationDTO;
import com.example.springboot.models.ClientModel;
import com.example.springboot.models.ClientRole;
import com.example.springboot.models.RegisterDTO;
import com.example.springboot.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ClientRepository repository;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity<ReponseLoginDto> login(@RequestBody @Valid AuthenticationDTO data){
        var clientPassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(clientPassword);
        var token = tokenService.generateToken((ClientModel) auth.getPrincipal());
        return ResponseEntity.ok(new ReponseLoginDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        ClientModel newUser = new ClientModel(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
