# DsClient
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/matheus-konrath/DsClient/blob/main/LICENSE)

# Sobre o projeto

Ds Client é uma aplicação Backend, desenvolvido no Bootcamp Spring, curso realizado pela [DevSuperior](https://learn.devsuperior.com/)

A aplicação consiste em um serviço web, em que é possível vizualizar a lista de cliente, inserir, atualizar e deletar um cliente específico.


# Modelo Conceitual
![Mapa](https://github.com/matheus-konrath/DsClient/blob/main/Asset/MapaConceitual.png)

# Tecnologia Usada

## Back end
- Java
- Spring Boot
- Jpa / Hibernate
- Maven

# Como executar o projeto

## Back end
Requisito: Java 11

```bash
# Clonar o repositorio
git clone https://github.com/matheus-konrath/DsClient

# Entrar na pasta do projeto
cd backend

# Executar o projeto
./mvnw spring-boot:run
```

```bash
# Sugestão: Usar o Postman para testes
URL = http://localhost:8080/clients

GET: http://localhost:8080/clients?page={numberPage}&linesPerPage={linesPerPage}&direction={direction}&orderBy={orderBy}

GET/ID: http://localhost:8080/clients/ID

POST: http://localhost:8080/clients

PUT: http://localhost:8080/clients/ID

DELETE: http://localhost:8080/clients/ID

```

# Autor
Matheus Konrath

https://www.linkedin.com/in/matheus-konrath-48177b192/?originalSubdomain=br
