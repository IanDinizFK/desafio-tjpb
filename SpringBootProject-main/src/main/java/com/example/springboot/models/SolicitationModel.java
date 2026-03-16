package com.example.springboot.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Table(name = "solicitacoes")
@Entity(name = "solicitacoes")
@Getter
@Setter
public class SolicitationModel {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long idSolicitacao;
    @NotNull(message = "Valor obrigatório")
    private String titulo;
    @NotNull(message = "Valor obrigatório")
    private String descricao;
    @NotNull(message = "Valor obrigatório")
    private String email_solicitante;
    private LocalDateTime dataCriacao;
    private StatusSolicitacao status;


}
