package com.example.springboot.services;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public String enviarEmail(String email, String tituloSolicitacao){
        System.out.println("Email enviado!");
        System.out.println("Nova solicitação cadastrada!");
        System.out.println("Titulo: " + tituloSolicitacao);
        System.out.println("Solicitante: " + email);
        System.out.println("Status: " + "ABERTO");
        return "Ok!";
    }
}
