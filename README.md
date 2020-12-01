
# Automobile Market

Esse projeto foi desenvolvido com objetivos experimentais e de estudo para resolução de um case com objetivo de criar um sistema de cadastro e compra de automóveis, que funcione através de uma web API utilizando Springboot e recursos do Springcloud.

A arquitetura do projeto consiste em 5 microserviços sendo eles:

### Auth
Servidor de autenticação

### Eureka
Service Discovery Server

### ZUL
API Gateway

### Automobile
Microserviço para gerenciamento de automóveis

### Bill
Microserviço para gerenciamento de boletos

## Utilização
Foi realizado o deploy do projeto no AWS BeanStalk e pode ser utilizado através do endereço http://zul-env.eba-pcncrpqc.sa-east-1.elasticbeanstalk.com. Para execução do projeto local, basta subir todos os projetos com o profile 'local' do Spring, o gateway será inicializado na porta 5555.

## Endpoints

### Auth

* POST auth/oauth/token

Authorization Type: Basic Auth
username: automobile
password: password

Request (form-data):
username: admin
password: password
scope: web
grant_type: password

* GET auth/user

Authorization: Bearer Token

### Automobile

* GET automobile/automobile

* POST automobile/automobile

Authorization: Bearer Token

Request (Body):
{
    "brand": "Volkswagen",
    "model": "Polo",
    "value": 60000
}

### Bill

* GET bill/bill/{id}

Authorization: Bearer Token

* POST bill/bill

Authorization: Bearer Token

Request (Body):
{
    "automobileId": 1,
    "value": 10000,
    "dueDate": "2020-11-30T23:57:08.883+00:00"
}

