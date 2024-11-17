import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ChromeTest {

  static WebDriver driver;

  public static void acceptCookie() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    try {
      wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
      WebElement cookieButton = driver.findElement(By.id("cookie-agree"));
      cookieButton.click();
    } catch (TimeoutException e) {
      System.out.println("Окно с куки не появилось");
    }
  }

  @BeforeEach
  void setupClass() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");
    driver = new ChromeDriver(options);
    driver.get("https://www.mts.by/");

    ChromeTest.acceptCookie();
  }

 @AfterEach
 void teardown() {
    driver.quit();
  }

  @Test
  @DisplayName("Проверка названия блока")
  void checkPayFormName() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement onlineReplenishment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2")));
    Assertions.assertEquals(onlineReplenishment.getText(), "Онлайн пополнение\nбез комиссии", "Текст не совпал.");
  }

  @Test
  @DisplayName("Наличие логотипов платёжных систем")
  void checkPresencePaymentLogo() {
    List<WebElement> logos = driver.findElements(By.xpath("//img[contains(@src, '/local/templates/new_design/assets/html/images/pages/index/pay/')]"));
    Assertions.assertEquals(5, logos.size(), "Логотип(ы) платёжных систем не найден(ы) по локатору.");

    assertAll("Наличие логотипов",
        () -> assertTrue(logos.get(0).isDisplayed(),
            "Не отобразился логотип" + logos.get(0).getAttribute("alt")),
        () -> assertTrue(logos.get(1).isDisplayed(),
            "Не отобразился логотип" + logos.get(1).getAttribute("alt")),
        () -> assertTrue(logos.get(2).isDisplayed(),
            "Не отобразился логотип" + logos.get(2).getAttribute("alt")),
        () -> assertTrue(logos.get(3).isDisplayed(),
            "Не отобразился логотип" + logos.get(3).getAttribute("alt")),
        () -> assertTrue(logos.get(3).isDisplayed(),
            "Не отобразился логотип" + logos.get(4).getAttribute("alt"))
    );
  }

  @Test
  @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
  void clickMoreInfoLink() {
    WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
    moreInfoLink.click();
    Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Ссылка «Подробнее о сервисе» не работает");
  }

  @Test
  @DisplayName("Заполнение формы и проверка работы кнопки «Продолжить»")
  void testFormSubmission() {
    WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
    phoneNumber.click();
    phoneNumber.sendKeys("297777777");

    WebElement sumTotal = driver.findElement(By.id("connection-sum"));
    sumTotal.click();
    sumTotal.sendKeys("100");

    WebElement email = driver.findElement(By.id("connection-email"));
    email.click();
    email.sendKeys("ivan@gmail.com");

    WebElement continueButton = driver.findElement(By.cssSelector("button.button__default[type='submit']"));
    continueButton.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Assertions.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-app"))).isEnabled(), "Платёжный шлюз не появился.");
  }
}
