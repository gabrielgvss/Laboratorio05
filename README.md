# Sistema de Gestão de Fretes

## Descrição

Este projeto é uma atividade avaliativa para o Laboratório de Banco de Dados, desenvolvido utilizando JPA (Java Persistence API) e Hibernate para mapeamento objeto-relacional. O sistema é projetado para gerenciar operações de frete e inclui a modelagem e estruturação das principais entidades.

## Entidades e Relacionamentos

O projeto foi modelado com as seguintes entidades e suas associações:

- **EntidadeBase**: Interface que define o método `getId` para identificar as entidades.
- **PessoaFisica**: Classe base para `Funcionario` e `Cliente`, representando uma pessoa física.
- **Funcionario**: Extende `PessoaFisica` e é associado a uma `Filial`. Inclui um conjunto de `Dependentes`.
- **Cliente**: Extende `PessoaFisica` e está associado a múltiplos `Fretes`.
- **Filial**: Representa uma filial e está associada a vários `Funcionarios`.
- **Veiculo**: Representa veículos e está associado a um `TipoVeiculo` e a vários `Fretes`.
- **TipoVeiculo**: Classifica diferentes tipos de veículos.
- **Frete**: Representa um frete e está associado a um `Veiculo`, um `Cliente`, uma `CategoriaFrete`, e duas `Cidades` (origem e destino). Inclui um conjunto de `ItemFretes`.
- **ItemFrete**: Representa itens dentro de um `Frete`.
- **CategoriaFrete**: Classifica diferentes categorias de frete.
- **Cidade**: Representa cidades, associadas a `Fretes` como origem e destino, e a `Distancias`.
- **Distancia**: Mede a distância entre duas cidades e pode incluir valores adicionais por quilômetro.


## Status do Projeto

Atualmente, o projeto está na fase de modelagem das entidades. Os relacionamentos e a estrutura das classes foram definidos, mas ainda precisam ser testados para garantir a integridade e funcionalidade do sistema.

## Próximos Passos

- **Teste dos Relacionamentos**: Verificar e validar os relacionamentos entre as entidades.
- **Implementação das Regras de Negócio**: Desenvolver a lógica de negócio para operações de frete.
- **Configuração e Persistência**: Configurar o Hibernate para persistência dos dados.
- **Desenvolvimento da Interface de Usuário**: Criar uma interface para interação com o sistema.

## Instruções de Uso

### Configuração do Ambiente

1. Clone o repositório.
2. Configure o banco de dados conforme as especificações do projeto.
3. Atualize as configurações de conexão no arquivo de configuração do Hibernate.

### Execução do Projeto

1. Compile o projeto utilizando seu IDE preferido ou ferramenta de build.
2. Execute a aplicação para verificar a estrutura das entidades e relacionamentos.

### Testes

1. Verifique a integridade e consistência das entidades e relacionamentos.

## Contribuições

Contribuições são bem-vindas! Se você encontrar bugs ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou submeter um pull request.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
