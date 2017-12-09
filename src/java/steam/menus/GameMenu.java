package steam.menus;

import framework.BaseEntity;
import framework.LocalePropertiesReader;
import framework.PropertiesReader;
import framework.elements.Label;
import org.openqa.selenium.By;

public class GameMenu extends BaseEntity {

  private Label topOfMenu;
  private Label elementOfMenu;
  private String patternForTopOfMenu = "//a[@class ='pulldown_desktop' and contains(text() , %s)]";
  private String patternForElementOfMenu = "//a[@class='popup_menu_item' and contains(text(), %s)]";
  private PropertiesReader reader = new PropertiesReader();
  private LocalePropertiesReader properties = new LocalePropertiesReader(reader.getLanguage());

  public enum TopOfMenu {
    GAMES
  }

  public enum ElementOfMenu {
   ACTIONS
  }

  public void navigateMenu(TopOfMenu topOfMenu, ElementOfMenu elementOfMenu) {
    switch (topOfMenu) {
      case GAMES:
        this.topOfMenu = new Label(By.xpath(String.format(patternForTopOfMenu,properties.readGamesLocale())));
    }
    switch (elementOfMenu) {
      case ACTIONS:
        this.elementOfMenu = new Label(By.xpath(String.format(patternForElementOfMenu,properties.readActionLocale())));
    }
    this.topOfMenu.moveToElement();
    this.elementOfMenu.click();
  }
}
