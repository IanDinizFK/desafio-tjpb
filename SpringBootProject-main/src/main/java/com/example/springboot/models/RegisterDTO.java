package com.example.springboot.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @NotBlank(message = "Este campo é obrigatório") String login,
        @NotNull(message = "Este campo é obrigatório") String password,
        @NotNull(message = "Este campo é obrigatório") ClientRole role
    ) {}