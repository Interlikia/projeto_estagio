# API para controle de Vendas - Projeto Estágio X-Brain

Repositório Projeto Estágio

API REST para controle de **VENDAS**, que é composta por **número identificador(ID)**, **nome do vendedor**, **ID do vendedor** e **valor da venda** desenvolvida utilizando Spring Boot com banco de dados em memória H2 e integração JPA.

Para rodar a aplicação é necessário importar as dependência do Maven.
Com as dependências instaladas execute a aplicação com br.com.xbrain.projeto_estagio.ProjetoEstagioApplication.java

--

Para iniciar o fluxo de venda é necessário cadastrar um produto e um vendedor antes.
Isso pode ser feito através dos seguintes Endpoints:

* Cadastrar produto:
POST -> localhost:8080/produto/cadastrar

Corpo da requisição:

      {
          "nome": "Folha Sulfite - 100un",
          "valor": 12.99
      }

* Cadastrar vendedor:
POST -> localhost:8080/vendedor/cadastrar

Corpo da requisição:

      {
          "nome": "Eduardo Estrela"
      }

--

Agora podemos realizar uma venda através do Endpoint:

* Registrar venda:
POST->localhost:8080/venda/registrar-venda

Corpo da requisição:

      {
          "vendedor": {
              "id": 1,
              "nome": "Eduardo Estrela"
          },
          "produtosVendidos":[
              {
                  "id": 1
              }
          ],
          "valor": 21.99
      }

**Os IDs do vendedor, vendas e produtos são gerados sequencialmente então se quiser fazer uma venda para outro vendedor apenas trocar o campo "id" para o número do vendedor desejado.**

Agora com o vendedor e a venda feitos podemos fazer uma busca sobre qual o total de vendas e a média dos vendedores dentro de um intervalo de tempo.
Para fazer isso utilize o Endpoint:

* Tabular Vendedores:
GET -> localhost:8080/vendedor/tabulacao

Corpo da requisição:

      {
          "dataInicio": "2021-06-13T00:00:00",
          "dataFim": "2021-06-13T23:59:59"
      }
A data está em formato YYYY-MM-DD, então apenas troque esses dados para fazer uma pesquisa da meia-noite da dataInicio até as 23:59 da dataFim.

**Muito obrigado pela oportunidade.**
