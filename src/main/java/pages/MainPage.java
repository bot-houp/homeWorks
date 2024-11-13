package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
  By cookieButtonAgree = By.id("cookie-agree");

  public By onlineReplenishment = By.xpath("//div[@class='pay__wrapper']/h2");
  public By logos = By.xpath("//img[contains(@src, '/local/templates/new_design/assets/html/images/pages/index/pay/')]");
  public By moreInfoLink = By.linkText("Подробнее о сервисе");

  public By phoneNumber = By.id("connection-phone");
  public By connectionSumTotal = By.id("connection-sum");
  public By connectionEmail = By.id("connection-email");
  public By continueButton = By.cssSelector("button.button__default[type='submit']");
  public By paymentGateway = By.className("bepaid-iframe");

  public By listPaymentType = By.className("select__header");

  public By homeInternet = By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]");
  public By subscriberNumber = By.id("internet-phone");
  public By internetSumTotal = By.id("internet-sum");
  public By internetEmail = By.id("internet-email");

  public By installmentPlan = By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]");
  public By accountInstallment = By.id("score-instalment");
  public By instalmentSumTotal = By.id("instalment-sum");
  public By instalmentEmail = By.id("instalment-email");

  public By debt = By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]");
  public By accountDebt = By.id("score-arrears");
  public By debtSumTotal = By.id("arrears-sum");
  public By debtEmail = By.id("arrears-email");


  private final WebDriver driver;
  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  public void acceptCookie() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    try {
      wait.until(ExpectedConditions.elementToBeClickable(cookieButtonAgree));
      driver.findElement(cookieButtonAgree).click();
    } catch (TimeoutException e) {
      System.out.println("Окно с куки не появилось");
    }
  }

  public WebElement waitAndGetElement(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void getAndClickElement(By locator) {
    driver.findElement(locator).click();
  }

  public MainPage typePhoneNumber(String phone) {
    driver.findElement(phoneNumber).sendKeys(phone);
    return this;
  }

  public MainPage typeSumTotal(String sum) {
    driver.findElement(connectionSumTotal).sendKeys(sum);
    return this;
  }

  public MainPage typeEmail(String mail) {
    driver.findElement(connectionEmail).sendKeys(mail);
    return this;
  }

  public WebElement fillUpPayForm(String phone, String sum, String email) {
    typePhoneNumber(phone);
    typeSumTotal(sum);
    typeEmail(email);
    driver.findElement(continueButton).click();
    return waitAndGetElement(paymentGateway);
  }

  public String findAngGetAttribute(By locator, String attribute) {
    return driver.findElement(locator).getAttribute(attribute);
  }

  public List<WebElement> logosMain() {
    return driver.findElements(logos);
  }
}

