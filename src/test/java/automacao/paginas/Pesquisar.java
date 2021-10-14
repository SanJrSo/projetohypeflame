package automacao.paginas;

import automacao.core.Core;
import org.openqa.selenium.By;

public class Pesquisar extends Core {

    public By getPesquisar() {
        return getById("header-search");
    }
    public By getCampoPesquisar() {
        return getByCss("input[title='Pesquisar por:']");
    }

    public By getResultadoPesquisa() {
        return getById("post-780");
    }

    public By getTituloArtigo() {
        return getByCss("h1[class='entry-title sm:th-text-7xl th-text-4xl']");
    }

    public By getPesquisaSemRetorno() {
        return getByCss("div[class='archive-description th-max-w-base']");
    }
}

