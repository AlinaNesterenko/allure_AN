package alluretestreports;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class AnnotationStepTest extends TestBase {

  @Test
  void successfulSearchTest() {

    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.issueSumSet();
    steps.issuePlanSet();
    steps.issuePlanSubmit();
    steps.paymentVerification();
  }
}
