package allureTestReports;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.logevents.SelenideLogger.step;


public class LambdaStepTest extends TestBase {

  @CsvFileSource(resources = "/paramForCalc.csv")
  @ParameterizedTest
  void successfulSearchTest(String sum, String plan, String result) {

    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Устанавливаем страховую сумму", () -> {
      $(".formText").click();
      $(".formText").setValue(sum);
    });
    step("Выбираем вариант страхования", () -> {
      $(".chzn-container").click();
      $(".chzn-results").$(byText(plan)).click();
    });
    step("Подтверждаем заполнение", () -> {
      $(".formSub").click();
    });
    step("Сравниваем полученную сумму", () -> {
      $$(".infoblock").findBy(text(result)).shouldBe(visible);
    });

  }
}
