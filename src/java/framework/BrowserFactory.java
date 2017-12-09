package framework;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class BrowserFactory {
  private static WebDriver driver;
  private static String path = System.getProperty("user.dir");

  private BrowserFactory() {
  }

  public  static WebDriver getDriver() {
    PropertiesReader properties = new PropertiesReader();
    String browser = properties.getBrowser();
    String osName = System.getProperty("os.name");
    switch (browser) {
      case "CHROME":
        if (osName.contains("Windows")) {
          System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
        } else {
          System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
        }
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("download.default_directory", path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        break;

      case "FIREFOX":
        if (osName.contains("Windows")) {
          System.setProperty("webdriver.gecko.driver", "src\\resources\\geckodriver.exe");
        } else {
          System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver");
        }
        FirefoxOptions fireOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.dir", path);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream; application/x-debian-package;");
        fireOptions.setProfile(profile);
        driver = new FirefoxDriver(fireOptions);
        break;
      default:
        System.out.println("некоректный браузер");
        break;
    }
    driver.manage().timeouts().implicitlyWait(properties.getWaits(), TimeUnit.SECONDS);
    driver.manage().window().maximize();
    return driver;
  }
}
