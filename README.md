CONTROLE DE LOCADORA VHS

Este projeto foi desenvolvido para o controle de uma locadora de fitas VHS, com funcionalidades básicas de cadastro, edição, listagem e exclusão de categorias e fitas.
O objetivo foi praticar conceitos de desenvolvimento web usando Java com Spring Boot e Thymeleaf.

Tecnologias Utilizadas:

Java 17
Spring Boot;
Thymeleaf para as views/templates;
Maven para gerenciamento de dependências e build;
Git e GitHub para controle de versão e entrega;

Funcionalidades Implementadas:

Cadastro, edição, listagem e exclusão de Categorias;
Cadastro, edição, listagem e exclusão de fitas VHS;
Integração com banco de dados via JPA/Hibernate;
Uso de submódulo Git para organizar o código;
Processo de Desenvolvimento;

Como estudante, enfrentei desafios principalmente na implementação das views com Thymeleaf, especialmente para exibir e atualizar os dados corretamente entre frontend e backend.
O desenvolvimento foi feito utilizando a arquitetura MVC, separando claramente as responsabilidades entre Model, View e Controller. 
Também aprendi a trabalhar com submódulos Git, que foram importantes para organizar o projeto.

Como baixar e executar o projeto:

Para baixar o projeto, clone o repositório principal com os submódulos usando o comando git clone com a opção --recurse-submodules. 
Depois entre na pasta do submódulo chamado "controledelocadoravhs". 
Para executar o projeto, use o Maven para rodar a aplicação com o comando mvn spring-boot:run. Após iniciar, abra o navegador e acesse o endereço http://localhost:8080 para usar a aplicação.

http://localhost:8080/vhs
http://localhost:8080/vhs/form
http://localhost:8080/categoria
http://localhost:8080/categoria/form

Resultados Obtidos:

Projeto funcional com as principais operações CRUD para fitas VHS e categorias.
Aprendizado prático sobre Spring Boot, Thymeleaf e controle de versão com Git e submódulos.
Experiência em organização e documentação de projetos para entrega acadêmica.
