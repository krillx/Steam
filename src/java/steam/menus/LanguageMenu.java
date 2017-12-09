package steam.menus;

import framework.BaseEntity;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class LanguageMenu extends BaseEntity {

  private Button topOfMenu = new Button(By.id("language_pulldown"));
  private Label elementOfMenu;
  private String patternForElementOfMenu = "//div[@id='language_dropdown']//a[contains(text(),%s)]";

  public void changeLanguage(String localeForElementOfMenu) {
    elementOfMenu = new Label(By.xpath(String.format(patternForElementOfMenu,localeForElementOfMenu)));
    topOfMenu.click();
    elementOfMenu.click();
  }
}
