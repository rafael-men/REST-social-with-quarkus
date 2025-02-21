# Social Media API - Quarkus

Este projeto é uma API de rede social desenvolvida com **Quarkus** e **PostgreSQL**. A API fornece recursos básicos para a criação de usuários, postagem de conteúdo, interações (curtir, comentar) e recuperação de postagens. Ideal para quem deseja construir uma plataforma social com Quarkus.

---

## 🛠️ Tecnologias Utilizadas

- **Quarkus**
- **PostgreSQL**
- **Panache Repositories**
- **Hibernate ORM**
- **Swagger**
- **Docker**

---

## 🚀 Funcionalidades

- **Cadastro de usuários**: `POST /users`
- **Criação de postagens**: `POST /posts`
- **Interação com postagens** (Curtir, comentar): 
  - Curtir: `POST /posts/{id}/like`
  - Comentar: `POST /posts/{id}/comment`
- **Listar postagens**: `GET /posts`
- **Detalhes de uma postagem**: `GET /posts/{id}`

---

## ✅ Pré-requisitos

- **JDK 11** ou superior
- **Docker** (opcional, para rodar o PostgreSQL em container)

---

## 🐳 Como Rodar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/usuario/nome-do-repositorio.git
cd nome-do-repositorio
```
### 2. Criar e executar os contêineres Docker
Certifique-se de ter o Docker instalado e em execução no seu sistema.

Na pasta raiz do projeto, execute o seguinte comando para criar os contêineres do banco de dados e da aplicação:

```bash
docker-compose up -d
```
3. Acessar a API
Após a execução do docker-compose, a API estará disponível em:

API (Quarkus): http://localhost:8080

Swagger UI (Documentação): http://localhost:8080/swagger-ui
