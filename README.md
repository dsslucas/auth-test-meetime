# Teste Prático - Integração com HubSpot
## Practical Test - HubSpot Integration

---

## Objetivo | Objective
Proposto pela Meetime, este teste técnico tem por finalidade analisar os conhecimentos sobre desenvolvimento backend, utilizando os recursos disponíveis pela HubSpot, uma plataforma de CRM (Gerenciamento de Relacionamento de Clientes).

--

Proposed by Meetime, this technical test aims to analyze knowledge about backend development, using the resources available by HubSpot, a CRM (Customer Relationship Management) platform.

---

## Descrição do Desafio | Challenge Description
Este teste consiste em:
- Autenticar-se ao HubSoft;
- Criar uma aplicativo e conta de desenvolvedor para teste;
- Obter um token de acesso;
- Criar um contato (com escopo `crm.objects.contacts.write` obrigatório).

--

This test consists of:
- Authenticating to HubSoft;
- Creating an application and developer account for testing;
- Obtaining an access token;
- Creating a contact (with mandatory `crm.objects.contacts.write` scope).

---

## O que foi utilizado | What was used 
- Spring Boot (v3.4.4);
- Spring Web;
- Spring Security;
- OAuth 2.0;
- Spring Boot Devtools;
- Lombok;
- Maven;
- RestTemplate (conexão com a API do HubSpot | HubSpot API connection)

---

## Instruções | Instructions

1. Clone o repositório | Clone this repository
```
git clone https://github.com/dsslucas/auth-test-meetime.git
```

2. Instale | Install [Apache Tomcat](https://tomcat.apache.org/download-90.cgi).

3. Crie e configure um aplicativo no HubSpot | Create and configure the Application at HubSpot.

    [Configuração](https://developers.hubspot.com/)

4. Configure uma URL para redirecionamento | Configure the redirect URL.
```
    localhost:8080/api/auth/getCode
```

5. Defina escopos obrigatórios | Define mandatory scopes.
```
crm.objects.contacts.read
```
```
crm.objects.contacts.write
```

6. Crie uma conta de teste de desenvolvedor | Create one development test account.

7. Abra o projeto em uma IDE de sua preferência | Open the project on preffered IDE

8. Faça o set das variáveis de ambiente, com base nas configurações do aplicativo | Set the enviromnent variables, based on Application configurators
```
CLIENT_ID=XXXX-XXXXX-XXXX;
CLIENT_SECRET=XXXX-XXXX-XXXX;
REDIRECT_URI=XXXX-XXXX-XXXX;
SCOPE=oauth%20crm.objects.contacts.read%20crm.objects.contacts.write;
```

9. Donwload [Maven](https://maven.apache.org/download.cgi).

10. Abra o terminal e digite | Open the terminal and digit
```
 mvn clean install
```

11. Execute o projeto.

---

## Observações | Observations

- Para criar um contato, é necessário selecionar a conta de desenvolvedor de teste.