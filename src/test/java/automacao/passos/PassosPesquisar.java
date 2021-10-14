package automacao.passos;

import automacao.paginas.Pesquisar;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;

public class PassosPesquisar extends Pesquisar {

    private final Pesquisar paginaPesquisar;

    public PassosPesquisar() {
        paginaPesquisar = new Pesquisar();
        PageFactory.initElements(driver, this.paginaPesquisar);
    }

    @And("^digitar a informação \"([^\"]*)\" no campo pesquisar$")
    public void digitar_a_informação_no_campo_pesquisar(String informacao) {
        if (!informacao.isEmpty()) {
            digitar(paginaPesquisar.getCampoPesquisar(), informacao);
        }
    }

    @And("^clicar no pesquisar$")
    public void clicar_no_pesquisar() {
        aguardarElementoPresente(paginaPesquisar.getPesquisar());
        clicar(paginaPesquisar.getPesquisar());
    }

    @And("^está presente o artigo pesquisado$")
    public void está_presente_o_artigo_pesquisado() {
        aguardarElementoPresente(paginaPesquisar.getResultadoPesquisa());
    }

    @And("^clica no artigo apresentado$")
    public void clica_no_artigo_apresentado() {
        clicar(paginaPesquisar.getResultadoPesquisa());
    }

    @And("^está presente o titulo \"([^\"]*)\" do artigo$")
    public void está_presente_o_titulo_do_artigo(String texto) {
        verificarTexto(paginaPesquisar.getTituloArtigo(), texto);
    }

    @And("^está presente a pesquisa sem retorno com o texto \"([^\"]*)\"$")
    public void está_presente_a_pesquisa_sem_retorno_com_o_texto(String texto) {
        verificarTexto(paginaPesquisar.getPesquisaSemRetorno(), texto);
    }

}
