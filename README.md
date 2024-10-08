# Sistema de Gestão de Fretes

## Descrição

Este projeto é uma atividade avaliativa para o Laboratório de Banco de Dados, desenvolvido utilizando JPA (Java Persistence API) e Hibernate para mapeamento objeto-relacional. O sistema é projetado para gerenciar operações de frete e inclui a modelagem e estruturação das principais entidades, assim como desenvolvimento de seus repositórios e serviços.

## Diagrama de Classes:
![Diagrama de Classes do Projeto](https://github.com/gabrielgvss/Laboratorio05/blob/main/img_lab05.jpg)

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

Atualmente, o projeto teve seu código de prototipação concluído, porém carece de testagens.


## Próximos Passos

- **Testagem**: FICA A ENCARGO A TESTAGEM DA CAMADA DE REPOSITORY E DO SERVICE

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
