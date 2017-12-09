package steam.forms;

import framework.BasePage;
import framework.Browser;
import framework.PropertiesReader;
import framework.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public class DownloadSteamPage extends BasePage {

  private Button steamDownload = new Button(By.xpath("//div[contains(@class,'install')]//span[contains(text(),'Steam')]"));
  private  String downloadPath = System.getProperty("user.dir") + File.separator;
  private PropertiesReader properties = new PropertiesReader();

  public  boolean isFileDownloaded() {
    steamDownload.click();
    File file = new File(downloadPath + getFileName());
    WebDriverWait wait = new WebDriverWait(Browser.getInstance().returnDriver(), properties.getWaitsForElemetns());
    wait.until(new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor)Browser.getInstance().returnDriver())
                .executeScript("return document.readyState")
                .toString().equals("complete") && isExist(file);
      }
    });
    return true;
  }

  private String getFileName() {
    if (System.getProperty("os.name").contains("Windows")) {
      return properties.getWindows();
    } else {
      return   properties.getLinux();
    }
  }

  public  static boolean isExist(File file) {
    if (file.exists()) {
      return true;
    } else {
      return false;
    }
  }

  public  void checkExistanse() {
    File file = new File(downloadPath + getFileName());
    if (file.exists()) {
      file.delete();
    }
  }

}








