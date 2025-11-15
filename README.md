# TechManage API

API REST desenvolvida em Spring Boot para gerenciamento de usuários, oferecendo endpoints para criar, atualizar, excluir e listar usuários.

---

## Tecnologias utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate Validator
- MySQL
- Docker & Docker Compose
- Testcontainers (JUnit 5)
- Maven
- Swagger/OpenAPI (springdoc)

---

## Como rodar a aplicação com Docker Compose

### 1. Clonar o repositório

```bash
git clone https://github.com/marcosdv/techmanage-api
cd techmanage-api
```

### 2. Gerar o JAR com Maven

```bash
   ./mvnw clean package -DskipTests
```

### 3. Rodar a aplicação com Docker Compose (API + MySQL)

```bash
   docker-compose up -d
```

---

## Link para acesso a API
Url: http://localhost:8080

## Link para acesso a Documentação Swagger/OpenAPI
Swagger UI: http://localhost:8080/swagger-ui/index.html

OpenAPI JSON: http://localhost:8080/v3/api-docs

---

## Endpoints disponíveis

### (GET) /api/users → lista todos os usuários

### (GET) /api/users/{id} → busca o usuário por ID
* Parâmetro Path: id -> ID do usuário (Long)

### (POST) /api/users → cria um novo usuário
* Request Body (JSON):
```json
{
  "fullName": "Nome Completo",
  "email": "nome@email.com.br",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-01-01",
  "userType": "ADMIN"
}
```

### (PUT) /api/users/{id} → atualiza os dados do usuário
* Parâmetro Path: id -> ID do usuário (Long)
* Request Body (JSON):
```json
{
  "fullName": "Nome Completo",
  "email": "nome@email.com.br",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-01-01",
  "userType": "ADMIN"
}
```

### (DELETE) /api/users/{id} → remove o usuário
* Parâmetro Path: id -> ID do usuário (Long)

---

## Rodando os testes

### Pré-requisitos
Docker instalado e rodando (necessário para Testcontainers)

##️ Executar testes
```bash
   ./mvnw test
```

---

## Autor

Projeto TechManage API REST criado por **Marcos Dias Vendramini** utilizando Spring Boot, Docker, Swagger, Teste Unitário, Teste de Integração e Testcontainers.

---