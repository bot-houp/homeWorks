package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CardDetailsForm {
  public By sumTotal = By.xpath("//span[contains(text(), 'BYN')]");
  public By payButton = By.className("colored");
  public By payDescription = By.xpath("//span[contains(text(), 'Номер:')]");
  public By fieldCardNumber = By.id("cc-number");
  public By cardNumber = By.xpath("//label[contains(text(),'Номер карты')]");
  public By validityPeriod = By.xpath("//label[contains(text(),'Срок действия')]");
  public By fieldCvc = By.xpath("//label[contains(text(),'CVC')]");
  public By holderName = By.xpath("//label[contains(text(),'Имя держателя (как на карте)')]");
  public By smallLogos = By.xpath("//img[contains(@src, 'assets/images/payment-icons/card-types/')]");


  private final WebDriver driver;
  public CardDetailsForm(WebDriver driver) {
    this.driver = driver;
  }

  public String waitAngGetText(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
  }

  public List<WebElement> waitAndGetElements(By field, By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(field));
    return driver.findElements(locator);
  }
}
