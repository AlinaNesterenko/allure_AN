package alluretestreports;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class ScreenShotTest extends alluretestreports.TestBase {
  @Test
  void successfulSearchTest() {

    SelenideLogger.addListener("allure", new AllureSelenide());
    alluretestreports.WebStepsScreenShot steps = new alluretestreports.WebStepsScreenShot();

    steps.issueSumSet();
    steps.issuePlanSet();
    steps.issuePlanSubmit();
    steps.paymentVerification();
  }
}
