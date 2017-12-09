package framework.elements;

import framework.BaseEntity;
import framework.PropertiesReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class BaseElement extends BaseEntity {

  private WebElement element;
  private By locator;
  private static WebDriver driver = currentBrowser.returnDriver();
  private PropertiesReader properties = new PropertiesReader();
  private WebDriverWait wait = new WebDriverWait(driver, properties.getWaitsForElemetns());

  public BaseElement(By locator) {
    this.locator = locator;
  }

  public Boolean waitForstaleness() {
    return wait.until(ExpectedConditions.stalenessOf(getElement()));
  }

  public WebElement getElement() {
    element = driver.findElement(locator);
    return element;
  }

  public boolean isEnabled() {
    try {
      driver.findElement(locator).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }

  public void click() {
    element = driver.findElement(locator);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
  }

  public void moveToElement() {
    element = driver.findElement(locator);
    Actions act = new Actions(driver);
    act.moveToElement(getElement()).perform();
  }

  public String getText() {
    element = driver.findElement(locator);
    wait.until(ExpectedConditions.elementToBeClickable(element));
    return getElement().getText();
  }

  public int getSizeOfList() {
    return  driver.findElements(locator).size();
  }
}




