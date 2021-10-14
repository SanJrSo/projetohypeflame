package automacao.passos;

import automacao.core.Core;
import automacao.paginas.PaginaInicial;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;

public class PassosGerais extends Core {

    private final PaginaInicial paginaPaginaInicial;

    @Before()
    public void before(Scenario cenario) {
        setCenario(cenario);
    }

    @After()
    public void AfterFinal() {
        gerarEvidencia();
    }

    public PassosGerais() {
        paginaPaginaInicial = new PaginaInicial();
        PageFactory.initElements(driver, this.paginaPaginaInicial);
    }

    @Given("^o usuário acessou a página do blog$")
    public void o_usuário_acessou_a_página_do_blog() {
        acessarPagina(paginaPaginaInicial.getUrlPaginaInicial());
    }

    @And("^aguarda por \"([^\"]*)\" segundos$")
    public void aguarda_por_segundos(int segundos) {
        aguardarThreadSleep(segundos);
    }

    @And("^clicar no botão \"([^\"]*)\"$")
    public void clicar_no_botão(String botao) {
        clicarBotao(botao);
    }

}
