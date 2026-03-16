package com.example.springboot.models;
public enum StatusSolicitacao {
    ABERTA("aberta"),
    EM_ANALISE("em_analise"),
    CONCLUIDA("concluida");

    private String status;

    StatusSolicitacao(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
