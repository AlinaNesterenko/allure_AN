package allureTestReports;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.pageLoadStrategy = "eager";
  }

  @BeforeEach
  void beforeEach() {
    open("https://bgs.by/calc/medical/occur/");
  }

  @AfterEach
  void afterEach() {
    Selenide.closeWebDriver();
  }

}
