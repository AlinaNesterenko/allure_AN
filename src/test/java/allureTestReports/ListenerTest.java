package allureTestReports;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class ListenerTest extends TestBase {

  String sum = "2500";
  String plan = "Малыш";
  String result = "17.5";


  @Test
  void successfulSearchTest() {

    SelenideLogger.addListener("allure", new AllureSelenide());
    $(".formText").click();
    $(".formText").setValue(sum);
    $(".chzn-container").click();
    $(".chzn-results").$(byText(plan)).click();
    $(".formSub").click();
    $$(".infoblock").findBy(text(result)).shouldBe(visible);

  }
}
