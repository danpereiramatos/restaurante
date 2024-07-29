# API de Autoatendimento para Restaurante
### Descrição
Este projeto tem como objetivo atender aos requisitos do Tech Challenge da pós-graduação em Software Architecture da FIAP. O desafio consiste em desenvolver uma API de autoatendimento para autoatendimento ao cliente de um restaurante.

A API utiliza a arquitetura clean architecture, essa arquitetura proporciona uma base sólida para construir aplicações robustas e de fácil manutenção, sendo amplamente utilizada em projetos de software modernos.

1. Entities: Contém as regras de negócio mais genéricas e de alto nível. Elas podem ser reutilizadas em diferentes sistemas, se necessário.

2. Use Cases: Contém casos de uso específicos da aplicação. Define as operações que podem ser realizadas pelo sistema e coordena o fluxo de dados entre as entidades.

3. Interface Adapters: Converte os dados entre os formatos usados pelos casos de uso e os formatos necessários pela interface externa (bancos de dados, web, etc.).

4. Frameworks and Drivers: Inclui detalhes técnicos, como frameworks e bibliotecas que são usados pelo sistema. Esta camada é onde entram os detalhes de implementação.

## Stack utilizada

**Linguagem principal:** Java 17 com Maven

**Web:** Spring Boot, Lombok

**Banco de Dados:** PostgresSQL e Flyway para versionamento do banco

**Infra:** Kubernetes provisionado pelo Docker, versão v1.29.2.

## Rodando o projeto via Docker

1. Raiz do projeto execute o comando abaixo para subir os containers:

```bash
  docker-compose up --build
```
Caso não queira bloquear o console, adicione a flag **-d** ao final do comando

2. Após a instalação, a documentação Swagger da API pode encontrada no seguinte link:

[http://localhost:8080/restaurante/swagger-ui/index.html](http://localhost:8080/restaurante/swagger-ui/index.html)


## Instalação usando Kubernetes

##### ⚠️ Atenção: recomenda-se usar as mesmas tecnologias especificadas na Stack para a criação do cluster, conforme descrito neste readme.

1. O primeiro passo é configurar o Docker Desktop para habilitar o suporte ao Kubernetes. Link do artigo de configuração recomendado [https://www.docker.com/blog/how-kubernetes-works-under-the-hood-with-docker-desktop/](https://www.docker.com/blog/how-kubernetes-works-under-the-hood-with-docker-desktop/)


2. Após a configuração, na raiz do projeto, execute o comando que irá iniciar o conjunto de arquivos necessários para o funcionamento do serviço do banco de dados.
```bash
  kubectl apply -f .\k8s\db\
```

3. Em seguida, execute o comando que iniciará o funcionamento da API.
```bash
 kubectl apply -f .\k8s\api\ 
```

4. Após a instalação, a documentação Swagger da API pode encontrada no seguinte link:

[http://localhost:30000/restaurante/swagger-ui/index.html](http://localhost:30000/restaurante/swagger-ui/index.html)

## 🔗 Links
[![miro](https://img.shields.io/badge/Miro-050038.svg?style=for-the-badge&logo=Miro&logoColor=white)](https://miro.com/app/board/uXjVKM_0wdE=/?share_link_id=239546560997)

Link para o Miro do desenho K8S: 
https://miro.com/welcomeonboard/VklVNW1Ld3R0RHd0dWpQV0xTSjR1NzdDazBoaXdqNzdvT1Z3bkx1Y3l5OHFaRmZPbmJtNDZWVGxKZTR0aGFDSnwzNDU4NzY0NTM5MjI3NTAxMDE3fDI=?share_link_id=738735337519
Desenho do K8S ![img_1.png](img_1.png)
Desenho da Solução ![img_2.png](img_2.png)


[![trello](https://img.shields.io/badge/Trello-0052CC.svg?style=for-the-badge&logo=Trello&logoColor=white)](https://trello.com/b/66MzITVs/techchalleng-desafio-restaurante)
## TIme de desenvolvedores

- [@danpereiramatos](https://www.github.com/danpereiramatos)
- [@samuelmteixeira](https://www.github.com/samuelmteixeira)
- [@kaiquesantos98](https://www.github.com/KaiqueSantos98)
- [@jjbazagajr](https://www.github.com/jjbazagajr)
- [@leandroibraim](https://www.github.com/leandroibraim)