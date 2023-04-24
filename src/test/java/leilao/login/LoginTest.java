package leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){
        this.paginaDeLogin = new LoginPage();
    }
    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveEfetuarLoginComDadosValidos(){
        paginaDeLogin.preencheFormularioDelogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();

        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveLogarComDadosInvalidos(){
        paginaDeLogin.preencheFormularioDelogin("invalido", "456");
        paginaDeLogin.efetuaLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        Assert.assertNull("fulano", paginaDeLogin.getNomeUsuarioLogado());
        Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));

    }

    @Test
    public void naoDeveAcessarPaginaRestritaSemEstarLogado(){
        paginaDeLogin.navegaParaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }


}