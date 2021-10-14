**Projeto de automação de testes web na linguagem Java com Maven usando:**

Junit 4.13.2

Cucumber 6.10.2

Selenium WebDriver 3.141.59

Projeto rodando no ChromeDriver 94.0.4606.81
Para outras versões do Chrome trocar o chromedriver na pasta drivers do projeto.

ChromeDriver Download: http://chromedriver.chromium.org/downloads


Projeto rodando no Mozilla Firefox 87.0
Para outras versões do Mozilla Firefox trocar o geckodriver na pasta drivers do projeto.

Geckodriver Download: https://github.com/mozilla/geckodriver/releases

**Executando os testes**

Para baixar as dependências e rodar os testes pela primeira vez, executar o comando maven clean install

Para definir qual navegador utilizar na automação, alterar a informação do arquivo browser da pasta properties
conforme opções:
* chrome
* firefox

Para rodar a automação desejada, dentro da pasta casoDeTestes possui a feature sendo a mesma possui uma tag, insira tag da feature dentro do arquivo "Run"

**Relatório de execução**

O relatório do Cucumber de execução dos testes, está localizado em target/cucumber-html-report.html, após execução da automação abrir o relatório em algum navegador
