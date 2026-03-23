# 📌 SRSI – Sistema de Registro de Solicitações Internas

## 📘 Descrição
Aplicação full stack para registro e gerenciamento de solicitações internas no tribunal.

Funcionalidades principais:
- Criar solicitações
- Listar solicitações
- Alterar status
- Autenticação básica
- Simulação de envio de email

---

## 🚀 Tecnologias
- Backend: Java + Spring Boot
- Frontend: Angular
- Banco de Dados: PostgreSQL
- Segurança: Spring Security (Basic Auth)

---

## ⚙️ Funcionalidades

### 📌 Cadastro de Solicitação
Campos:
- id (gerado automaticamente)
- titulo (obrigatório)
- descricao (obrigatório)
- solicitante (obrigatório)
- dataCriacao (automática)
- status (automático)

Status possíveis:
- ABERTA (padrão)
- EM_ANALISE
- CONCLUIDA

---

### 📋 Listagem
- Lista todas as solicitações cadastradas

---

### 🔄 Alteração de Status
- Permite atualizar o status da solicitação
- Regra: não é permitido alterar solicitações CONCLUIDAS

---

### 📧 Email (Simulado)
Ao criar uma solicitação, o sistema simula envio de email via log.


### Spring Security com:
- ✔ Basic Authentication
- ✔ Usuário fixo em memória (ex: admin / admin)


### FRONTEND
- Criar uma interface simples contendo:
- ✔ Formulário de cadastro
- ✔ Tela de listagem
- ✔ Botão para alterar status

### ⭐ Melhorias (Opcional)
- Docker (Postgres + MailHog)
- Liquibase
- Paginação
- Filtros por status
- Validações adicionais

### 🚫REGRAS
- Tempo Total: 2 horas 30 minutos.
- ● Execução presencial
- ● Consulta: Liberada (StackOverflow, Documentação Oficial, Baeldung).
- ● Uso de IA: PROIBIDO. O uso de ChatGPT, Claude, GitHub Copilot ou similares resultará em
desclassificação imediata. Queremos avaliar o seu raciocínio, não o do modelo.

---

# BACKEND 100%, front não deu tempo fazer, tempo acabou quando estava inicializando o angular.
# Backend (Completo com todas as funcionalidades)
## Requisitos Java 17+, Docker
**rode no cmd da pasta raiz: docker compose up -d 
Para subir o banco de dados

# Frontend
## Requisitos: node
**Rode npm i na pasta raiz ./frontend para instalar todas as dependencias necessárias do projeto
