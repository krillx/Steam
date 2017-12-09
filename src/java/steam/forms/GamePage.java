package steam.forms;

import framework.BasePage;
import framework.elements.*;
import org.openqa.selenium.By;

public class GamePage extends BasePage {

  private Label discount = new Label(By.xpath("//div[contains(@class,'pct')]"));
  private Label price = new Label(By.xpath("//div[contains(@class,'purchase')]//div[contains(@class,'final')]"));
  private Button downloadSteamMenu = new Button(By.xpath("//div[@id ='global_action_menu']//a[contains(text(),'Steam')]"));
  private int finalDiscount = 0;
  private double finalPrice = 0;
  private Label gameNameLabel = new Label(By.xpath("//div[contains(@class, 'AppName')]"));
  private Label secondGameNameLabel = new Label(By.xpath("//h2[contains(@class, 'page')]"));

  public int getDiscount() {
    finalDiscount = Integer.parseInt(discount.getText().replaceAll("\\D+", ""));
    return finalDiscount;
  }

  public double getPrice() {
    finalPrice = Double.parseDouble(price.getText().replaceAll("[^0-9\\.]", ""));
    return finalPrice;
  }

  public String getName() {
    if (secondGameNameLabel.isEnabled()) {
      return secondGameNameLabel.getText();
    } else {
      return gameNameLabel.getText();
    }
  }



  public void navigateSteamDownloadPage() {
    downloadSteamMenu.click();
  }
}
