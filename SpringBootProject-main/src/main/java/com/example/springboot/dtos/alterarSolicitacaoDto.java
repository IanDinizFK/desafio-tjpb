package com.example.springboot.dtos;

import com.example.springboot.models.StatusSolicitacao;

import jakarta.validation.constraints.NotBlank;

public record alterarSolicitacaoDto(
        @NotBlank(message = "Solicitacao deve ser obrigatorio")
        StatusSolicitacao status) {}
