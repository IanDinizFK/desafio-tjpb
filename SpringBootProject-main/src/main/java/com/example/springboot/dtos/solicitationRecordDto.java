package com.example.springboot.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record solicitationRecordDto(
    @NotBlank(message = "Titulo deve ser obrigatorio") String titulo,
    @NotBlank(message = "Descricao deve ser obrigatorio") String descricao,
    @NotBlank(message = "Email é necessário")
    @Email(message = "Email precisa ser um enderço válido")
    String solicitante
) {
    
}
