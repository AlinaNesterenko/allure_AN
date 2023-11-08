package allureTestReports;

import org.junit.jupiter.api.Test;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;

public class ScreenShotTest extends TestBase {
  @Test
  void successfulSearchTest() {

    SelenideLogger.addListener("allure", new AllureSelenide());
    WebStepsScreenShot steps = new WebStepsScreenShot();

    steps.issueSumSet();
    steps.issuePlanSet();
    steps.issuePlanSubmit();
    steps.paymentVerification();
  }
}
