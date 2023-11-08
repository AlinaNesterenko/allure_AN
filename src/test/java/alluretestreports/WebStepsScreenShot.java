package alluretestreports;

import java.nio.charset.StandardCharsets;

import com.codeborne.selenide.WebDriverRunner;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebStepsScreenShot {

  static String sum = "2500";
  static String plan = "Малыш";
  static String result = "17.5";

  @Step("Устанавливаем страховую сумму")
  public void issueSumSet() {
    $(".formText").click();
    $(".formText").setValue(sum);
    Allure.getLifecycle().addAttachment("Исходники страницы", "text/html", "html", WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
  }

  @Step("Выбираем вариант страхования")
  public void issuePlanSet() {
    $(".chzn-container").click();
    $(".chzn-results").$(byText(plan)).click();
    Allure.getLifecycle().addAttachment("Исходники страницы", "text/html", "html", WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
  }

  @Step("Подтверждаем заполнение")
  public void issuePlanSubmit() {
    $(".formSub").click();
    Allure.getLifecycle().addAttachment("Исходники страницы", "text/html", "html", WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
  }

  @Step("Верифицируем полученную сумму")
  public void paymentVerification() {
    $$(".infoblock").findBy(text(result)).shouldBe(visible);
    Allure.getLifecycle().addAttachment("Исходники страницы", "text/html", "html", WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
  }
}
