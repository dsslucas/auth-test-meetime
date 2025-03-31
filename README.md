# Teste Prático - Integração com HubSpot
Practical Test - HubSpot Integration

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
- RestTemplate (conexão com a API do HubSpot | HubSpot API connection);
- Spring Validation (verifica os campos da requisição | check the request fields);
- NGROK (execução do projeto na internet | project execution on Internet).

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

12. Download [NGROK](https://dashboard.ngrok.com/get-started/setup/windows)
13. Abra o terminal e copie este comando, para authtoken | Open the terminal and copy, for authtoken
```
ngrok config add-authtoken 2mzWkoEBvo01zhafd4DDUfuoabo_uH3Wza85i1Ljgv7WF515
```
14. Copie o comando para iniciar a aplicação do NGROK | Copy the command for start the NGROK application
```
ngrok http http://localhost:8080
```

15. Com a URL gerada pelo NGROK via terminal, acesse o aplicativo pelo HubSpot, acesse "Webhooks", informe a URL concatenado com ``/api/contact/webhook`` e cole na URL de destino | With the URL generated by NGROK via terminal, access the application through HubSpot, access "Webhooks", enter the URL concatenated with ``/api/contact/webhook`` and paste it into the destination URL.
16. Informe o tipo de objeto "Contato". Também informe o evento "Criado" para monitoramento | Enter the object type "Contact". Also enter the event "Created" for monitoring.
17. Ative a assinatura clicando em "Ativar" na lista de assinaturas | Activate the subscription by clicking "Activate" in the subscriptions list.
---

## Observações | Observations

- Para criar um contato, é necessário selecionar a conta de desenvolvedor de teste | To create a contact, you need to select the test developer account. 
- O evento de Assinatura (relativo à criação de contato) renderiza no console apenas um objeto com os dados enviados pelo webhook | The Subscription event (related to contact creation) renders in the console only an object with the data sent by the webhook 