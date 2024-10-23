# PROJETO Tools Java Challenge


## Requisitos

- Java 17
- GIT
- Maven 3.6.3

## Executando localmente

1. Clonar o repositório
``` 
git clone https://github.com/rafacaputo-java/API-de-Gerenciamento-de-Compras.git
```

2. Este projeto utiliza o banco de dados H2 em modo memória (in-memory) para facilitar o desenvolvimento e os testes. Abaixo estão as configurações necessárias para rodar o H2:

3. Acessar o H2 através do link: http://localhost:8080/h2-console

4. Setar a JDBC URL: jdbc:h2:mem:testdb


# Configurações do DataSource
- spring.datasource.url=jdbc:h2:mem:testdb
- spring.datasource.username=sa
- spring.datasource.password=


A aplicação estará disponível em `http://localhost:8080`

# COLLECTION POSTMAN
- https://www.mediafire.com/file/i9ty8lq87mcu189/Compras.postman_collection.json/file


# Sistema de Cadastro de Compras
Descrição do Projeto
Este projeto visa implementar um sistema de cadastro de compras que permitirá a gestão eficiente de itens adquiridos por consumidores. O sistema será acessível através de uma API REST, que oferece funcionalidades para o cadastro, pesquisa e relatórios de compras.

Funcionalidades da API REST
1. # Cadastro de Itens de Compra
   Objetivo: Permitir o registro de compras realizadas pelos consumidores.
   Informações Requeridas:
   ID do Produto: Campo obrigatório que identifica unicamente o produto.
   Nome do Produto: Campo obrigatório que descreve o nome do produto.
   Quantidade: Campo obrigatório que indica a quantidade comprada.
   CPF do Comprador: Campo opcional que deve ser formatado com máscara (ex: XXX.XXX.XXX-XX).
   Valor Unitário do Produto: Campo obrigatório que informa o preço de cada unidade do produto.
   Data e Hora da Compra: Campo obrigatório que registra o momento da compra.
   Regra de Negócio: Um mesmo CPF não pode realizar a compra de mais de 3 unidades do mesmo produto.


2. # Pesquisa de Compras Realizadas
   Objetivo: Permitir que os usuários pesquisem compras anteriores com base em critérios específicos.
   
    Filtros Disponíveis:
       CPF do Comprador: Permite filtrar as compras por CPF.
       Nome do Produto: Permite filtrar as compras pelo nome do produto.
       Range de Data da Compra: Permite filtrar as compras dentro de um intervalo de datas.
   
    Regras de Negócio:
       A pesquisa não deve ser case sensitive.
       O termo de busca deve ter no mínimo 3 caracteres.
       O resultado deve incluir registros que contenham parcial ou totalmente o termo de busca.


3. # Relatório de Compras por Período
   Objetivo: Gerar um relatório que apresenta um resumo das compras realizadas em um determinado período.
   
    Informações no Relatório:
       Nome do Produto: Identificação dos produtos comprados.
       Valor Unitário do Produto: Preço de cada unidade.
       Quantidade de Compras Realizadas: Total de unidades compradas.
       Total Vendido: Cálculo do total em valor monetário das vendas realizadas para cada produto.
       Considerações Finais
       Este sistema de cadastro de compras não apenas facilita o registro e a consulta de transações, mas também assegura que as regras de negócio sejam seguidas, promovendo uma experiência de compra organizada e eficiente. A implementação da API REST permitirá integração com outras aplicações e serviços, ampliando a funcionalidade e a utilidade do sistem


