package com.example.springboot.models;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "Este campo não pode ser vazio") String login,
        @NotBlank(message = "Este campo não pode ser vazio") String password
) {}
