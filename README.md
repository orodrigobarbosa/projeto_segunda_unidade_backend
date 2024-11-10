API simples para criar Usuários com Spring Boot 3, Java 17 e gRPC
A API oferece endpoints para criar usuários, listar todos os usuários e realizar consultas com streaming.

Tecnologias Utilizadas
Java 17 (LTS)
Spring Boot 3 (Framework para construção da API)
gRPC (Framework para comunicação de alto desempenho, baseado em HTTP/2 - e retorna uma sequência de mensagens)
Maven (Gerenciador de dependências)

Funcionalidades
A API oferece três funcionalidades principais:

Criar Usuário: Cria um novo usuário no sistema.
Buscar Usuários: Retorna uma lista com todos os usuários cadastrados.
Buscar Usuários e Retorna os usuários utilizando gRPC com streaming (útil para grandes volumes de dados). Este método implementa a interface de um serviço gRPC que processa uma requisição do tipo EmptyReq e envia uma resposta do tipo UsuarioRes. 
O método é usado para retornar uma sequência de mensagens de UsuarioRes (streaming de servidor).
Especificamente, ele é parte de uma implementação de serviço que retorna uma sequência de respostas para um cliente.

Utilizando o Postman para teste:
O Postman oferece possibilidade de testar operações gRPC utilizando por padrão a porta 0.0.0.0:9090  e importando o arquivo proto criado no projeto.
