package com.example.springboot.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.springboot.dtos.solicitationRecordDto;
import com.example.springboot.models.SolicitationModel;
import com.example.springboot.models.StatusSolicitacao;
import com.example.springboot.repositories.SolicitationRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Email;

@Service
public class SolicitationServices {
    @Autowired
    SolicitationRepository solicitationRepository;

    @Autowired EmailService emailService;
    SolicitationServices(EmailService emailService) {
        this.emailService = emailService;
    }

    public SolicitationModel cadastrarSolicitacao(solicitationRecordDto data) {
        SolicitationModel newSolicitation = new SolicitationModel();
        newSolicitation.setTitulo(data.titulo());
        newSolicitation.setDescricao(data.descricao());
        newSolicitation.setEmail_solicitante(data.solicitante());
        newSolicitation.setDataCriacao(LocalDateTime.now());
        newSolicitation.setStatus(StatusSolicitacao.ABERTA);
        emailService.enviarEmail(data.solicitante(), data.titulo());
        return solicitationRepository.save(newSolicitation);
    }

    public List<SolicitationModel> getSolicitacoes() {
        return solicitationRepository.findAll();
    }

    public String alterarStatus(Long idSolicitacao, StatusSolicitacao status) {
        SolicitationModel sol = solicitationRepository.findById(idSolicitacao)
                .orElseThrow(() -> new EntityNotFoundException("Solicitação não encontrada"));
        if (sol.getStatus().toString() == "CONCLUIDA") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não se pode alterar uma solicitação que foi já concluída");
        }
        System.out.println(status);
        sol.setStatus(status);
        solicitationRepository.save(sol);
        return "Status atualizado com sucesso!";
    }
}
