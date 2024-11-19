import static io.qameta.allure.SeverityLevel.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CardDetailsForm;
import pages.MainPage;

class ChromeTest {

  static WebDriver driver;
  MainPage mainPage;
  CardDetailsForm cardDetailsForm;

  @BeforeEach
  void setupClass() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    driver = new ChromeDriver(options);
    driver.get("https://www.mts.by/");

    mainPage = new MainPage(driver);
    mainPage.acceptCookie();

    cardDetailsForm = new CardDetailsForm(driver);
  }

 @AfterEach
 void teardown() {
    driver.quit();
  }

  @Test
  @DisplayName("Проверка названия блока")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-11")
  @Severity(MINOR)
  void checkPayFormName() {
    WebElement payForm = mainPage.waitAndGetElement(mainPage.onlineReplenishment);
    Assertions.assertEquals(payForm.getText(), "Онлайн пополнение\nбез комиссии", "Текст не совпал.");
  }

  @Test
  @DisplayName("Наличие логотипов платёжных систем (главная страница)")
  @Severity(TRIVIAL)
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-12")
  void checkPresencePaymentLogo() {
    List<WebElement> logosMain = driver.findElements(mainPage.logos);
    Assertions.assertEquals(5, logosMain.size(),
        "Логотип(ы) платёжных систем не найден(ы) по локатору.");

    assertAll("Наличие логотипов",
        () -> assertTrue(logosMain.get(0).isDisplayed(),
            "Не отобразился логотип" + logosMain.get(0).getAttribute("alt")),
        () -> assertTrue(logosMain.get(1).isDisplayed(),
            "Не отобразился логотип" + logosMain.get(1).getAttribute("alt")),
        () -> assertTrue(logosMain.get(2).isDisplayed(),
            "Не отобразился логотип" + logosMain.get(2).getAttribute("alt")),
        () -> assertTrue(logosMain.get(3).isDisplayed(),
            "Не отобразился логотип" + logosMain.get(3).getAttribute("alt")),
        () -> assertTrue(logosMain.get(3).isDisplayed(),
            "Не отобразился логотип" + logosMain.get(4).getAttribute("alt"))
    );
  }

  @Test
  @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-13")
  @Severity(MINOR)
  void clickMoreInfoLink() {
    mainPage.getAndClickElement(mainPage.moreInfoLink);
    Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Ссылка «Подробнее о сервисе» не работает");
  }

  @Test
  @DisplayName("Проверка плейсхолдеров в форме «Онлайн пополнение» (вид оплаты - услуги связи)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-14")
  @Severity(MINOR)
  void checkPlaceholdersCommunicationServices() {
    assertAll("",
        () -> assertEquals("Номер телефона", mainPage.findAngGetAttribute(mainPage.phoneNumber, "placeholder"), "Текст плейсхолдера не совпадает с «Номер телефона»."),
        () -> assertEquals("Сумма", mainPage.findAngGetAttribute(mainPage.connectionSumTotal, "placeholder"), "Текст плейсхолдера не совпадает с «Сумма»."),
        () -> assertEquals("E-mail для отправки чека", mainPage.findAngGetAttribute(mainPage.connectionEmail, "placeholder"), "Текст плейсхолдера не совпадает с «E-mail для отправки чека».")
    );
  }

  @Test
  @DisplayName("Проверка плейсхолдеров в форме «Онлайн пополнение» (вид оплаты - домашний интернет)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-15")
  @Severity(MINOR)
  void checkPlaceholdersHomeInternet() {
    mainPage.getAndClickElement(mainPage.listPaymentType);
    mainPage.getAndClickElement(mainPage.homeInternet);

    assertAll("",
        () -> assertEquals("Номер абонента", mainPage.findAngGetAttribute(mainPage.subscriberNumber, "placeholder"), "Текст плейсхолдера не совпадает с «Номер абонента»."),
        () -> assertEquals("Сумма", mainPage.findAngGetAttribute(mainPage.internetSumTotal, "placeholder"), "Текст плейсхолдера не совпадает с «Сумма»."),
        () -> assertEquals("E-mail для отправки чека", mainPage.findAngGetAttribute(mainPage.internetEmail, "placeholder"), "Текст плейсхолдера не совпадает с «E-mail для отправки чека».")
    );
  }

  @Test
  @DisplayName("Проверка плейсхолдеров в форме «Онлайн пополнение» (вид оплаты - рассрочка)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-16")
  @Severity(MINOR)
  void checkPlaceholdersInstallmentPlan() {
    mainPage.getAndClickElement(mainPage.listPaymentType);
    mainPage.getAndClickElement(mainPage.installmentPlan);

    assertAll("",
        () -> assertEquals("Номер счета на 44", mainPage.findAngGetAttribute(mainPage.accountInstallment, "placeholder"), "Текст плейсхолдера не совпадает с «Номер счета на 44»."),
        () -> assertEquals("Сумма", mainPage.findAngGetAttribute(mainPage.instalmentSumTotal, "placeholder"), "Текст плейсхолдера не совпадает с «Сумма»."),
        () -> assertEquals("E-mail для отправки чека", mainPage.findAngGetAttribute(mainPage.instalmentEmail, "placeholder"), "Текст плейсхолдера не совпадает с «E-mail для отправки чека».")
    );
  }

  @Test
  @DisplayName("Проверка плейсхолдеров в форме «Онлайн пополнение» (вид оплаты - задолженность)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-17")
  @Severity(MINOR)
  void checkPlaceholdersDebt() {
    mainPage.getAndClickElement(mainPage.listPaymentType);
    mainPage.getAndClickElement(mainPage.debt);

    assertAll("",
        () -> assertEquals("Номер счета на 2073", mainPage.findAngGetAttribute(mainPage.accountDebt, "placeholder"), "Текст плейсхолдера не совпадает с «Номер счета на 2073»."),
        () -> assertEquals("Сумма", mainPage.findAngGetAttribute(mainPage.debtSumTotal, "placeholder"), "Текст плейсхолдера не совпадает с «Сумма»."),
        () -> assertEquals("E-mail для отправки чека", mainPage.findAngGetAttribute(mainPage.debtEmail, "placeholder"), "Текст плейсхолдера не совпадает с «E-mail для отправки чека».")
    );
  }

  @Test
  @DisplayName("Заполнение формы и проверка работы кнопки «Продолжить»")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-18")
  @Severity(BLOCKER)
  void testFormSubmission() {
    Assertions.assertTrue(mainPage.fillUpPayForm("297777777", "100", "ivan@gmail.com").isEnabled(), "Платёжный шлюз не появился.");
  }

  @Test
  @DisplayName("Корректность отображения суммы на форме с данными карты (хэдер)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-19")
  @Severity(BLOCKER)
  void checkCorrectnessSumTotalHeader() {
    String sumTotalExpected = "101.5";
    driver.switchTo().frame(mainPage.fillUpPayForm("297777777", sumTotalExpected, "ivan@gmail.com"));
    String sumTotalActual = cardDetailsForm.waitAngGetText(cardDetailsForm.sumTotal);
    assertEquals(Float.parseFloat(sumTotalExpected), Float.parseFloat(sumTotalActual.replaceAll("[^\\d.]", "")), "Введённая сумма не совпадает с отображаемой на форме");
  }

  @Test
  @DisplayName("Корректность отображения суммы на форме с данными карты (кнопка)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-20")
  @Severity(BLOCKER)
  void checkCorrectnessSumTotalButton() {
    String sumTotalExpected = "101.5";
    driver.switchTo().frame(mainPage.fillUpPayForm("297777777", sumTotalExpected, "ivan@gmail.com"));
    String sumTotalActual = cardDetailsForm.waitAngGetText(cardDetailsForm.payButton);
    assertEquals(Float.parseFloat(sumTotalExpected), Float.parseFloat(sumTotalActual.replaceAll("[^\\d.]", "")), "Введённая сумма не совпадает с отображаемой на кнопке");
  }

  @Test
  @DisplayName("Корректность отображения номера телефона на форме с данными карты")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-21")
  @Severity(CRITICAL)
  void checkCorrectnessPhoneNumber() {
    String phoneNumberExpected = "297777777";
    driver.switchTo().frame(mainPage.fillUpPayForm(phoneNumberExpected, "123.4","ivan@gmail.com"));
    String phoneNumberActual = cardDetailsForm.waitAngGetText(cardDetailsForm.payDescription);
    assertEquals("Оплата: Услуги связи Номер:375" + phoneNumberExpected, phoneNumberActual, "Введённый номер телефона не совпадает с отображаемым на форме");
  }

  @Test
  @DisplayName("Проверка плейсхолдеров в форме c данными карты")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-22")
  @Severity(MINOR)
  void checkPlaceholdersCardDetailsForm() {
    driver.switchTo().frame(mainPage.fillUpPayForm("297777777", "123.4","ivan@gmail.com"));

    assertAll("",
        () -> assertEquals("Номер карты", cardDetailsForm.waitAngGetText(cardDetailsForm.cardNumber), "Текст плейсхолдера не совпадает с «Номер карты»."),
        () -> assertEquals("Срок действия", cardDetailsForm.waitAngGetText(cardDetailsForm.validityPeriod), "Текст плейсхолдера не совпадает с «Срок действия»."),
        () -> assertEquals("CVC", cardDetailsForm.waitAngGetText(cardDetailsForm.fieldCvc), "Текст плейсхолдера не совпадает с «CVC»."),
        () -> assertEquals("Имя держателя (как на карте)", cardDetailsForm.waitAngGetText(cardDetailsForm.holderName), "Текст плейсхолдера не совпадает с «Имя держателя (как на карте)».")
    );
  }

  @Test
  @DisplayName("Наличие логотипов платёжных систем (форма с данными карты)")
  @Epic("Онлайн пополнение")
  @Issue("ONREPL-23")
  @Severity(TRIVIAL)
  void checkPresenceCardDetailsLogo() {
    driver.switchTo().frame(mainPage.fillUpPayForm("297777777", "123.4","ivan@gmail.com"));

    List<WebElement> logosCardDetails = cardDetailsForm.waitAndGetElements(cardDetailsForm.fieldCardNumber, cardDetailsForm.smallLogos);
    Assertions.assertEquals(5, logosCardDetails.size(), "Логотип(ы) платёжных систем не найден(ы) по локатору.");

    assertAll("Наличие логотипов",
        () -> assertTrue(logosCardDetails.get(0).isDisplayed(), "Не отобразилась иконка" + logosCardDetails.get(0).getAttribute("src")),
        () -> assertTrue(logosCardDetails.get(1).isDisplayed(), "Не отобразилась иконка" + logosCardDetails.get(1).getAttribute("src")),
        () -> assertTrue(logosCardDetails.get(2).isDisplayed(), "Не отобразилась иконка" + logosCardDetails.get(2).getAttribute("src")),
        () -> assertTrue(logosCardDetails.get(3).isDisplayed(), "Не отобразилась иконка" + logosCardDetails.get(3).getAttribute("src")),
        () -> assertTrue(logosCardDetails.get(3).isDisplayed(), "Не отобразилась иконка" + logosCardDetails.get(4).getAttribute("src"))
    );
  }
}
