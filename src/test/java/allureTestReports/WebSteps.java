package allureTestReports;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebSteps {
  String sum = "2500";
  String plan = "Малыш";
  String result = "17.5";

  @Step("Устанавливаем страховую сумму")
  public void issueSumSet() {
    $(".formText").click();
    $(".formText").setValue(sum);
  }

  @Step("Выбираем вариант страхования")
  public void issuePlanSet() {
    $(".chzn-container").click();
    $(".chzn-results").$(byText(plan)).click();
  }

  @Step("Подтверждаем заполнение")
  public void issuePlanSubmit() {
    $(".formSub").click();
  }

  @Step("Верифицируем полученную сумму")
  public void paymentVerification() {
    $$(".infoblock").findBy(text(result)).shouldBe(visible);
  }
}
