package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dtos.alterarSolicitacaoDto;
import com.example.springboot.dtos.solicitationRecordDto;
import com.example.springboot.models.SolicitationModel;
import com.example.springboot.services.SolicitationServices;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("solicitacao")
public class SolicitationController {

    @Autowired 
    SolicitationServices solicitationServices;

    @PostMapping("register")
    public SolicitationModel registrarSolicitacao(@RequestBody @Valid solicitationRecordDto data) {
        return solicitationServices.cadastrarSolicitacao(data);
    }
    
    @GetMapping("listar")
    public List<SolicitationModel> getSolicitacoes() {
        return solicitationServices.getSolicitacoes();
    }

    @PutMapping("alterarStatus/{id}")
    public String putMethodName(@PathVariable Long id, @Valid alterarSolicitacaoDto data) {
       return solicitationServices.alterarStatus(id, data.status());
    }
    
    
}
