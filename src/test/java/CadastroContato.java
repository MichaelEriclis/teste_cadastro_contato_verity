import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class CadastroContato {

    @Test
    public void registroContatoComSucesso() {

        Configuration.timeout = 10000;

        isChrome();
        open("https://www.verity.com.br/");
        String image = "//*[@alt='caixa3.png']";
        $(By.xpath(image)).waitUntil(visible, 5000);
        screenshot("site");
        $("a[href^=javascript]").click();
        $("#comp-kd4lt62k").shouldHave(text("Contato"));
        $(By.linkText("Contato")).scrollIntoView(true);
        screenshot("Menu");
        $(By.linkText("Contato")).click();
        $("span[style='font-size:24px;']").waitUntil(visible, 3000);
        $(By.xpath("//span[contains(text(),'+55 11 5096-2164')]")).scrollIntoView(true);
        $("input[placeholder='Nome Completo']").setValue("Michael Ericlis");
        $("input[placeholder='Empresa']").setValue("Verity");
        $("input[placeholder='Fone']").setValue("11980338038");
        $("textarea[placeholder='Mensagem']").setValue("Obrigado");
        $("input[placeholder='E-mail']").setValue("michael@teste.com");
        screenshot("cadastro preenchido");
        $("textarea[placeholder='Mensagem']").scrollIntoView(true);
        screenshot("Enviar");
        $(By.id("comp-jt789auflabel")).click();
        $("span[style='color:#0062BA;'/*'Mensagem enviada com sucesso!']").shouldBe(visible);
        screenshot("Teste Concluido com sucesso");

    }
}

