<h1 align="center">Projeto Drone Feeder</h1>

## Descrição do Projeto
<p>Foi desenvolvido o projeto de back end em java com spring-boot. Nesse projeto, busca-se informações de drones e adiciona os mesmos no banco de dados MySql</p>

## Como rodar esse projeto localmente
1. Clone o repositório
  * Por exemplo: `git clone git@github.com:drone-feeder.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd drone-feeder`

2. Instale as dependências:
    * `mvn install`

3. Rode o comando do spring para subir a api
    * `mvn spring-boot:run`

## Features

  - [ ] Cadastro de drones
  - [ ] Cadastro de entregas dos drones

## Rotas da Api

  <p>Na rota abaixo é possivel criar um drone atraves da requisição POST, sendo opcional informar o nome do drone no corpo da requisição.</p>

    `http://localhost:8080/drone/create`

    ou

    `http://localhost:8080/drone/create/nome`

  É possível buscar todos os drones cadastrados na api, atraves da requisição GET na rota abaixo:
  
    `http://localhost:8080/drone/all`

  Com a requisição GET, nessa rota será possivel buscar um drone pelo id e visualizar todas as informações do mesmo.
    
    `http://localhost:8080/drone/1`

  Atravès da requisição PATCH é possível buscar e atualizar as informaçẽs de um drone.
    
    `http://localhost:8080/drone/update/1`

  Caso queira deletar um drone da api, deve-se utilizar essa rota com a requisição DELETE.
    
    `http://localhost:8080/drone/delete/1`

  Para criar entregas, basta acessar a rota abaixo com a requisição POST:

    `http://localhost:8080/delivery/create`

  E para visualizar todas as entregas, acessar a rota abaixo com a requisição GET:

    `http://localhost:8080/delivery/all`

  Na rota abaixo, com a requisição GET é possivel verificar o status de uma entrega passando o id da entrega como parametro:

    `http://localhost:8080/delivery/recebido/1`