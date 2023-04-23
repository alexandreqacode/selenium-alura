package leiloes;

import login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeiloesTest {

    private LeiloesPage paginaDeLeiloes;


    @AfterEach
    public void afterEach(){

        this.paginaDeLeiloes.fechar();
    }

    @Test
    public void deveCadastrarLeilao(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDelogin("fulano", "pass");
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
    }

}
