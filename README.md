# Social Media API - Quarkus

Este projeto é uma API de rede social desenvolvida com Quarkus e PostgreSQL. A API fornece recursos base para criação de usuários, postagem de conteúdo, interações (curtir, comentar) e recuperação de postagens. Ideal para quem deseja construir uma plataforma social com Quarkus.

## Tecnologias Utilizadas

- **Quarkus** 
- **PostgreSQL** 
- **Panache Repositories** 
- **Hibernate ORM**
- **Swagger**
- **Docker** 

## Funcionalidades

- **Cadastro de usuários** (POST /users)
- **Criação de postagens** (POST /posts)
- **Interação com postagens** (Curtir, comentar)
- **Listar postagens** (GET /posts)
- **Detalhes de uma postagem** (GET /posts/{id})

## Pré-requisitos

- JDK 11 ou superior
- Docker (opcional, para rodar o PostgreSQL em container)

## Como Rodar o Projeto

### 1. Clonar o repositório

### 2. Executar docker compose up na pasta raíz do projeto para criar os contêineres do banco e da aplicação.
