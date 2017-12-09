package framework;

import org.openqa.selenium.WebDriver;

import static framework.BrowserFactory.getDriver;

public class Browser {

  private static WebDriver driver;
  private static Browser instance = null;

  public static Browser getInstance() {
    if (instance == null) {
      instance = new Browser();
      driver = getDriver();
    }
    return instance;
  }

  public static WebDriver returnDriver() {
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
  }

  public void navigateSteam(String url) {
    driver.get(url);
  }
}
