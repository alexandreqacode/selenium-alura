package leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesPage {
    private static final String URL_LEILOES = "http://localhost:8080/leiloes";
    private WebDriver browser;

    public LeiloesPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LEILOES);
    }

    public void fechar() {
        this.browser.quit();
    }

}
