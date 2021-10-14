@RealizarPesquisa

Feature: Realizar Pesquisa

  Scenario Outline: Realiza uma pesquisa existente e acessa o artigo

    Given o usuário acessou a página do blog
    When clicar no pesquisar
    And digitar a informação "<informacao>" no campo pesquisar
    And clicar no botão "Pesquisar"
    Then está presente o artigo pesquisado
    And clica no artigo apresentado
    And está presente o titulo "<titulo>" do artigo

    Examples:

      | informacao                          | titulo                              |
      | Ferramentas para testar o front-end | Ferramentas para testar o front-end |

  Scenario Outline: Realiza uma pesquisa sem retorno

    Given o usuário acessou a página do blog
    When clicar no pesquisar
    And digitar a informação "<informacao>" no campo pesquisar
    And clicar no botão "Pesquisar"
    Then está presente a pesquisa sem retorno com o texto "<texto>"

    Examples:

      | informacao  | texto                                                                                           |
      | uahshashsua | Não encontramos nada para estes termos de busca. Tente novamente com palavras-chave diferentes. |